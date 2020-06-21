package strategy.command;

import domain.CardinalDirection;
import domain.GeographicalPosition;
import domain.Position;

import static constants.CommonConstants.MOVE_FORWARD;

public class TurnRightStrategy implements CommandStrategy {

    /**
     * @param geographicalPosition
     */
    @Override
    public void setMovement(GeographicalPosition geographicalPosition) {
        turnRight(geographicalPosition);
    }

    /**
     * @param geographicalPosition
     */
    private void turnRight(GeographicalPosition geographicalPosition) {
        CardinalDirection newCardinalDirection = geographicalPosition.getCardinalDirection();
        if (CardinalDirection.N == geographicalPosition.getCardinalDirection()) {
            newCardinalDirection = CardinalDirection.E;
        } else if (CardinalDirection.E == geographicalPosition.getCardinalDirection()) {
            newCardinalDirection = CardinalDirection.S;
        } else if (CardinalDirection.W == geographicalPosition.getCardinalDirection()) {
            newCardinalDirection = CardinalDirection.N;
        } else if (CardinalDirection.S == geographicalPosition.getCardinalDirection()) {
            newCardinalDirection = CardinalDirection.W;
        }

        geographicalPosition.setCardinalDirection(newCardinalDirection);
    }
}
