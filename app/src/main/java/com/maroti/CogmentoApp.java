package com.maroti;

import com.maroti.base.MyChromeBrowser;
import com.maroti.factory.MyBrowser;
import com.maroti.factory.MyWebBrowser;
import com.maroti.model.Contact;
import com.maroti.serviceImpl.AddContact;
import com.maroti.serviceImpl.Login;
import com.maroti.services.CogmentoService;
import com.maroti.util.ExcelDataReader;
import com.maroti.util.MyPropertiesFileReader;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class CogmentoApp {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException, InterruptedException {
        MyWebBrowser browser = MyChromeBrowser.getInstance(new ChromeDriver());
        CogmentoService login = new Login(browser.getDriver());
        login.login(System.getProperty("user.username"), System.getProperty("user.password"));
        CogmentoService addContact = new AddContact(browser.getDriver());


        Contact con = new Contact();
        con.setFirstName("Maroti");
        con.setLastName("Pawar");
        con.setCompany("Google");
        con.setEmail("info@gmail.com");
        con.setDescription("NO other job");
        con.setStreet("MG Road");
        con.setCity("Pune");
        con.setState("Maharashtra");
        con.setPostCode("10001");
        con.setCountry("India");
        con.setPhone("2001542");
        con.setDept("Computer");
        con.setDay("5");
        con.setMonth("May");
        con.setYear("2012");
        //addContact.addContacts(con);

        ExcelDataReader.readExcelData().forEach(contact -> {
            try {
                addContact.addContacts(contact);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
