package org.fakhri.dao.impl;

import org.fakhri.dao.MaterialDao;
import org.fakhri.entity.Material;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonMaterialDao implements MaterialDao {
    private static String FILE_NAME = "/materials.json";

    private static class Keys {
        public static String NAME = "name";
        public static String DIMENSIONS = "dimensions";
        public static String HEIGHT = "height";
        public static String WIDTH = "width";
    }

    private static JsonMaterialDao jsonMaterialDao;

    public static JsonMaterialDao getInstance() throws IOException {
        if(jsonMaterialDao == null)
            jsonMaterialDao = new JsonMaterialDao();
        return jsonMaterialDao;
    }

    private JSONArray jsonData;
    private Map<String, Integer> materialIndices;
    public JsonMaterialDao() throws IOException {
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
        materialIndices = new HashMap<>();
        for(int i = 0; i<jsonData.length(); i++) {
            String materialName = jsonData.getJSONObject(i).getString(Keys.NAME);
            materialIndices.put(materialName, i);
        }
    }

    @Override
    public List<String> getAllUniqueMaterials() {
        return new ArrayList<>(materialIndices.keySet());
    }

    @Override
    public List<Material> getMaterialsByName(String key) {
        int materialIndex = materialIndices.get(key);
        JSONArray dimensionArray = jsonData.getJSONObject(materialIndex).getJSONArray(Keys.DIMENSIONS);

        List<Material> materials = new ArrayList<>();

        for(int i = 0; i<dimensionArray.length(); i++) {
            materials.add(buildMaterial(dimensionArray.getJSONObject(i), key));
        }

        return materials;
    }

    private Material buildMaterial(JSONObject dimensionObject, String materialName) {
        return Material.builder()
                .name(materialName)
                .height(dimensionObject.getDouble(Keys.HEIGHT))
                .width(dimensionObject.getDouble(Keys.WIDTH))
                .build();
    }
}
