/*
 * Copyright (c) 2020
 */
package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static constants.CommonConstants.DELIVERY_DRONE_PATH;

public final class FileUtils {

    private FileUtils() throws IllegalAccessException {
        throw new IllegalAccessException("FileUtils cannot be instantiated");
    }

    /**
     * @param dir
     * @return
     */
    public static Set<String> listFiles(String dir) {
        return Stream.of(new File(dir).listFiles())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

    public static List<String> readLinesFile(String droneFile) throws IOException {
        return Files.readAllLines(Paths.get(DELIVERY_DRONE_PATH + droneFile));
    }
}
