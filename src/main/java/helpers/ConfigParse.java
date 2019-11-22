package helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigParse {
    public static String getProp(String key) {
        Properties prop = new Properties();
        InputStream in = ConfigParse.class.getClassLoader().getResourceAsStream("env.properties");
        try {
            assert in != null;
            prop.load(in);
            return prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found! " + e);
        }
    }
}
