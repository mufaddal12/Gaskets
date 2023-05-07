package com.fakhri.gaskets.dao.impl.jdbcdaos;

import com.fakhri.gaskets.config.DataSourceConfig;
import com.fakhri.gaskets.dao.GasketDao;
import com.fakhri.gaskets.dao.impl.jdbcdaos.constants.GasketsTable;
import com.fakhri.gaskets.dao.impl.jdbcdaos.rowmappers.GasketRowMapper;
import com.fakhri.gaskets.entity.Gasket;
import com.fakhri.gaskets.entity.GasketType;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JdbcGasketDao implements GasketDao {

    private static JdbcGasketDao jdbcGasketDao;

    public static JdbcGasketDao getInstance() {
        if(jdbcGasketDao == null) {
            DataSource dataSource = DataSourceConfig.getDataSourceInstance();
            jdbcGasketDao = new JdbcGasketDao(dataSource);
        }
        return jdbcGasketDao;
    }

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private JdbcGasketDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public List<String> getAllClasses() {
        String query = String.format("SELECT DISTINCT(%s) FROM %s",
                GasketsTable.COLUMNS.GASKET_CLASS,
                GasketsTable.TABLE_NAME);
        return jdbcTemplate.query(query,
                (rs, rowNum) -> rs.getString(GasketsTable.COLUMNS.GASKET_CLASS));
    }

    @Override
    public List<Gasket> getAllByClassAndType(String gasketClass, GasketType gasketType) {
        List<String> argList = GasketsTable.COLUMNS.getAllColumnNames();
        List<String> postArg = List.of(GasketsTable.TABLE_NAME,
                GasketsTable.COLUMNS.GASKET_CLASS,
                gasketClass,
                GasketsTable.COLUMNS.GASKET_TYPE,
                gasketType.getKey());
        argList.addAll(postArg);

        String query = String.format("SELECT %s, %s, %s, %s, %s FROM %s WHERE %s='%s' AND %s='%s'",
                argList.toArray(new String[0])
        );
        return jdbcTemplate.query(query, new GasketRowMapper());
    }

    @Override
    public Gasket save(Gasket gasket) {
        String query = generateInsertQuery();
        jdbcTemplate.update(query, Gasket.getParametersInOrder(gasket));
        return gasket;
    }

    private String generateInsertQuery() {
        List<String> argList = Stream.of(GasketsTable.TABLE_NAME).collect(Collectors.toList());
        List<String> postArg = GasketsTable.COLUMNS.getAllColumnNames();
        argList.addAll(postArg);

        return String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?)",
                argList.toArray(new String[0])
        );
    }
}
