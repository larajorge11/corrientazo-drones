package strategy.command;

import domain.GeographicalPosition;

public interface CommandStrategy {
    void setCommand(GeographicalPosition geographicalPosition);
}
