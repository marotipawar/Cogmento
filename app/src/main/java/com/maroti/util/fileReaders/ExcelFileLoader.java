package com.maroti.util.fileReaders;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public interface ExcelFileLoader {
    public static FileInputStream loadExcelFile(String fileName) throws URISyntaxException {
        URL pathUrl = ExcelFileDataReader.class.getClassLoader().getResource(fileName);
        File file = null;
        if (pathUrl != null) {
            file = new File(pathUrl.toURI());
        }
        if (file != null && file.exists()) {
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
        return new XSSFWorkbook(stream);
    }

    public static XSSFSheet getSheet(String fileName, int sheetIndex) throws URISyntaxException, IOException {
        XSSFWorkbook workbook = getExcelWorkBook(fileName);
        return workbook.getSheetAt(sheetIndex);
    }
}
