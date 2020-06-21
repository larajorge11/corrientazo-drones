package strategy.command;

import context.MovementPositionContext;
import domain.CardinalDirectionType;
import domain.GeographicalPosition;
import domain.Position;
import strategy.movement.ForwardEastMovementStrategy;
import strategy.movement.ForwardNorthMovementStrategy;
import strategy.movement.ForwardSouthMovementStrategy;
import strategy.movement.ForwardWestMovementStrategy;

import java.util.function.Predicate;

public class ForwardCommandStrategy implements CommandStrategy {

    private final Predicate<GeographicalPosition> NORTH_DIRECTION = geographicalPosition ->
            CardinalDirectionType.N == geographicalPosition.getCardinalDirectionType();

    private final Predicate<GeographicalPosition> EAST_DIRECTION = geographicalPosition ->
            CardinalDirectionType.E == geographicalPosition.getCardinalDirectionType();

    private final Predicate<GeographicalPosition> WEST_DIRECTION = geographicalPosition ->
            CardinalDirectionType.W == geographicalPosition.getCardinalDirectionType();

    private final Predicate<GeographicalPosition> SOUTH_DIRECTION = geographicalPosition ->
            CardinalDirectionType.S == geographicalPosition.getCardinalDirectionType();



    /**
     * @param geographicalPosition
     */
    @Override
    public void setCommand(GeographicalPosition geographicalPosition) {
        moveForward(geographicalPosition);
    }

    /**
     * @param geographicalPosition
     */
    private void moveForward(GeographicalPosition geographicalPosition) {
        Position newPosition = Position.builder().build();
        int currentXPosition = geographicalPosition.getPosition().getPositionX();
        int currentYPosition = geographicalPosition.getPosition().getPositionY();

        MovementPositionContext movementPositionContext = new MovementPositionContext();
        if (NORTH_DIRECTION.test(geographicalPosition)) {
            movementPositionContext.setMovementForwardStrategy(new ForwardNorthMovementStrategy());
        }
        if (EAST_DIRECTION.test(geographicalPosition)) {
            movementPositionContext.setMovementForwardStrategy(new ForwardEastMovementStrategy());
        }
        if (WEST_DIRECTION.test(geographicalPosition)) {
            movementPositionContext.setMovementForwardStrategy(new ForwardWestMovementStrategy());
        }
        if (SOUTH_DIRECTION.test(geographicalPosition)) {
            movementPositionContext.setMovementForwardStrategy(new ForwardSouthMovementStrategy());
        }

        movementPositionContext.executeMovement(newPosition, currentXPosition, currentYPosition);
        geographicalPosition.setPosition(newPosition);
    }
}
