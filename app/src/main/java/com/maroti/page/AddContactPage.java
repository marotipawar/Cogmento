package com.maroti.page;

import com.maroti.model.Contact;

public interface AddContactPage {
    void addContacts(Contact contact) throws InterruptedException;
}
