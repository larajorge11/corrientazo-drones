package strategy.movement;

import domain.Position;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ForwardNorthMovementStrategyTest {

    private ForwardNorthMovementStrategy forwardNorthMovementStrategy;

    @Before
    public void setUp() {
        forwardNorthMovementStrategy = new ForwardNorthMovementStrategy();
    }

    @Test
    public void testMovementTowardsNorth() {
        Position position = buildPosition(0,0);
        forwardNorthMovementStrategy.setMovement(
                position , 0, 0
        );

        assertThat(position.getPositionX(), is(0));
        assertThat(position.getPositionY(), is(1));
    }

    private Position buildPosition(int x, int y) {
        return Position.builder().positionX(x).positionY(y).build();
    }
}