package com.parking.webapp.springconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfiguration {

    private static AnnotationConfigApplicationContext annotationConfigApplicationContext;

    public MainConfiguration() {
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ParkingLotConfiguration.class);
    }

    public static <T> T getBean(Class<T> tClass) {
        return annotationConfigApplicationContext.getBean(tClass);
    }

}
