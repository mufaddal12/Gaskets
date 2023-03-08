package org.fakhri.dao;

import org.fakhri.dao.impl.JdbcMaterialDao;
import org.fakhri.entity.Material;

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
