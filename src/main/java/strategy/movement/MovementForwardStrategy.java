package strategy.movement;

import domain.Position;

public interface MovementForwardStrategy {
    void setMovement(Position newPosition, int currentXPosition, int currentYPosition);
}
