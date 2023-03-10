package com.fakhri.gaskets.dao.impl;

import com.fakhri.gaskets.config.DataSourceConfig;
import com.fakhri.gaskets.dao.MaterialDao;
import com.fakhri.gaskets.entity.Material;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class CONSTANTS {
    public static final String TABLE_NAME = "MATERIAL";

    private CONSTANTS() {}

    public static class COLUMNS {
        public static final String MATERIAL_NAME = "MATERIAL_NAME";
        public static final String HEIGHT = "HEIGHT";
        public static final String WIDTH = "WIDTH";

        private COLUMNS() {}
    }
}

public class JdbcMaterialDao implements MaterialDao {

    private static JdbcMaterialDao jdbcMaterialDao;

    public static JdbcMaterialDao getInstance() throws IOException {
        if(jdbcMaterialDao == null)
            jdbcMaterialDao = new JdbcMaterialDao();
        return jdbcMaterialDao;
    }

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JdbcMaterialDao() throws IOException {
        this(DataSourceConfig.getDataSourceInstance());
    }

    JdbcMaterialDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public List<String> getAllUniqueMaterials() {
        String query = String.format("SELECT DISTINCT(%s) FROM %s",
                CONSTANTS.COLUMNS.MATERIAL_NAME,
                CONSTANTS.TABLE_NAME);
        return jdbcTemplate.query(query,
                (rs, rowNum) -> rs.getString(CONSTANTS.COLUMNS.MATERIAL_NAME));
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

    @Override
    public Material save(Material material) {
        String query = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)",
            CONSTANTS.TABLE_NAME,
            CONSTANTS.COLUMNS.MATERIAL_NAME,
            CONSTANTS.COLUMNS.HEIGHT,
            CONSTANTS.COLUMNS.WIDTH
        );
        jdbcTemplate.update(query, material.getName(), material.getHeight(), material.getWidth());
        return material;
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