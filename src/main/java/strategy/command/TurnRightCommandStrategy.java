package strategy.command;

import domain.CardinalDirectionType;
import domain.GeographicalPosition;

public class TurnRightCommandStrategy implements CommandStrategy {

    /**
     * @param geographicalPosition
     */
    @Override
    public void setCommand(GeographicalPosition geographicalPosition) {
        turnRight(geographicalPosition);
    }

    /**
     * @param geographicalPosition
     */
    private void turnRight(GeographicalPosition geographicalPosition) {
        CardinalDirectionType newCardinalDirectionType = geographicalPosition.getCardinalDirectionType();
        if (CardinalDirectionType.N == geographicalPosition.getCardinalDirectionType()) {
            newCardinalDirectionType = CardinalDirectionType.E;
        } else if (CardinalDirectionType.E == geographicalPosition.getCardinalDirectionType()) {
            newCardinalDirectionType = CardinalDirectionType.S;
        } else if (CardinalDirectionType.W == geographicalPosition.getCardinalDirectionType()) {
            newCardinalDirectionType = CardinalDirectionType.N;
        } else if (CardinalDirectionType.S == geographicalPosition.getCardinalDirectionType()) {
            newCardinalDirectionType = CardinalDirectionType.W;
        }

        geographicalPosition.setCardinalDirectionType(newCardinalDirectionType);
    }
}
