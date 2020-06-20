package delegate;

import util.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static constants.CommonConstants.DELIVERY_DRONE_PATH;

public class FileDelegate {

    public String processDeliveries() {
        final Set<String> dronesDeliveriesList = FileUtils.listFiles(DELIVERY_DRONE_PATH);

        dronesDeliveriesList.forEach(drone -> {
            try {
                moveFlightDrone(drone);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return null;
    }

    private void moveFlightDrone(String droneFile) throws IOException {
        System.out.println("DroneFile: " + droneFile);
        final List<String> lines = Files.readAllLines(Paths.get(DELIVERY_DRONE_PATH + droneFile));
        lines.stream().map(new Function<String, List<String>>() {
            @Override
            public List<String> apply(String lineFile) {
                final char[] chars = lineFile.toCharArray();
                return ;
            }
        })

    }
}
