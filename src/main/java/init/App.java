/*
 * Copyright (c) 2020
 */
package init;

import delegate.DroneProcessDeliveryDelegate;
import delegate.FlightDroneDelegate;
import delegate.ReporterDelegate;
import domain.Restaurant;

import java.io.IOException;

import static constants.CommonConstants.DELIVERY_DRONE_PATH;

public class App {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String args []) throws IOException {
        DroneProcessDeliveryDelegate droneProcessDeliveryDelegate = new DroneProcessDeliveryDelegate();
        FlightDroneDelegate flightDroneDelegate = new FlightDroneDelegate();
        ReporterDelegate reporterDelegate = new ReporterDelegate();

        Restaurant restaurant = droneProcessDeliveryDelegate.process(DELIVERY_DRONE_PATH);

        flightDroneDelegate.moveDrone(restaurant);

        reporterDelegate.printFlightDrones(restaurant);
    }
}
