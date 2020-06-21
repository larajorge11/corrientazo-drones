/*
 * Copyright (c) 2020
 */
package transformer;

import domain.Movement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static constants.CommonConstants.DELIVERY_DRONE_PATH;

public class DroneFlightTransformer {

    private final Predicate<Integer> IS_FORWARD_MOVEMENT = s -> Movement.A.name().equals(String.valueOf(Character.toChars(s)));
    private final Predicate<Integer> IS_RIGHT_MOVEMENT = s -> Movement.D.name().equals(String.valueOf(Character.toChars(s)));

    public List<List<String>> moveFlightDrone(String droneFile) throws IOException {
        final List<String> lines = Files.readAllLines(Paths.get(DELIVERY_DRONE_PATH + droneFile));
        List<List<String>> deliveries = new ArrayList<>();
        for (String lineFile : lines) {
            getListDeliveriesDrone(deliveries, lineFile);
        }
        return deliveries;
    }

    private void getListDeliveriesDrone(List<List<String>> deliveries, String lineFile) {
        deliveries.add(lineFile.chars()
                .mapToObj(x -> mapMovement(x))
                .collect(Collectors.toList()));
    }

    private String mapMovement(int charValue) {
        String listData;
        if (IS_FORWARD_MOVEMENT.test(charValue)) {
            listData = Movement.A.name();
        } else if (IS_RIGHT_MOVEMENT.test(charValue)) {
            listData = Movement.D.name();
        } else {
            listData = Movement.I.name();
        }
        return listData;
    }
}
