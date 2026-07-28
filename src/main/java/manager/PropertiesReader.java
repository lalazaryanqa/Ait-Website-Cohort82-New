package manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static String getProperty(String fileName, String key) {
        Properties properties = new Properties();

        String filePath = System.getProperty("user.dir")
                + "/src/test/properties/"
                + fileName;

        String filePath = System.getProperty("user.dir") + "/src/test/properties/" + fileName;
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);

            String value = properties.getProperty(key);

            if (value == null || value.isBlank()) {
                throw new IllegalArgumentException(
                        "Property '" + key + "' is missing or empty in " + fileName
                );
            }
            return value;

        } catch (IOException e) {
            throw new RuntimeException(
                    "Cannot read properties file: " + filePath,
                    e
            );
        }
    }
}
}
