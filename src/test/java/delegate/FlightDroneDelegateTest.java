package delegate;

import domain.CardinalDirectionType;
import domain.Drone;
import domain.GeographicalPosition;
import domain.MovementType;
import domain.Position;
import domain.Restaurant;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FlightDroneDelegateTest {

    private FlightDroneDelegate flightDroneDelegate;
    private final Predicate<Integer> IS_FORWARD_MOVEMENT = s -> MovementType.A.name().equals(String.valueOf(Character.toChars(s)));
    private final Predicate<Integer> IS_RIGHT_MOVEMENT = s -> MovementType.D.name().equals(String.valueOf(Character.toChars(s)));

    @Before
    public void setUp() {
        flightDroneDelegate = new FlightDroneDelegate();
    }

    @Test
    public void testMovementOneDrone() {
        List<Drone> drones = new ArrayList<>();
        drones.add(buildDrone("01", 0,0, CardinalDirectionType.N, new ArrayList<>(Arrays.asList("AAAAIAA", "DDDAIAD", "AAIADAD"))));

        Restaurant corrientazoRestaurant = new Restaurant(drones);

        flightDroneDelegate.moveDrone(corrientazoRestaurant);
        assertThat(corrientazoRestaurant.getDrones().size(), is(1));
        assertThat(corrientazoRestaurant.getDrones().get(0).getIdentification(), is("01"));
        final List<GeographicalPosition> geographicalPositionsDelivery = corrientazoRestaurant.getDrones().get(0).getGeographicalPositionsDelivery();
        assertThat(geographicalPositionsDelivery.size(), is(3));

        assertThat(geographicalPositionsDelivery.get(0).getPosition().getPositionX(), is(-2));
        assertThat(geographicalPositionsDelivery.get(0).getPosition().getPositionY(), is(4));
        assertThat(geographicalPositionsDelivery.get(0).getCardinalDirectionType(), is(CardinalDirectionType.W));

        assertThat(geographicalPositionsDelivery.get(1).getPosition().getPositionX(), is(-1));
        assertThat(geographicalPositionsDelivery.get(1).getPosition().getPositionY(), is(3));
        assertThat(geographicalPositionsDelivery.get(1).getCardinalDirectionType(), is(CardinalDirectionType.S));

        assertThat(geographicalPositionsDelivery.get(2).getPosition().getPositionX(), is(0));
        assertThat(geographicalPositionsDelivery.get(2).getPosition().getPositionY(), is(0));
        assertThat(geographicalPositionsDelivery.get(2).getCardinalDirectionType(), is(CardinalDirectionType.W));
    }

    private Drone buildDrone(String id, int x, int y, CardinalDirectionType cardinalDirectionType, List<String> commands) {
        return Drone.builder()
                .identification(id)
                .geographicalCurrentPosition(buildGeographicalPosition(x,y, cardinalDirectionType))
                .commands(buildCommands(commands))
                .build();
    }

    private GeographicalPosition buildGeographicalPosition(int x, int y, CardinalDirectionType cardinalDirectionType) {
        return GeographicalPosition.builder().position(buildPosition(x,y)).cardinalDirectionType(cardinalDirectionType).build();
    }

    private Position buildPosition(int x, int y) {
        return Position.builder().positionX(x).positionY(y).build();
    }

    private List<List<String>> buildCommands(List<String> commands) {
        List<List<String>> commandsList = new ArrayList<>();

        commands.forEach(s -> commandsList.add(s.chars().mapToObj(x -> mapMovement(x)).collect(Collectors.toList())));
        return commandsList;
    }

    private String mapMovement(int charValue) {
        String listData;
        if (IS_FORWARD_MOVEMENT.test(charValue)) {
            listData = MovementType.A.name();
        } else if (IS_RIGHT_MOVEMENT.test(charValue)) {
            listData = MovementType.D.name();
        } else {
            listData = MovementType.I.name();
        }
        return listData;
    }

}