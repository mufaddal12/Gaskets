package org.fakhri.dao;

import org.fakhri.dao.impl.JsonMaterialDao;
import org.fakhri.entity.Material;

import java.io.IOException;
import java.util.List;

public interface MaterialDao {
    static MaterialDao getInstance() throws IOException {
        return JsonMaterialDao.getInstance();
    }
    List<String> getAllUniqueMaterials();
    List<Material> getMaterialsByKey(String key);
}
