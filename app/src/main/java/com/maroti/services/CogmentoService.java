package com.maroti.services;

import com.maroti.model.Contact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface CogmentoService {

    boolean login(String username, String password);

    void addContacts(Contact contact) throws InterruptedException;
}
