package strategy.command;

import domain.CardinalDirectionType;
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
        CardinalDirectionType newCardinalDirectionType = geographicalPosition.getCardinalDirectionType();
        if (CardinalDirectionType.N == geographicalPosition.getCardinalDirectionType()) {
            newCardinalDirectionType = CardinalDirectionType.W;
        } else if (CardinalDirectionType.E == geographicalPosition.getCardinalDirectionType()) {
            newCardinalDirectionType = CardinalDirectionType.N;
        } else if (CardinalDirectionType.W == geographicalPosition.getCardinalDirectionType()) {
            newCardinalDirectionType = CardinalDirectionType.S;
        } else if (CardinalDirectionType.S == geographicalPosition.getCardinalDirectionType()) {
            newCardinalDirectionType = CardinalDirectionType.E;
        }

        geographicalPosition.setCardinalDirectionType(newCardinalDirectionType);
    }
}
