package org.fakhri.dao.impl;

import org.fakhri.dao.GasketDao;
import org.fakhri.entity.Gasket;
import org.fakhri.entity.GasketType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonGasketDao implements GasketDao {
    private static String FILE_NAME = "/gaskets.json";

    private static class Keys {
        public static String CLASS = "class";
        public static String TYPES = "types";
        public static String NAME = "name";
        public static String DIMENSIONS = "dimensions";
        public static String SIZE = "size";
        public static String OUTER_DIAMETER = "outer_diameter";
        public static String INNER_DIAMETER = "inner_diameter";
    }

    private static JsonGasketDao jsonGasketDao;

    public static JsonGasketDao getInstance() throws IOException {
        if(jsonGasketDao == null)
            jsonGasketDao = new JsonGasketDao();
        return jsonGasketDao;
    }

    private JSONArray jsonData;
    private Map<String, Integer> classIndices, typeIndices;
    public JsonGasketDao() throws IOException {
        try (InputStream inputStream = getClass().getResourceAsStream(FILE_NAME);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));

            this.jsonData = new JSONArray(contents);
            setupData();
        } catch (Exception e) {
            throw e;
        }
    }

    private void setupData() {
        classIndices = new HashMap<>();
        for(int i = 0; i<jsonData.length(); i++) {
            String className = jsonData.getJSONObject(i).getString(Keys.CLASS);
            classIndices.put(className, i);
        }
        typeIndices = new HashMap<>();
        JSONObject firstJsonObject = jsonData.getJSONObject(0);
        JSONArray typesArray = firstJsonObject.getJSONArray(Keys.TYPES);
        for(int i = 0; i<typesArray.length(); i++) {
            String type = typesArray.getJSONObject(i).getString(Keys.NAME);
            typeIndices.put(type, i);
        }
    }

    @Override
    public List<String> getAllClasses() {
        return new ArrayList<>(classIndices.keySet());
    }

    @Override
    public List<Gasket> getAllByClassTypeAndSize(String gasketClass, GasketType gasketType) {
        String type = gasketType.getKey();

        int classIndex = classIndices.get(gasketClass);
        int typeIndex = typeIndices.get(type);
        JSONObject classObject = jsonData.getJSONObject(classIndex);
        JSONArray dimensionsArray = classObject.getJSONArray(Keys.TYPES)
                .getJSONObject(typeIndex)
                .getJSONArray(Keys.DIMENSIONS);
        List<Gasket> gaskets = new ArrayList<>();
        for(int i = 0; i<dimensionsArray.length(); i++) {
            gaskets.add(buildGasket(dimensionsArray.getJSONObject(i), gasketType, gasketClass));
        }
        return gaskets;
    }

    private Gasket buildGasket(JSONObject dimensionObject, GasketType gasketType, String gasketClass) {
        return Gasket.builder()
                .size(dimensionObject.getString(Keys.SIZE))
                .innerDiameter(dimensionObject.getDouble(Keys.INNER_DIAMETER))
                .outerDiameter(dimensionObject.getDouble(Keys.OUTER_DIAMETER))
                .gClass(gasketClass)
                .type(gasketType)
                .build();
    }
}
