package springhometask.api;

import springhometask.api.model.Contact;

import java.util.Collection;

/**
 * Created by AzeraL on 29.09.2015.
 */
public interface ContactsService {
    void addContact(Contact contact);
    void deleteContact(Contact contact);
    void deleteForName(String name);
    Collection<Contact> getAllContacts();
    void clearAll();
}
