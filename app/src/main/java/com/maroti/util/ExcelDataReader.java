package com.maroti.util;

import com.maroti.model.Contact;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataReader {

    private static List<Contact> list;
    public static List<Contact> readExcelData() throws URISyntaxException {
        list = new ArrayList<>();

        URL path =ExcelDataReader.class.getClassLoader().getResource("cogmento_contacts.xlsx");
        try(FileInputStream stream = new FileInputStream(new File(path.toURI()))) {
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet =workbook.getSheetAt(0);
            int rowSize=sheet.getLastRowNum();
            for(int i=0; i<rowSize; i++){
                XSSFRow row =sheet.getRow(i);
                Contact con = new Contact();
                con.setFirstName(row.getCell(1).toString());
                con.setLastName(row.getCell(2).toString());
                con.setCompany(row.getCell(3).toString());
                con.setEmail(row.getCell(4).toString());
                con.setDescription(row.getCell(5).toString());
                con.setStreet(row.getCell(6).toString());
                con.setCity(row.getCell(7).toString());
                con.setState(row.getCell(8).toString());
                con.setPostCode(row.getCell(9).toString());
                con.setCountry(row.getCell(10).toString());
                con.setPhone(row.getCell(11).toString());
                con.setDept(row.getCell(12).toString());
                list.add(con);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

   /* public static void main(String[] args) throws URISyntaxException {
        readExcelData().forEach(con->{
            System.out.println(con.getFirstName());
        });
    }*/
}
