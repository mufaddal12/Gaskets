package org.fakhri.dao;

import org.fakhri.dao.impl.JsonMaterialDao;
import org.fakhri.dao.impl.TestMaterialDao;
import org.fakhri.entity.Material;

import java.util.List;

public interface MaterialDao {
    static MaterialDao getInstance() {
        return TestMaterialDao.getInstance();
    }
    List<String> getAllUniqueMaterials();
    List<Material> getMaterialsByKey(String key);
}
