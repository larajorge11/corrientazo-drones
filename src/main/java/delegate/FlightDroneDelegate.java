/*
 * Copyright (c) 2020
 */
package delegate;

import context.CommandPositionContext;
import domain.Drone;
import domain.GeographicalPosition;
import domain.Movement;
import domain.Restaurant;
import strategy.command.ForwardStrategy;
import strategy.command.TurnLeftStrategy;
import strategy.command.TurnRightStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FlightDroneDelegate {

    private final Predicate<String> FORWARD_COMMAND = command -> Movement.A.name().equals(command);
    private final Predicate<String> RIGHT_COMMAND = command -> Movement.D.name().equals(command);
    private final Predicate<String> LEFT_COMMAND = command -> Movement.I.name().equals(command);

    /**
     * @param restaurant
     */
    public void moveDrone(Restaurant restaurant) {
        for (Drone drone : restaurant.getDrones()) {
            List<GeographicalPosition> geographicalPositions = new ArrayList<>();
            final List<List<String>> commands = drone.getCommands();
            commands.forEach(command -> {
                geographicalPositions.add(move(command, drone));
            });
            drone.setGeographicalPositionsDelivery(geographicalPositions);
        }
    }

    /**
     * @param commands
     * @param drone
     * @return
     */
    private GeographicalPosition move(List<String> commands, Drone drone) {

        for (String command : commands) {
            setPositionCommandStrategy(drone, command);

        }
        return GeographicalPosition.builder()
                .cardinalDirection(drone.getGeographicalCurrentPosition().getCardinalDirection())
                .position(drone.getGeographicalCurrentPosition().getPosition())
                .build();
    }

    /**
     * @param drone
     * @param command
     */
    private void setPositionCommandStrategy(Drone drone, String command) {
        CommandPositionContext commandPositionContext = new CommandPositionContext();
        if (FORWARD_COMMAND.test(command)) {
            commandPositionContext.setCommandStrategy(new ForwardStrategy());
        }

        if (RIGHT_COMMAND.test(command)) {
            commandPositionContext.setCommandStrategy(new TurnRightStrategy());
        }

        if (LEFT_COMMAND.test(command)) {
            commandPositionContext.setCommandStrategy(new TurnLeftStrategy());
        }

        commandPositionContext.executeCommand(drone.getGeographicalCurrentPosition());
    }
}
