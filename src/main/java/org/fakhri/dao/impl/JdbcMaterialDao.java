package org.fakhri.dao.impl;

import org.fakhri.config.DataSourceConfig;
import org.fakhri.dao.MaterialDao;
import org.fakhri.entity.Material;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class CONSTANTS {
    public static final String TABLE_NAME = "MATERIAL";

    public static class COLUMNS {
        public static final String MATERIAL_NAME = "MATERIAL_NAME";
        public static final String HEIGHT = "HEIGHT";
        public static final String WIDTH = "WIDTH";
    }
}

public class JdbcMaterialDao implements MaterialDao {


    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JdbcMaterialDao() {
        this(DataSourceConfig.getDataSourceInstance());
    }

    JdbcMaterialDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public List<String> getAllUniqueMaterials() {
        String colName = String.format("DISTINCT(%s)", CONSTANTS.COLUMNS.MATERIAL_NAME);
        String query = String.format("SELECT %s FROM %s",
                colName,
                CONSTANTS.TABLE_NAME);
        return jdbcTemplate.query(query,
                (rs, rowNum) -> rs.getString(colName));
    }

    @Override
    public List<Material> getMaterialsByName(String key) {
        String query = String.format("SELECT %s, %s, %s FROM %s WHERE %s='%s'",
                CONSTANTS.COLUMNS.MATERIAL_NAME,
                CONSTANTS.COLUMNS.HEIGHT,
                CONSTANTS.COLUMNS.WIDTH,
                CONSTANTS.TABLE_NAME,
                CONSTANTS.COLUMNS.MATERIAL_NAME,
                key
                );
        return jdbcTemplate.query(query, new MaterialRowMapper());
    }
}

class MaterialRowMapper implements RowMapper<Material> {

    @Override
    public Material mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Material.builder()
                .name(rs.getString(CONSTANTS.COLUMNS.MATERIAL_NAME))
                .width(rs.getDouble(CONSTANTS.COLUMNS.WIDTH))
                .height(rs.getDouble(CONSTANTS.COLUMNS.HEIGHT))
                .build();
    }
}