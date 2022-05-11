package com.parking.webapp.rest.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SlotsTable {

    private final int id;
    private final int parkingLotId;
    private final boolean occupied;

    @JsonCreator
    public SlotsTable(@JsonProperty("id") int id,
                      @JsonProperty("parkingLotId") int parkingLotId,
                      @JsonProperty("occupied") boolean occupied) {
        this.id = id;
        this.parkingLotId = parkingLotId;
        this.occupied = occupied;
    }

    public static SlotsTableBuilder builder() {
        return new SlotsTableBuilder();
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("parkingLotId")
    public int getParkingLotId() {
        return parkingLotId;
    }

    @JsonProperty("occupied")
    public boolean isOccupied() {
        return occupied;
    }

    private static class SlotsTableBuilder {

        private int id;
        private int parkingLotId;
        private boolean occupied;

        public SlotsTableBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public SlotsTableBuilder setParkingLotId(int parkingLotId) {
            this.parkingLotId = parkingLotId;
            return this;
        }

        public SlotsTableBuilder setOccupied(boolean occupied) {
            this.occupied = occupied;
            return this;
        }

        SlotsTable build() {
            return new SlotsTable(id, parkingLotId, occupied);
        }

    }
}
