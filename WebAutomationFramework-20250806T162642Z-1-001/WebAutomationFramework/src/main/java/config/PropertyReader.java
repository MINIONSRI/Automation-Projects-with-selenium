package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties = new Properties();

    // Load properties from file
    public static void loadProperties(String filePath) {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config file: " + filePath, e);
        }
    }

    // Get value by key
    public static String get(String key) {
        return properties.getProperty(key);
    }

    // Set value by key (in memory)
    public static void set(String key, String value) {
        properties.setProperty(key, value);
    }

    // Save updated properties back to file
    public static void saveProperties(String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            properties.store(fos, "Updated config");
        } catch (IOException e) {
            throw new RuntimeException("Unable to save config file: " + filePath, e);
        }
    }
}