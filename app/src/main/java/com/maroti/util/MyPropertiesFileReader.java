package com.maroti.util;

import com.maroti.base.MyChromeBrowser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class MyPropertiesFileReader {
    public static void load() throws FileNotFoundException {
        URL url =MyChromeBrowser.class.getClassLoader().getResource("user.properties");
        try (FileInputStream str = new FileInputStream(new File(url.toURI()))) {
            Properties prop = new Properties();
            prop.load(str);
           System.setProperties(prop);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
