package com.maroti.util.fileReaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/*
 * @Author : Maroti Pawar
 * */
@FunctionalInterface
public interface PropertiesFileDataReader {


    Properties loadProps(String fileName);

    default Properties getPropertiesFile(String fileName) throws URISyntaxException, IOException {
        return loadPropFile(fileName);
    }

    default void loadPropertiesFileToSystemProps(String fileName) throws URISyntaxException, IOException {
        System.setProperties(getPropertiesFile(fileName));
    }

    public static Properties loadPropFile(String fileName) throws URISyntaxException, IOException {
        URL urlPth = PropertiesFileDataReader.class.getClassLoader().getResource(fileName);
        File file = null;
        if (urlPth != null) {
            file = new File(urlPth.toURI());
        }
        if (file != null && file.exists()) {
            FileInputStream stream = new FileInputStream(file);
            Properties prop = new Properties();
            prop.load(stream);
            return prop;
        }
        return null;
    }


}
