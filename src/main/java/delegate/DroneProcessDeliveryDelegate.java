/*
 * Copyright (c) 2020
 */
package delegate;

import builder.GeographicalPositionBuilder;
import delegate.definition.Delegate;
import domain.Drone;
import domain.Restaurant;
import org.apache.commons.collections4.CollectionUtils;
import transformer.DroneFlightTransformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static constants.CommonConstants.DRONES_AMOUNT_MAX;
import static constants.CommonConstants.DRONES_DELIVERY_AMOUNT_MAX;
import static constants.CommonConstants.EXCEED_AMOUNT_DRONES_MESSAGE;
import static constants.CommonConstants.OK_MESSAGE;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static util.FileUtils.listFiles;
import static util.FileUtils.readLinesFile;
import static util.StringUtils.cleanValueString;

public class DroneProcessDeliveryDelegate implements Delegate<String, Restaurant> {

    /**
     * @param deliveryDronePath
     * @return
     * @throws IOException
     */
    @Override
    public Restaurant process(String deliveryDronePath) throws IOException {
        Restaurant restaurant;
        List<Drone> drones = new ArrayList<>();
        final Set<String> dronesDeliveryList = listFiles(deliveryDronePath);
        if (isNotEmpty(dronesDeliveryList) && dronesDeliveryList.size() <= DRONES_AMOUNT_MAX) {
            buildWorkerDroneList(drones, dronesDeliveryList);
            restaurant = new Restaurant(drones, OK_MESSAGE, true);
        } else {
            restaurant = new Restaurant(null, EXCEED_AMOUNT_DRONES_MESSAGE, false);
        }

        return restaurant;
    }

    /**
     * @param drones
     * @param dronesDeliveryList
     * @throws IOException
     */
    private void buildWorkerDroneList(List<Drone> drones, Set<String> dronesDeliveryList) throws IOException {
        GeographicalPositionBuilder positionDelegate = new GeographicalPositionBuilder();
        DroneFlightTransformer droneFlightTransformer = new DroneFlightTransformer();
        for (String droneDelivery : dronesDeliveryList) {
            if (readLinesFile(droneDelivery).size() <= DRONES_DELIVERY_AMOUNT_MAX) {
                List<List<String>> commandList = droneFlightTransformer.moveFlightDrone(droneDelivery);
                if (CollectionUtils.isNotEmpty(commandList)) {
                    drones.add(
                            Drone.builder()
                                    .identification(cleanValueString(droneDelivery))
                                    .geographicalCurrentPosition(positionDelegate.startDronePosition())
                                    .commands(commandList)
                                    .build());
                }
            }
        }
    }
}
