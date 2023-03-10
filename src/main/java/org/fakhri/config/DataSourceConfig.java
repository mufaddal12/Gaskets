package org.fakhri.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class DataSourceConfig {
    private static DataSource dataSource;

    private DataSourceConfig() {}

    public static DataSource getDataSourceInstance() {
        if(dataSource == null) {
            Properties properties = PropertiesLoader.loadProperties();

            DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
            dataSource1.setDriverClassName(properties.getProperty("datasource.driverClassName"));
            dataSource1.setUrl(properties.getProperty("datasource.url"));
            dataSource1.setUsername(properties.getProperty("datasource.username"));
            dataSource1.setPassword(properties.getProperty("datasource.password"));
            dataSource = dataSource1;
        }
        return dataSource;
    }
}
