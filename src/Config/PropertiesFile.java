package Config;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class PropertiesFile {

    private static Properties prop = new Properties();

    /** Load properties once — from default project path */
    public static void loadProperties() {
        String path ="C:/Users/sureshpas/git/qualltest-wagonhr/src/Config/Config.properties";
        loadProperties(path);
    }

    /** Overloaded method: load using a custom path */
    public static void loadProperties(String path) {
        try (InputStream input = new FileInputStream(path)) {
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file: " + path, e);
        }
    }

    /** Read implicit wait */
    public static long getImplicitlyWait() {
        String value = prop.getProperty("implicitlyWait");
        if (value != null) return Long.parseLong(value);
        else throw new RuntimeException("implicitlyWait not specified in properties file.");
    }

    /** Read application URL */
    public static String getApplicationUrl() {
        String url = prop.getProperty("Url");
        if (url != null) return url;
        else throw new RuntimeException("Url not specified in properties file.");
    }

    /** Read username */
    public static String Readusername(String usertype) {
        String key;

        switch (usertype) {
            case "Employee": key = "employee_username"; break;
            case "RM": key = "RM_username"; break;
            case "Super Admin": key = "SuperAdmin_username"; break;
            default: throw new RuntimeException("Invalid user type: " + usertype);
        }

        String username = prop.getProperty(key);
        if (username != null) return username;
        else throw new RuntimeException(key + " not specified in properties file.");
    }

    /** Read password */
    public static String Readpassword(String usertype) {
        String key;

        switch (usertype) {
            case "Employee": key = "employee_password"; break;
            case "RM": key = "RM_password"; break;
            case "Super Admin": key = "SuperAdmin_password"; break;
            default: throw new RuntimeException("Invalid user type: " + usertype);
        }

        String password = prop.getProperty(key);
        if (password != null) return password;
        else throw new RuntimeException(key + " not specified in properties file.");
    }

    /** Test Run */
    public static void main(String[] args) {

        // Load from project path (CI/CD friendly)
        loadProperties();

        System.out.println(getApplicationUrl());
        System.out.println(getImplicitlyWait());
        System.out.println(Readusername("Employee"));
        System.out.println(Readpassword("Employee"));
    }
}
