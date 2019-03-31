package framework;
import java.io.InputStream;
import java.util.Properties;

public class Config
{
    public static Properties prop;

    public static void ReadConfig() throws Exception
    {
        String propFileName = "config/local.properties";
        if(System.getProperty("env")!=null && System.getProperty("env").equalsIgnoreCase("ci"))
        {
            propFileName = "config/ci.properties";
            System.out.println("*********  Test will run in CI environment   ********* ");
        }
        else
        {
            System.out.println("*********  Test will run in Localhost environment   ********* ");
        }
        prop = new Properties();
        InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(propFileName);
        // Load properties
        prop.load(inputStream);
    }

    public static String get(String key)throws Exception
    {
        return (String) prop.getProperty(key);
    }
}
