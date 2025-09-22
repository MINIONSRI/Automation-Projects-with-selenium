package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class CommonUtils {

    private static final Random random = new Random();

    // ✅ Random integer between min and max (inclusive)
    public static int getRandomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    // ✅ Random double with precision
    public static double getRandomDouble(double min, double max, int decimalPlaces) {
        double value = min + (max - min) * random.nextDouble();
        return Math.round(value * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
    }

    // ✅ Random alphanumeric string
    public static String getRandomAlphaNumeric(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // ✅ Random UUID string
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    // ✅ Current date in custom format
    public static String getCurrentDate(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    // ✅ Future date (n days ahead)
    public static String getFutureDate(int daysAhead, String format) {
        Date future = new Date(System.currentTimeMillis() + (long) daysAhead * 24 * 60 * 60 * 1000);
        return new SimpleDateFormat(format).format(future);
    }

    // ✅ Past date (n days ago)
    public static String getPastDate(int daysAgo, String format) {
        Date past = new Date(System.currentTimeMillis() - (long) daysAgo * 24 * 60 * 60 * 1000);
        return new SimpleDateFormat(format).format(past);
    }
}