package context;

import domain.GeographicalPosition;
import strategy.command.CommandStrategy;
import lombok.Setter;

@Setter
public class CommandPositionContext {
    private CommandStrategy commandStrategy;

    /**
     * @param geographicalPosition
     */
    public void executeCommand(GeographicalPosition geographicalPosition) {
        commandStrategy.setMovement(geographicalPosition);
    }
}
