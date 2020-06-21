/*
 * Copyright (c) 2020
 */
package builder;

import domain.CardinalDirectionType;
import domain.GeographicalPosition;
import domain.Position;

public class GeographicalPositionBuilder {

    public GeographicalPosition startDronePosition() {
        return GeographicalPosition.builder()
                .cardinalDirectionType(CardinalDirectionType.N)
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
