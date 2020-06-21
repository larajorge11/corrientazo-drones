package strategy.movement;

import domain.Position;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ForwardWestMovementTypeStrategyTest {
    private ForwardWestMovementStrategy forwardWestMovementStrategy;

    @Before
    public void setUp() {
        forwardWestMovementStrategy = new ForwardWestMovementStrategy();
    }

    @Test
    public void testMovementTowardsWest() {
        Position position = buildPosition(0,0);
        forwardWestMovementStrategy.setMovement(
                position , 0, 0
        );

        assertThat(position.getPositionX(), is(-1));
        assertThat(position.getPositionY(), is(0));
    }

    private Position buildPosition(int x, int y) {
        return Position.builder().positionX(x).positionY(y).build();
    }
}