package com.maroti.util;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/*
 * @Author : Maroti Pawar
 * */
@FunctionalInterface
public interface ExcelFileDataReader {

    public Object[][] getData(String fileName, int sheetIndex);

    default FileInputStream loadFile(String fileName) throws URISyntaxException {
        return loadExcelFile(fileName);
    }

    default XSSFWorkbook getWorkbook(String fileName) throws URISyntaxException, IOException {
        return getExcelWorkBook(fileName);
    }

    default XSSFSheet getSheetAt(String fileName, int sheetIndex) throws URISyntaxException, IOException {
        return getSheet(fileName, sheetIndex);
    }

    public static FileInputStream loadExcelFile(String fileName) throws URISyntaxException {
        URL pathUrl = ExcelFileDataReader.class.getClassLoader().getResource(fileName);
        File file = new File(pathUrl.toURI());
        if (file.exists()) {
            try {
                FileInputStream stream = new FileInputStream(file);
                return stream;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static XSSFWorkbook getExcelWorkBook(String fileName) throws URISyntaxException, IOException {
        FileInputStream stream = loadExcelFile(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(stream);
        return workbook;
    }

    public static XSSFSheet getSheet(String fileName, int sheetIndex) throws URISyntaxException, IOException {
        XSSFWorkbook workbook = getExcelWorkBook(fileName);
        return workbook.getSheetAt(sheetIndex);
    }

    public static Map getExcelData(String fileName, int sheetIndex) throws URISyntaxException, IOException {
        XSSFSheet sheet = getSheet(fileName, sheetIndex);
        int rowNum = sheet.getLastRowNum();
        Map map = new LinkedHashMap();
        for (int i = 0; i < rowNum; i++) {
            XSSFRow values = sheet.getRow(i);
            XSSFRow keys = sheet.getRow(0);
            for (int j = 1; j < values.getLastCellNum(); j++) {
                map.put(keys.getCell(j), values.getCell(j));
            }
        }
        return map;
    }

}
