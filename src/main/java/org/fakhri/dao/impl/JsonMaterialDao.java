package org.fakhri.dao.impl;

import org.fakhri.dao.MaterialDao;
import org.fakhri.entity.Material;

import java.util.ArrayList;
import java.util.List;

public class JsonMaterialDao implements MaterialDao {

    private static JsonMaterialDao jsonMaterialDao;

    public static JsonMaterialDao getInstance() {
        if(jsonMaterialDao == null)
            jsonMaterialDao = new JsonMaterialDao();
        return jsonMaterialDao;
    }

    @Override
    public List<String> getAllUniqueMaterials() {
        return null;
    }

    @Override
    public List<Material> getMaterialsByKey(String key) {
        return null;
    }
}
