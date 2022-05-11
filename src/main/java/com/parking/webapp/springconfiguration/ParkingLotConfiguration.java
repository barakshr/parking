package com.parking.webapp.springconfiguration;

import com.parking.webapp.rest.ParkingLotService;
import com.parking.webapp.sql.JDBCPostgres;
import org.springframework.context.annotation.Bean;

class ParkingLotConfiguration {

    @Bean
    ParkingLotService parkingLotService(JDBCPostgres jdbcPostgres) {
        return new ParkingLotService(jdbcPostgres);
    }

    @Bean
    JDBCPostgres jdbcPostgres() {
        return new JDBCPostgres("parking_lot_management");
    }


}
