package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private static GetProperties getProperties= null;
    private String url;
    private String email;
    private String pwd;

    private GetProperties(){
        Properties properties = new Properties();
        String nameFile="todoly.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);
        if(inputStream!= null){
            try {
                properties.load(inputStream);
                url =properties.getProperty("url");
                email=properties.getProperty("email");
                pwd=properties.getProperty("pwd");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static GetProperties getInstance(){
        if (getProperties == null)
            getProperties=new GetProperties();
        return getProperties;
    }

    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }
}
