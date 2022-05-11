package com.parking.webapp.daos;

import com.parking.webapp.rest.pojos.SlotsTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableSlotDao implements Dao {

    private static final String QUERY = "select * from parking_lot_management.slots";
    private final List<SlotsTable> slotsTablesList = new ArrayList<>();


    @Override
    public void setResults(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int parkingLotId = resultSet.getInt("parking_lot_id");
            boolean occupied = resultSet.getBoolean("occupied");
            SlotsTable slotsTable = new SlotsTable(id, parkingLotId, occupied);
            slotsTablesList.add(slotsTable);
        }
    }

    @Override
    public String getQuery() {
        return QUERY;
    }

    @Override
    public Object getQueryResult() {
        return slotsTablesList;
    }
}
