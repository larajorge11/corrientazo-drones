package strategy.movement;

import domain.Position;

import static constants.CommonConstants.MOVE_FORWARD;

public class ForwardSouthMovementStrategy implements MovementForwardStrategy {

    @Override
    public void setMovement(Position newPosition, int currentXPosition, int currentYPosition) {
        newPosition.setPositionX(currentXPosition);
        newPosition.setPositionY(currentYPosition - MOVE_FORWARD);
    }
}
