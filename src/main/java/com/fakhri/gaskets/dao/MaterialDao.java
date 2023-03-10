package com.fakhri.gaskets.dao;

import com.fakhri.gaskets.dao.impl.JdbcMaterialDao;
import com.fakhri.gaskets.entity.Material;

import java.io.IOException;
import java.util.List;

public interface MaterialDao {
    static MaterialDao getInstance() throws IOException {
        return JdbcMaterialDao.getInstance();
    }
    List<String> getAllUniqueMaterials();
    List<Material> getMaterialsByName(String key);
    Material save(Material material);
}
