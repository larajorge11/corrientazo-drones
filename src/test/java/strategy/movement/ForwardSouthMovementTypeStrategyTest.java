package strategy.movement;

import domain.Position;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ForwardSouthMovementTypeStrategyTest {

    private ForwardSouthMovementStrategy forwardSouthMovementStrategy;

    @Before
    public void setUp() {
        forwardSouthMovementStrategy = new ForwardSouthMovementStrategy();
    }

    @Test
    public void testMovementTowardsSouth() {
        Position position = buildPosition(0,0);
        forwardSouthMovementStrategy.setMovement(
                position , 0, 0
        );

        assertThat(position.getPositionX(), is(0));
        assertThat(position.getPositionY(), is(-1));
    }

    private Position buildPosition(int x, int y) {
        return Position.builder().positionX(x).positionY(y).build();
    }
}