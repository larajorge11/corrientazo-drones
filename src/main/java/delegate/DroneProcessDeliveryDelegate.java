/*
 * Copyright (c) 2020
 */
package delegate;

import builder.GeographicalPositionBuilder;
import delegate.definition.Delegate;
import domain.Drone;
import domain.Restaurant;
import transformer.DroneFlightTransformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;
import static util.FileUtils.listFiles;
import static util.StringUtils.cleanValueString;

public class DroneProcessDeliveryDelegate implements Delegate<String, Restaurant> {

    /**
     * @param deliveryDronePath
     * @return
     * @throws IOException
     */
    @Override
    public Restaurant process(String deliveryDronePath) throws IOException {
        List<Drone> drones = new ArrayList<>();
        final Set<String> dronesDeliveryList = listFiles(deliveryDronePath);
        if (isNotEmpty(dronesDeliveryList)) {
            buildWorkerDroneList(drones, dronesDeliveryList);
        }
        return new Restaurant(drones);
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
            drones.add(
                    Drone.builder()
                    .identification(cleanValueString(droneDelivery))
                    .geographicalCurrentPosition(positionDelegate.startDronePosition())
                    .commands(droneFlightTransformer.moveFlightDrone(droneDelivery))
                    .build());
        }
    }
}
