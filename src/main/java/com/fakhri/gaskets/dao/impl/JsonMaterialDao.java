package com.fakhri.gaskets.dao.impl;

import com.fakhri.gaskets.dao.MaterialDao;
import com.fakhri.gaskets.entity.Material;
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
    private static final String FILE_NAME = "/materials.json";

    private static class Keys {
        public static final String NAME = "name";
        public static final String DIMENSIONS = "dimensions";
        public static final String HEIGHT = "height";
        public static final String WIDTH = "width";
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
        InputStream inputStream = getClass().getResourceAsStream(FILE_NAME);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String contents = reader.lines()
                .collect(Collectors.joining(System.lineSeparator()));
        reader.close();
        inputStream.close();
        this.jsonData = new JSONArray(contents);
        setupData();
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

    @Override
    public Material save(Material material) {
        return null;
    }

    private Material buildMaterial(JSONObject dimensionObject, String materialName) {
        return Material.builder()
                .name(materialName)
                .height(dimensionObject.getDouble(Keys.HEIGHT))
                .width(dimensionObject.getDouble(Keys.WIDTH))
                .build();
    }
}
