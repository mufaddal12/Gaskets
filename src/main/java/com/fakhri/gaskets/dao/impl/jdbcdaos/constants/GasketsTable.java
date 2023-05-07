package com.fakhri.gaskets.dao.impl.jdbcdaos.constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GasketsTable {
    public static final String TABLE_NAME = "GASKETS";

    private GasketsTable() {
    }

    public static class COLUMNS {
        public static final String GASKET_CLASS = "GASKET_CLASS";
        public static final String GASKET_SIZE = "GASKET_SIZE";
        public static final String GASKET_TYPE = "GASKET_TYPE";
        public static final String INNER_DIAMETER = "INNER_DIAMETER";
        public static final String OUTER_DIAMETER = "OUTER_DIAMETER";

        private COLUMNS() {
        }

        public static List<String> getAllColumnNames() {
            return Stream.of(
                    GASKET_CLASS,
                    GASKET_SIZE,
                    GASKET_TYPE,
                    INNER_DIAMETER,
                    OUTER_DIAMETER
                ).collect(Collectors.toList());
        }
    }
}
