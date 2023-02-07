package org.fakhri.dao;

import org.fakhri.dao.impl.JsonGasketDao;
import org.fakhri.dao.impl.TestGasketDao;
import org.fakhri.entity.Gasket;
import org.fakhri.entity.GasketType;

import java.util.List;

public interface GasketDao {
    static GasketDao getInstance() {
        return TestGasketDao.getInstance();
    }
    List<String> getAllClasses();
    List<String> getAllSizes();
    List<Gasket> getAllByClassTypeAndSize(String gasketClass, GasketType gasketType);
}
