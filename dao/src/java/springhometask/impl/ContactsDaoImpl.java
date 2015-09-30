package springhometask.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import springhometask.ContactsDao;
import springhometask.api.model.Contact;
import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by AzeraL on 29.09.2015.
 */
@Repository
public class ContactsDaoImpl implements ContactsDao {
    @Value("${max.size}")
    private long maxSize;

    private long size=1;

    private Map<String, Contact> contactsMap;

    @PostConstruct
    public void init(){
        contactsMap = new TreeMap<String, Contact>();
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        contactsMap=context.getBeansOfType(Contact.class);
        Contact contact=new Contact();
        contact.setFirstName("1");
        contactsMap.put(contact.getFirstName(), contact);
    }

    public void add(Contact contact) {
        if(size<maxSize) {
            contactsMap.put(contact.getFirstName(), contact);
            size++;
        }else{
            System.out.println("Contact book is full! Please remove unnecessary contacts and try again.");
        }
    }

    public void delete(Contact contact) {
        Iterator<Map.Entry<String, Contact>> iterator = contactsMap.entrySet().iterator();
        while(iterator.hasNext()){
            if(iterator.next().getKey().equals(contact.getFirstName())){
                iterator.remove();
            }
        }
        size--;
    }
    public void deleteForName(String name){
        Iterator<Map.Entry<String, Contact>> iterator = contactsMap.entrySet().iterator();
        while(iterator.hasNext()){
            if(iterator.next().getKey().equals(name)){
                iterator.remove();
            }
        }
        size--;
    }

    public Collection<Contact> getAll() {
        return contactsMap.values();
    }

    public void clearAll() {
        contactsMap.clear();
    }
}
