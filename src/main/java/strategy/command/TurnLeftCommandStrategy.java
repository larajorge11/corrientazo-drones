package strategy.command;

import domain.CardinalDirection;
import domain.GeographicalPosition;

public class TurnLeftCommandStrategy implements CommandStrategy {

    /**
     * @param geographicalPosition
     */
    @Override
    public void setCommand(GeographicalPosition geographicalPosition) {
        turnLeft(geographicalPosition);
    }

    /**
     * @param geographicalPosition
     */
    private void turnLeft(GeographicalPosition geographicalPosition) {
        CardinalDirection newCardinalDirection = geographicalPosition.getCardinalDirection();
        if (CardinalDirection.N == geographicalPosition.getCardinalDirection()) {
            newCardinalDirection = CardinalDirection.W;
        } else if (CardinalDirection.E == geographicalPosition.getCardinalDirection()) {
            newCardinalDirection = CardinalDirection.N;
        } else if (CardinalDirection.W == geographicalPosition.getCardinalDirection()) {
            newCardinalDirection = CardinalDirection.S;
        } else if (CardinalDirection.S == geographicalPosition.getCardinalDirection()) {
            newCardinalDirection = CardinalDirection.E;
        }

        geographicalPosition.setCardinalDirection(newCardinalDirection);
    }
}
