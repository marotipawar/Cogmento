package com.maroti.serviceImpl;

import com.maroti.factory.MyBrowser;
import com.maroti.factory.MyWebBrowser;
import com.maroti.model.Contact;
import com.maroti.services.CogmentoService;
import org.openqa.selenium.WebDriver;

public abstract class CongmentoServiceImpl implements CogmentoService {

    public WebDriver driver;


    public CongmentoServiceImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean login(String username, String password) {

        return false;
    }


    @Override
    public void addContacts(Contact contact) throws InterruptedException {

    }
}
