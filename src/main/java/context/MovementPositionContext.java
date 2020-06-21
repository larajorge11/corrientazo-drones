package context;

import domain.Position;
import lombok.Setter;
import strategy.movement.MovementForwardStrategy;

@Setter
public class MovementPositionContext {
    private MovementForwardStrategy movementForwardStrategy;

    public void executeMovement(Position newPosition, int currentXPosition, int currentYPosition) {
        movementForwardStrategy.setMovement(newPosition, currentXPosition, currentYPosition);
    }
}
