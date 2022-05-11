package com.parking.webapp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Dao {
    void setResults(ResultSet resultSet) throws SQLException;
    String getQuery();
    Object getQueryResult();
}
