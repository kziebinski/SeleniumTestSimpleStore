package pages;

import java.io.*;
import java.util.Properties;

public class HookProperties {

    private final String login_properties = "src/main/resources/properties/login.properties";
    private final String loginFake_properties = "src/main/resources/properties/fakeLogin.properties";

    public Properties loginLoadProperties() throws IOException {
        return loginLoadProperties(login_properties);
    }

    public Properties loginLoadFakeProperties() throws IOException {
        return loginLoadProperties(loginFake_properties);
    }

    private Properties loginLoadProperties(String pathProp) throws IOException {
        InputStream input = new FileInputStream(pathProp);
        Properties prop = new Properties();
        prop.load(input);
        return prop;
    }

    public Properties loginWriteProperties() {
        Properties prop = new Properties();
        return prop;
    }

    public OutputStream outputStream() throws FileNotFoundException {
        return new FileOutputStream(loginFake_properties);
    }
}
