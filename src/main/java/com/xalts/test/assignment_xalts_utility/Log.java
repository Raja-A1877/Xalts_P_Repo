package com.xalts.test.assignment_xalts_utility;

import org.apache.log4j.Logger;

public class Log {
    public static Logger Log = Logger.getLogger(Log.class.getName());

    public static void info(String message) {
        Log.info(message);
    }

}
