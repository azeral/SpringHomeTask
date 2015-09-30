package springhometask.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springhometask.ContactsDao;
import springhometask.api.ContactsService;
import springhometask.api.model.Contact;

import java.util.Collection;
import java.util.List;

/**
 * Created by AzeraL on 29.09.2015.
 */
@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsDao contactsDao;

    public void addContact(Contact contact) {
        contactsDao.add(contact);
    }

    public void deleteContact(Contact contact) {
        contactsDao.delete(contact);
    }
    public void deleteForName(String name){ contactsDao.deleteForName(name);}

    public Collection<Contact> getAllContacts() {
        return contactsDao.getAll();
    }

    public void clearAll() {
        contactsDao.clearAll();
    }
}
