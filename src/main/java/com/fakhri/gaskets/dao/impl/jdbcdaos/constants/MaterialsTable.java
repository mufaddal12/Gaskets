package com.fakhri.gaskets.dao.impl.jdbcdaos.constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            return Stream.of(
                    MATERIAL_NAME,
                    HEIGHT,
                    WIDTH
                ).collect(Collectors.toList());
        }

    }
}
