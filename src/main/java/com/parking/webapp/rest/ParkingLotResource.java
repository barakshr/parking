package com.parking.webapp.rest;

import com.parking.webapp.rest.pojos.SlotsTable;
import com.parking.webapp.springconfiguration.MainConfiguration;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/parking_lot")
@Consumes("application/json")
@Produces("application/json")
public class ParkingLotResource {

    private final ParkingLotService parkingLotService;


    public ParkingLotResource() {
        this.parkingLotService = MainConfiguration.getBean(ParkingLotService.class);
    }

    @GET
    @Path("/slots_table")
    public Response getTable() {
        try {
            Object slotsTables = parkingLotService.getSlotsTable();
            return Response.status(200).entity(slotsTables).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

    }
}
