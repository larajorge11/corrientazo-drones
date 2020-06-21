/*
 * Copyright (c) 2020
 */
package constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
    public static String DELIVERY_DRONE_AMOUNT_MAXIMUM_PATH = "./filesTest/input/amountDroneMaximum/";
    public static String MONITOR_DRONE_PATH = "./filesTest/output/";
    public static String INITIAL_FILE_PREFIX = "in";
    public static String REPORT_FILE_PREFIX = "out";
    public static String REPORT_FILE_EXTENSION = ".txt";
}
