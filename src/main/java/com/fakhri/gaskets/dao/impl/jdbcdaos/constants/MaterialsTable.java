package com.fakhri.gaskets.dao.impl.jdbcdaos.constants;

import com.fakhri.gaskets.entity.Material;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaterialsTable {
    public static final String TABLE_NAME = "MATERIAL";

    private MaterialsTable() {
    }

    public static class COLUMNS {
        public static final String MATERIAL_NAME = "MATERIAL_NAME";
        public static final String HEIGHT = "HEIGHT";
        public static final String WIDTH = "WIDTH";

        private COLUMNS() {
        }

        public static List<String> getAllColumnNames() {
            return Arrays.asList(
                    MATERIAL_NAME,
                    HEIGHT,
                    WIDTH
            ).stream().collect(Collectors.toList());
        }

        public static Object[] getObjectListInOrder(Material material) {
            return new Object[] {
                    material.getName(),
                    material.getHeight(),
                    material.getWidth()
            };
        }

    }
}
