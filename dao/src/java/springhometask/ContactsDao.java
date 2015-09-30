package springhometask;

import springhometask.api.model.Contact;

import java.util.Collection;
import java.util.List;

/**
 * Created by AzeraL on 29.09.2015.
 */
public interface ContactsDao {
    void add(Contact contact);
    void delete(Contact contact);
    void deleteForName(String name);
   Collection<Contact> getAll();
    void clearAll();

}
