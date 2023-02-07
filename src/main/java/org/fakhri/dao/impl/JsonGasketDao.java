package org.fakhri.dao.impl;

import org.fakhri.dao.GasketDao;
import org.fakhri.entity.Gasket;
import org.fakhri.entity.GasketType;

import java.util.List;

public class JsonGasketDao implements GasketDao {

    private static JsonGasketDao jsonGasketDao;

    public static JsonGasketDao getInstance() {
        if(jsonGasketDao == null)
            jsonGasketDao = new JsonGasketDao();
        return jsonGasketDao;
    }

    @Override
    public List<String> getAllClasses() {
        return null;
    }

    @Override
    public List<String> getAllSizes() {
        return null;
    }

    @Override
    public List<Gasket> getAllByClassTypeAndSize(String gasketClass, GasketType gasketType) {
        return null;
    }
}
