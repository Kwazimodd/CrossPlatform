package edu.crossplatforms.l2.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoggerUtil {
    private LoggerUtil() {
    }

    public static void log(String text) {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.printf("[ %s ]\t%s%n", timeStamp, text);
    }
}
