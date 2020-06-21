/*
 * Copyright (c) 2020
 */
package util;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
}
