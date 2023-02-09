package org.fakhri.dao;

import org.fakhri.dao.impl.JsonGasketDao;
import org.fakhri.entity.Gasket;
import org.fakhri.entity.GasketType;

import java.io.IOException;
import java.util.List;

public interface GasketDao {
    static GasketDao getInstance() throws IOException {
        return JsonGasketDao.getInstance();
    }
    List<String> getAllClasses();
    List<Gasket> getAllByClassTypeAndSize(String gasketClass, GasketType gasketType);
}
