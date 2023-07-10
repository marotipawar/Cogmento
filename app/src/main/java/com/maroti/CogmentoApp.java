package com.maroti;

import com.maroti.base.MyChromeBrowser;
import com.maroti.factory.MyBrowser;
import com.maroti.factory.MyWebBrowser;
import com.maroti.serviceImpl.AddContact;
import com.maroti.serviceImpl.Login;
import com.maroti.services.CogmentoService;
import com.maroti.util.ExcelDataReader;
import com.maroti.util.MyPropertiesFileReader;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class CogmentoApp {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        MyWebBrowser browser =MyChromeBrowser.getInstance(new ChromeDriver());
        CogmentoService login = new Login(browser.getDriver());
        login.login(System.getProperty("user.username"), System.getProperty("user.password"));
        CogmentoService addContact = new AddContact(browser.getDriver());


        ExcelDataReader.readExcelData().forEach(contact -> {
            try {
                addContact.addContacts(contact);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
