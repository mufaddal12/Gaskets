package com.fakhri.gaskets.dao;

import com.fakhri.gaskets.dao.impl.JsonGasketDao;
import com.fakhri.gaskets.entity.GasketType;
import com.fakhri.gaskets.entity.Gasket;

import java.io.IOException;
import java.util.List;

public interface GasketDao {
    static GasketDao getInstance() throws IOException {
        return JsonGasketDao.getInstance();
    }
    List<String> getAllClasses();
    List<Gasket> getAllByClassTypeAndSize(String gasketClass, GasketType gasketType);
}
