package com.fakhri.gaskets.dao.impl.jdbcdaos;

import com.fakhri.gaskets.config.DataSourceConfig;
import com.fakhri.gaskets.dao.MaterialDao;
import com.fakhri.gaskets.dao.impl.jdbcdaos.constants.MaterialsTable;
import com.fakhri.gaskets.dao.impl.jdbcdaos.rowmappers.MaterialRowMapper;
import com.fakhri.gaskets.entity.Material;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JdbcMaterialDao implements MaterialDao {

    private static JdbcMaterialDao jdbcMaterialDao;

    public static JdbcMaterialDao getInstance() {
        if(jdbcMaterialDao == null) {
            DataSource dataSource = DataSourceConfig.getDataSourceInstance();
            jdbcMaterialDao = new JdbcMaterialDao(dataSource);
        }
        return jdbcMaterialDao;
    }

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private JdbcMaterialDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public List<String> getAllUniqueMaterials() {
        String query = String.format("SELECT DISTINCT(%s) FROM %s",
                MaterialsTable.COLUMNS.MATERIAL_NAME,
                MaterialsTable.TABLE_NAME);
        return jdbcTemplate.query(query,
                (rs, rowNum) -> rs.getString(MaterialsTable.COLUMNS.MATERIAL_NAME));
    }

    @Override
    public List<Material> getMaterialsByName(String key) {

        List<String> argList = MaterialsTable.COLUMNS.getAllColumnNames();
        List<String> postArg = Arrays.asList(
                MaterialsTable.TABLE_NAME,
                MaterialsTable.COLUMNS.MATERIAL_NAME,
                key);

        argList.addAll(postArg);

        String query = String.format("SELECT %s, %s, %s FROM %s WHERE %s='%s'",
                argList.toArray(new String[0])
                );
        return jdbcTemplate.query(query, new MaterialRowMapper());
    }

    @Override
    public Material save(Material material) {
        String query = generateInsertQuery();
        jdbcTemplate.update(query, MaterialsTable.COLUMNS.getObjectListInOrder(material));
        return material;
    }

    private String generateInsertQuery() {
        List<String> argList = Arrays.asList(MaterialsTable.TABLE_NAME)
                .stream()
                .collect(Collectors.toList());

        List<String> postArg = MaterialsTable.COLUMNS.getAllColumnNames();

        argList.addAll(postArg);

        return String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)",
                argList.toArray(new String[0])
        );
    }
}

