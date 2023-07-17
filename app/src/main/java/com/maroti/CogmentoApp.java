package com.maroti;

import com.maroti.base.MyChromeBrowser;
import com.maroti.factory.MyWebBrowser;
import com.maroti.model.Contact;
import com.maroti.page.AddContactPage;
import com.maroti.page.pageImpl.AddContactPageImpl;
import com.maroti.page.pageImpl.LoginPageImpl;
import com.maroti.page.LoginPage;
import com.maroti.util.ExcelDataReader;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class CogmentoApp {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException, InterruptedException {
        MyWebBrowser browser = MyChromeBrowser.getInstance(new ChromeDriver());
        LoginPage login = new LoginPageImpl(browser.getDriver());
        login.login(System.getProperty("user.username"), System.getProperty("user.password"));
        AddContactPage addContact = new AddContactPageImpl(browser.getDriver());


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
