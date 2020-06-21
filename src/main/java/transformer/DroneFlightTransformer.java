/*
 * Copyright (c) 2020
 */
package transformer;

import domain.MovementType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static constants.CommonConstants.DISTANCE_PERIMETER_MAX;
import static org.apache.commons.lang3.StringUtils.countMatches;
import static util.FileUtils.readLinesFile;

public class DroneFlightTransformer {

    private final Predicate<Integer> IS_FORWARD_MOVEMENT = s -> MovementType.A.name().equals(String.valueOf(Character.toChars(s)));
    private final Predicate<Integer> IS_RIGHT_MOVEMENT = s -> MovementType.D.name().equals(String.valueOf(Character.toChars(s)));

    public List<List<String>> moveFlightDrone(String droneFile) throws IOException {
        List<List<String>> deliveries = new ArrayList<>();
        final List<String> lines = readLinesFile(droneFile);
        if (!isAnyDeliveryOutsidePerimeter(lines)) {
            for (String lineFile : lines) {
                getListDeliveriesDrone(deliveries, lineFile);
            }
        }
        return deliveries;
    }

    private boolean isAnyDeliveryOutsidePerimeter(List<String> lines) {
        return lines.stream().anyMatch(s -> countMatches(s, MovementType.A.name()) > DISTANCE_PERIMETER_MAX);
    }

    private void getListDeliveriesDrone(List<List<String>> deliveries, String lineFile) {
        deliveries.add(lineFile.chars()
                .mapToObj(x -> mapMovement(x))
                .collect(Collectors.toList()));
    }

    private String mapMovement(int charValue) {
        String listData;
        if (IS_FORWARD_MOVEMENT.test(charValue)) {
            listData = MovementType.A.name();
        } else if (IS_RIGHT_MOVEMENT.test(charValue)) {
            listData = MovementType.D.name();
        } else {
            listData = MovementType.I.name();
        }
        return listData;
    }
}
