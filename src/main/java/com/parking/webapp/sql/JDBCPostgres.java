package com.parking.webapp.sql;

import com.parking.webapp.daos.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.Properties;

public class JDBCPostgres {

    private final String url;
    private final Properties properties;

    public JDBCPostgres(String schema) {
        this.url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=" + schema;
        this.properties = new Properties();
        properties.setProperty("user", "postgres");
        properties.setProperty("password", "postgres");
    }


    @SuppressWarnings("unchecked")
    public <T extends Dao> Optional<Dao> getGenericDaoQueryResult(Class<T> tClass) {
        return (Optional<Dao>) getSpecificDaoQueryResult(tClass);
    }

    @SuppressWarnings("CallToDriverManagerGetConnection")
    public <T extends Dao> Optional<T> getSpecificDaoQueryResult(Class<T> tClass) {
        try (Connection conn = DriverManager.getConnection(url, properties)) {
            try (Statement statement = conn.createStatement()) {
                T dao = tClass.newInstance();
                boolean success = statement.execute(dao.getQuery());
                if (!success) {
                    return Optional.empty();
                }
                try (ResultSet resultSet = statement.getResultSet()) {
                    dao.setResults(resultSet);
                    return Optional.of(dao);
                }

            }
        } catch (Exception ignored) {
        }
        return Optional.empty();
    }
}
