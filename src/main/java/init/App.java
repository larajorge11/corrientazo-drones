package init;

import delegate.FileDelegate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    private static boolean isPointingToNorth(String line) {
        Predicate<String> isPointingToNorth = s -> s.startsWith("A");
        return isPointingToNorth.test(line);
    }

    private static String getCoordenada (final List<String> lines) {
        int x = 0;
        int y = 0;
        int giro = 90;

        String lineFile = null;

        lineFile = lines.get(0);
        if (isPointingToNorth(lineFile)) {
            y+=1;
        }

        /*for(String line : lines) {
            lineFile = lines.get(0);
            if (isPointingToNorth(line)) {
                y+=1;
            }
            System.out.println(line);
        }*/




        return null;
    }

    public static void main(String args []) throws IOException {
        System.out.println("Initializing");
        FileDelegate fileDelegate = new FileDelegate();
        fileDelegate.processDeliveries();
    }
}
