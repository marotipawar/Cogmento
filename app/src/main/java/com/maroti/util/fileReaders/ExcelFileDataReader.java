package com.maroti.util.fileReaders;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

import static com.maroti.util.fileReaders.ExcelFileLoader.loadExcelFile;
import static com.maroti.util.fileReaders.ExcelFileLoader.getExcelWorkBook;
import static com.maroti.util.fileReaders.ExcelFileLoader.getSheet;

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

    default Map getExcelSheetDataAsMap(String fileName, int sheetIndex) throws URISyntaxException, IOException {
        return getExcelSheetsDataAsMap(fileName, sheetIndex);
    }

    default List<List<String>> getExcelSheetDataAsList(String fileName, int sheetIndex) throws URISyntaxException, IOException {
        return getExcelSheetsDataAsList(fileName, sheetIndex);
    }

    default Object[][] getExcelSheetDataAsObjectArray(String fileName, int sheetIndex) throws URISyntaxException, IOException {
        return getExcelSheetsDataAsObjectArray(fileName, sheetIndex);
    }

    public static Object[][] getExcelSheetsDataAsObjectArray(String fileName, int sheetIndex) throws URISyntaxException, IOException {

        XSSFSheet sheet = getSheet(fileName, sheetIndex);
        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();

        Object[][] obj = new Object[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < colNum; j++) {
                try {
                    if (row.getCell(j).toString() != null) {
                        obj[i][j] = row.getCell(j).toString();
                    } else {
                        obj[i][j] = " ";
                    }
                } catch (Exception e) {

                }
            }
        }
        return obj;
    }

    public static List<List<String>> getExcelSheetsDataAsList(String fileName, int sheetIndex) throws URISyntaxException, IOException {
        XSSFSheet sheet = getSheet(fileName, sheetIndex);
        List rowList = new ArrayList();

        int rowNum = sheet.getLastRowNum();
        for (int i = 0; i < rowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            List cellList = new ArrayList();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                try {
                    if (row.getCell(j).toString() != null) {
                        cellList.add(row.getCell(j).toString());
                    } else {
                        cellList.add(" ");
                    }
                } catch (Exception e) {

                }
            }
            rowList.add(cellList);
        }
        return rowList;
    }

    public static Map getExcelSheetsDataAsMap(String fileName, int sheetIndex) throws URISyntaxException, IOException {
        XSSFSheet sheet = getSheet(fileName, sheetIndex);
        int rowNum = sheet.getLastRowNum();
        Map map = new LinkedHashMap();
        for (int i = 0; i < rowNum; i++) {
            XSSFRow values = sheet.getRow(i);
            XSSFRow keys = sheet.getRow(0);
            for (int j = 0; j < values.getLastCellNum(); j++) {
                try {
                    if (values.getCell(j).toString() != null) {
                        map.put(keys.getCell(j), values.getCell(j));
                    }
                } catch (Exception e) {
                    map.put(" ", " ");
                }
            }
        }
        return map;
    }

   /* public static void main(String[] args) throws URISyntaxException, IOException {
        Object[][] obj=getExcelSheetsDataAsObjectArray("cogmento_contacts.xlsx", 0);
        System.out.println(obj);
        for(Object[] ob : obj){
            for (Object o : ob){
                System.out.print(" "+o);
            }
            System.out.println(" ");
        }
    }*/
}
