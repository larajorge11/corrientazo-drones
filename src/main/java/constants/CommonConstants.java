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
    public static int DRONES_AMOUNT_MAX = 20;
    public static int DRONES_DELIVERY_AMOUNT_MAX = 3;
    public static String OK_MESSAGE = "ok";
    public static String EXCEED_AMOUNT_DRONES_MESSAGE = "Sorry!, Drones amount not allowed";
}
