package strategy.movement;

import domain.Position;

import static constants.CommonConstants.MOVE_FORWARD;

public class ForwardEastMovementStrategy implements MovementForwardStrategy {

    /**
     * @param newPosition
     * @param currentXPosition
     * @param currentYPosition
     */
    @Override
    public void setMovement(Position newPosition, int currentXPosition, int currentYPosition) {
        newPosition.setPositionX(currentXPosition + MOVE_FORWARD);
        newPosition.setPositionY(currentYPosition);
    }
}
