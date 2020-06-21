/*
 * Copyright (c) 2020
 */
package init;

import delegate.DroneProcessDeliveryDelegate;
import delegate.FlightDroneDelegate;
import delegate.ReporterDelegate;
import domain.Restaurant;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static constants.CommonConstants.DELIVERY_DRONE_PATH;

public class App {

    private final static Logger LOGGER = Logger.getLogger(App.class.getName());
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String args []) throws IOException {
        DroneProcessDeliveryDelegate droneProcessDeliveryDelegate = new DroneProcessDeliveryDelegate();
        FlightDroneDelegate flightDroneDelegate = new FlightDroneDelegate();
        ReporterDelegate reporterDelegate = new ReporterDelegate();

        Restaurant restaurant = droneProcessDeliveryDelegate.process(DELIVERY_DRONE_PATH);

        if (restaurant.isStatus()) {
            flightDroneDelegate.moveDrone(restaurant);
            reporterDelegate.printFlightDrones(restaurant);
        } else {
            LOGGER.setLevel(Level.SEVERE);
            LOGGER.warning(restaurant.getStatus_message());
        }

    }
}
