package com.fakhri.gaskets.dao.impl.jdbcdaos.rowmappers;

import com.fakhri.gaskets.dao.impl.jdbcdaos.constants.GasketsTable;
import com.fakhri.gaskets.entity.Gasket;
import com.fakhri.gaskets.entity.GasketType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GasketRowMapper implements RowMapper<Gasket> {
    @Override
    public Gasket mapRow(ResultSet rs, int i) throws SQLException {
        return Gasket.builder()
                .gasketClass(rs.getString(GasketsTable.COLUMNS.GASKET_CLASS))
                .type(GasketType.valueOf(rs.getString(GasketsTable.COLUMNS.GASKET_TYPE)))
                .size(rs.getString(GasketsTable.COLUMNS.GASKET_SIZE))
                .innerDiameter(rs.getDouble(GasketsTable.COLUMNS.INNER_DIAMETER))
                .outerDiameter(rs.getDouble(GasketsTable.COLUMNS.OUTER_DIAMETER))
                .build();
    }
}
