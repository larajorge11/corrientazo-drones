package transformer;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DroneFlightTransformerTest {

    private DroneFlightTransformer droneFlightTransformer;

    @Before
    public void setUp() {
        droneFlightTransformer = new DroneFlightTransformer();
    }

    @Test
    public void testDroneWhenIsOutsidePerimeter() throws IOException {
        List<List<String>> commandList = droneFlightTransformer.moveFlightDrone("in05.txt");
        assertThat(commandList.size(), is(0));
    }
}