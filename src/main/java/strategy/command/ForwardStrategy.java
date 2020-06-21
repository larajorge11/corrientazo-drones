package strategy.command;

import domain.CardinalDirection;
import domain.GeographicalPosition;
import domain.Position;

import static constants.CommonConstants.MOVE_FORWARD;

public class ForwardStrategy implements CommandStrategy {

    /**
     * @param geographicalPosition
     */
    @Override
    public void setMovement(GeographicalPosition geographicalPosition) {
        moveForward(geographicalPosition);
    }

    /**
     * @param geographicalPosition
     */
    private void moveForward(GeographicalPosition geographicalPosition) {
        Position newPosition = Position.builder().build();
        int currentXPosition = geographicalPosition.getPosition().getPositionX();
        int currentYPosition = geographicalPosition.getPosition().getPositionY();

        if (CardinalDirection.N == geographicalPosition.getCardinalDirection()) {
            newPosition.setPositionX(currentXPosition);
            newPosition.setPositionY(currentYPosition + MOVE_FORWARD);
        } else if (CardinalDirection.E == geographicalPosition.getCardinalDirection()) {
            newPosition.setPositionX(currentXPosition + MOVE_FORWARD);
            newPosition.setPositionY(currentYPosition);
        } else if (CardinalDirection.W == geographicalPosition.getCardinalDirection()) {
            newPosition.setPositionX(currentXPosition - MOVE_FORWARD);
            newPosition.setPositionY(currentYPosition);
        } else if (CardinalDirection.S == geographicalPosition.getCardinalDirection()) {
            newPosition.setPositionX(currentXPosition);
            newPosition.setPositionY(currentYPosition - MOVE_FORWARD);
        }

        geographicalPosition.setPosition(newPosition);
    }
}
