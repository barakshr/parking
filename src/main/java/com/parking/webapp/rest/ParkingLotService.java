package com.parking.webapp.rest;

import com.parking.webapp.daos.Dao;
import com.parking.webapp.daos.TableSlotDao;
import com.parking.webapp.sql.JDBCPostgres;

import java.sql.SQLException;
import java.util.Optional;

public class ParkingLotService {

    private final JDBCPostgres jdbcPostgres;

    public ParkingLotService(JDBCPostgres jdbcPostgres) {
        this.jdbcPostgres = jdbcPostgres;
    }


    Object getSlotsTable() throws SQLException {
        return getResults(TableSlotDao.class);
    }

    private <T extends Dao> Object getResults(Class<T> tClass) throws SQLException {
        Optional<Dao> daoQueryResult = jdbcPostgres.getGenericDaoQueryResult(tClass);
        if (!daoQueryResult.isPresent()) {
            throw new SQLException("error");
        }
        return daoQueryResult.get().getQueryResult();
    }


}
