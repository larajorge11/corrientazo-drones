/*
 * Copyright (c) 2020
 */
package constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CommonConstants {
    public static String DELIVERY_DRONE_PATH = "./files/input/";
    public static String MONITOR_DRONE_PATH = "./files/output/";
    public static String INITIAL_FILE_PREFIX = "in";
    public static String REPORT_FILE_PREFIX = "out";
    public static String REPORT_FILE_EXTENSION = ".txt";
    public static String TITLE_DRONES_REPORT = "== Reporte de entregas ==\n\n";
    public static String POSITION_DRONE_REPORT = "(%d, %d) dirección %s\n\n";
    public static int MOVE_FORWARD = 1;
}
