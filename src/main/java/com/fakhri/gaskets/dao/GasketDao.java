package com.fakhri.gaskets.dao;

import com.fakhri.gaskets.dao.impl.jsondaos.JsonGasketDao;
import com.fakhri.gaskets.entity.GasketType;
import com.fakhri.gaskets.entity.Gasket;

import java.io.IOException;
import java.util.List;

public interface GasketDao {
    static GasketDao getInstance() throws IOException {
        return JsonGasketDao.getInstance();
    }
    List<String> getAllClasses();
    List<Gasket> getAllByClassAndType(String gasketClass, GasketType gasketType);
    Gasket save(Gasket gasket);
}
