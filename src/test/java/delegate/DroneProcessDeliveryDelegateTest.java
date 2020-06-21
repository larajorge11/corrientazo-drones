package delegate;

import domain.CardinalDirectionType;
import domain.Restaurant;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static constants.CommonConstants.DELIVERY_DRONE_PATH;
import static constants.Constants.DELIVERY_DRONE_AMOUNT_MAXIMUM_PATH;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class DroneProcessDeliveryDelegateTest {

    private DroneProcessDeliveryDelegate droneProcessDeliveryDelegate;

    @Before
    public void setUp() {
        droneProcessDeliveryDelegate = new DroneProcessDeliveryDelegate();
    }

    @Test
    public void testValidateProcess() throws IOException {
        Restaurant restaurant = droneProcessDeliveryDelegate.process(DELIVERY_DRONE_PATH);

        assertThat(restaurant.getDrones().size(), is(3));
        assertThat(restaurant.getDrones().get(0).getIdentification(), is("02"));
        assertNotNull(restaurant.getDrones().get(0).getGeographicalCurrentPosition());
        assertNotNull(restaurant.getDrones().get(0).getCommands());
        assertNull(restaurant.getDrones().get(0).getGeographicalPositionsDelivery());
        assertThat(restaurant.getDrones().get(0).getGeographicalCurrentPosition().getPosition().getPositionX(), is(0));
        assertThat(restaurant.getDrones().get(0).getGeographicalCurrentPosition().getPosition().getPositionY(), is(0));
        assertThat(restaurant.getDrones().get(0).getGeographicalCurrentPosition().getCardinalDirectionType(), is(CardinalDirectionType.N));
        assertThat(restaurant.getDrones().get(0).getCommands().size(), is(3));
        assertThat(restaurant.getDrones().get(0).getCommands().get(0).size(), is(7));
        assertThat(restaurant.getDrones().get(0).getCommands().get(0).get(0), is("A"));
        assertThat(restaurant.getDrones().get(0).getCommands().get(0).get(1), is("A"));
        assertThat(restaurant.getDrones().get(0).getCommands().get(0).get(2), is("A"));
        assertThat(restaurant.getDrones().get(0).getCommands().get(0).get(3), is("A"));
        assertThat(restaurant.getDrones().get(0).getCommands().get(0).get(4), is("I"));
        assertThat(restaurant.getDrones().get(0).getCommands().get(0).get(5), is("A"));
        assertThat(restaurant.getDrones().get(0).getCommands().get(0).get(6), is("A"));

    }

    @Test
    public void testValidateAmountDronesMaximum() throws IOException {
        Restaurant restaurant = droneProcessDeliveryDelegate.process(DELIVERY_DRONE_AMOUNT_MAXIMUM_PATH);
        assertNull(restaurant.getDrones());
        assertThat(restaurant.isStatus(), is(false));
    }
}