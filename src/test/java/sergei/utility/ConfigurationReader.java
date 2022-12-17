package sergei.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    // 1- Create properties object
    // we make this private to be inaccessible from outside
    // make static because static runs first and before everything else and
    // we will use this object under static method
    private static Properties properties = new Properties();


    // having static block because static runs first

    static {

        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);

        } catch (IOException e) {
            System.out.println("File not found in configuration Reader class");
            e.printStackTrace();
        }
    }

    public static String getProperty (String keyword){

        return properties.getProperty(keyword);
    }




}
