package pages;

import java.io.*;
import java.util.Properties;

public class HookProperties {

    public Properties loginLoadProperties(){
        return loginLoadProperties("src/main/resources/properties/login.properties");
    }

    public Properties loginLoadFakeProperties(){
        return loginLoadProperties("src/main/resources/properties/fakeLogin.properties");
    }

    private Properties loginLoadProperties(String pathProp) {
        try (InputStream input = new FileInputStream(pathProp)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Properties loginWriteProperties(){
        try (OutputStream input = outputStream()) {
            Properties prop = new Properties();
            return prop;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OutputStream outputStream(){
        try {
            return new FileOutputStream("src/main/resources/properties/fakeLogin.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
