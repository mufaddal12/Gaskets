package org.fakhri.dao.impl;

import org.fakhri.dao.MaterialDao;
import org.fakhri.entity.Material;

import java.util.List;

public class TestMaterialDao implements MaterialDao {

    private static TestMaterialDao testMaterialDao;

    public static TestMaterialDao getInstance() {
        if(testMaterialDao == null)
            testMaterialDao = new TestMaterialDao();
        return testMaterialDao;
    }

    @Override
    public List<String> getAllUniqueMaterials() {
        return List.of(new String[]{"Material 1", "Material 2"});
    }

    @Override
    public List<Material> getMaterialsByKey(String key) {
        Material material1 = Material.builder()
                .name("Material 1")
                .width(1000)
                .height(2000)
                .build();
        Material material2 = Material.builder()
                .name("Material 2")
                .width(3000)
                .height(4000)
                .build();
        Material material3 = Material.builder()
                .name("Material 2")
                .width(5000)
                .height(6000)
                .build();
        Material material4 = Material.builder()
                .name("Material 1")
                .width(7000)
                .height(8000)
                .build();
        Material material5 = Material.builder()
                .name("Material 1")
                .width(9000)
                .height(1000)
                .build();
        switch (key) {
            case "Material 1":
                return List.of(new Material[]{material1, material4, material5});
            default:
                return List.of(new Material[]{material2, material3});
        }
    }
}
