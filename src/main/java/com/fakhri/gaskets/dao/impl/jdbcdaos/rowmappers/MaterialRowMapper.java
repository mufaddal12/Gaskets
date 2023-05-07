package com.fakhri.gaskets.dao.impl.jdbcdaos.rowmappers;

import com.fakhri.gaskets.dao.impl.jdbcdaos.constants.MaterialsTable;
import com.fakhri.gaskets.entity.Material;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialRowMapper implements RowMapper<Material> {
    @Override
    public Material mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Material.builder()
                .name(rs.getString(MaterialsTable.COLUMNS.MATERIAL_NAME))
                .width(rs.getDouble(MaterialsTable.COLUMNS.WIDTH))
                .height(rs.getDouble(MaterialsTable.COLUMNS.HEIGHT))
                .build();
    }
}
