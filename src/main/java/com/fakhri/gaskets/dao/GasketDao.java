package com.fakhri.gaskets.dao;

import com.fakhri.gaskets.dao.impl.jsondaos.JsonGasketDao;
import com.fakhri.gaskets.entity.Gasket;
import com.fakhri.gaskets.entity.GasketType;

import java.util.List;

public interface GasketDao {
    static GasketDao getInstance() {
        return JsonGasketDao.getInstance();
    }
    List<String> getAllClasses();
    List<Gasket> getAllByClassAndType(String gasketClass, GasketType gasketType);
    Gasket save(Gasket gasket);
}
