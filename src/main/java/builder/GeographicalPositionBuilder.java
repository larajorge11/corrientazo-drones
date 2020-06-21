/*
 * Copyright (c) 2020
 */
package builder;

import domain.CardinalDirection;
import domain.GeographicalPosition;
import domain.Position;

public class GeographicalPositionBuilder {

    public GeographicalPosition startDronePosition() {
        return GeographicalPosition.builder()
                .cardinalDirection(CardinalDirection.N)
                .position(initialPosition())
                .build();
    }

    private Position initialPosition() {
        return Position.builder()
                .positionX(0)
                .positionY(0)
                .build();
    }
}
