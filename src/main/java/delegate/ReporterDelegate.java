/*
 * Copyright (c) 2020
 */
package delegate;

import domain.Drone;
import domain.GeographicalPosition;
import domain.Restaurant;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static constants.CommonConstants.MONITOR_DRONE_PATH;
import static constants.CommonConstants.POSITION_DRONE_REPORT;
import static constants.CommonConstants.REPORT_FILE_EXTENSION;
import static constants.CommonConstants.REPORT_FILE_PREFIX;
import static constants.CommonConstants.TITLE_DRONES_REPORT;

public class ReporterDelegate {

    /**
     * @param restaurant
     * @throws IOException
     */
    public void printFlightDrones(Restaurant restaurant) throws IOException {
        for (Drone drone : restaurant.getDrones()) {
            FileWriter fileWriter = new FileWriter(MONITOR_DRONE_PATH + REPORT_FILE_PREFIX + drone.getIdentification() + REPORT_FILE_EXTENSION);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(TITLE_DRONES_REPORT);
            for (GeographicalPosition geographicalPosition : drone.getGeographicalPositionsDelivery()) {
                printWriter.printf(POSITION_DRONE_REPORT,
                        geographicalPosition.getPosition().getPositionX(),
                        geographicalPosition.getPosition().getPositionY(),
                        geographicalPosition.getCardinalDirectionType().getDescription());
            }

            printWriter.close();
        }


    }
}
