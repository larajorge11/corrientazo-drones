package strategy.command;

import domain.GeographicalPosition;

public interface CommandStrategy {
    void setMovement(GeographicalPosition geographicalPosition);
}
