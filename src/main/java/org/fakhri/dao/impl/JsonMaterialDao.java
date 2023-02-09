package org.fakhri.dao.impl;

import org.fakhri.dao.MaterialDao;
import org.fakhri.entity.Material;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonMaterialDao implements MaterialDao {
    private static String FILE_NAME = "src/main/resources/materials.json";

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
        this.jsonData = new JSONArray(Files.readString(Path.of(FILE_NAME)));
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
    public List<Material> getMaterialsByKey(String key) {
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

    public static void main(String []args) throws IOException {
        MaterialDao dao = getInstance();
        System.out.println(dao.getAllUniqueMaterials());
        System.out.println(dao.getMaterialsByKey("CNAF"));
    }

}
