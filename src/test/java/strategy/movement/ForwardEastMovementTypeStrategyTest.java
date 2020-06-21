package strategy.movement;

import domain.Position;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ForwardEastMovementTypeStrategyTest {
    private ForwardEastMovementStrategy forwardEastMovementStrategy;

    @Before
    public void setUp() {
        forwardEastMovementStrategy = new ForwardEastMovementStrategy();
    }

    @Test
    public void testMovementTowardsEast() {
        Position position = buildPosition(0,0);
        forwardEastMovementStrategy.setMovement(
                position , 0, 0
        );

        assertThat(position.getPositionX(), is(1));
        assertThat(position.getPositionY(), is(0));
    }

    private Position buildPosition(int x, int y) {
        return Position.builder().positionX(x).positionY(y).build();
    }
}