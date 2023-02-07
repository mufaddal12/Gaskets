package org.fakhri.dao.impl;

import org.fakhri.dao.GasketDao;
import org.fakhri.entity.Gasket;
import org.fakhri.entity.GasketType;

import java.util.List;

public class TestGasketDao implements GasketDao {

    private static TestGasketDao testGasketDao;

    public static TestGasketDao getInstance() {
        if(testGasketDao == null)
            testGasketDao = new TestGasketDao();
        return testGasketDao;
    }

    @Override
    public List<String> getAllClasses() {
        return List.of(new String[]{"Class 1", "Class 2"});
    }

    @Override
    public List<String> getAllSizes() {
        return List.of(new String[]{"Size 1", "Size 2"});
    }

    @Override
    public List<Gasket> getAllByClassTypeAndSize(String gasketClass, GasketType gasketType) {
        Gasket gasket1 = Gasket.builder()
                .gClass("Class 1")
                .type(GasketType.FULL_FACE)
                .size("Size 1")
                .innerDiameter(1)
                .outerDiameter(2)
                .build();
        Gasket gasket2 = Gasket.builder()
                .gClass("Class 1")
                .type(GasketType.RING_FACE)
                .size("Size 2")
                .innerDiameter(1)
                .outerDiameter(2)
                .build();
        Gasket gasket4 = Gasket.builder()
                .gClass("Class 2")
                .type(GasketType.FULL_FACE)
                .size("Size 2")
                .innerDiameter(1)
                .outerDiameter(2)
                .build();

        return List.of(new Gasket[] {gasket2, gasket4, gasket1});
    }
}
