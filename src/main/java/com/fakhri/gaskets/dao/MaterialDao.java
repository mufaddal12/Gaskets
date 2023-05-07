package com.fakhri.gaskets.dao;

import com.fakhri.gaskets.dao.impl.jdbcdaos.JdbcMaterialDao;
import com.fakhri.gaskets.entity.Material;

import java.util.List;

public interface MaterialDao {
    static MaterialDao getInstance() {
        return JdbcMaterialDao.getInstance();
    }
    List<String> getAllUniqueMaterials();
    List<Material> getMaterialsByName(String key);
    Material save(Material material);
}
