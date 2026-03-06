package utilities;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigReader {

    private static Map<String,Object> config;

    static {

        Yaml yaml = new Yaml();
// application.yaml dosyasini okumak
        InputStream inputStream =
                ConfigReader.class
                        .getClassLoader()
                        .getResourceAsStream("application.yaml");
//dosya yoksa
        if(inputStream == null){
            throw new RuntimeException("application.yaml file not found!");
        }

        config = yaml.load(inputStream);
    }
//config map icinden deger alir
    // key--->url olursa karsiligi--->https://www.saucedemo.com
    public static String get(String key){
        return config.get(key).toString();
    }
}