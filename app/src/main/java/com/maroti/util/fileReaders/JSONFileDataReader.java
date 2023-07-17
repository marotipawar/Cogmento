package com.maroti.util.fileReaders;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
 * @Author : Maroti Pawar
 * */
public interface JSONFileDataReader<T> {

    T readJsonFile(String file);


    default File loadJsonFile(String fileName) throws URISyntaxException, IOException {
        return loadJSONFile(fileName);
    }

    default Map jsonToMap(String fileName) throws URISyntaxException, IOException {
        return readJSONToMap(fileName);
    }

    default List<Map> jsonToList(String fileName) throws URISyntaxException, IOException {
        return readJSONToList(fileName);
    }

    public static File loadJSONFile(String fileName) throws URISyntaxException, IOException {
        URL urlPath = JSONFileDataReader.class.getClassLoader().getResource(fileName);
        File file = new File(urlPath.toURI());
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static Map readJSONToMap(String fileName) throws URISyntaxException, IOException {
        File file = loadJSONFile(fileName);
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> map = mapper.readValue(file, Map.class);
            return map;
        }

        return null;
    }

    public static List<Map> readJSONToList(String fileName) throws URISyntaxException, IOException {
        File file = loadJSONFile(fileName);
        if (file.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            List<Map> list = Arrays.asList(mapper.readValue(file, Map[].class));
            return list;
        }

        return null;
    }


}
