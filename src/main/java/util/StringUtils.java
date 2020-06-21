/*
 * Copyright (c) 2020
 */
package util;

import static constants.CommonConstants.INITIAL_FILE_PREFIX;
import static constants.CommonConstants.REPORT_FILE_EXTENSION;
import static org.apache.commons.lang3.StringUtils.removeEnd;
import static org.apache.commons.lang3.StringUtils.removeStart;

public final class StringUtils {

    private StringUtils() throws IllegalAccessException {
        throw new IllegalAccessException("StringUtils cannot be instantiated");
    }

    /**
     * @param data
     * @return
     */
    public static String cleanValueString (String data) {
        return removeStart(removeEnd(data,REPORT_FILE_EXTENSION), INITIAL_FILE_PREFIX);
    }
}
