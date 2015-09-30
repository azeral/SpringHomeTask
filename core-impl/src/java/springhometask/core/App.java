package springhometask.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springhometask.api.ContactsService;
import springhometask.api.model.Contact;

/**
 * Created by AzeraL on 29.09.2015.
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ContactsService service=context.getBean(ContactsService.class);
        System.out.println(service.getAllContacts());

        Contact contact1 = new Contact();
        contact1.setFirstName("2");
        service.addContact(contact1);

        Contact contact2 = new Contact();
        contact2.setFirstName("3");
        service.addContact(contact2);
        System.out.println(service.getAllContacts());

        service.deleteForName("1");
        System.out.println(service.getAllContacts());

        Contact contact3 = new Contact();
        contact3.setFirstName("4");
        service.addContact(contact3);
        System.out.println(service.getAllContacts());

        service.clearAll();
        System.out.println(service.getAllContacts());



    }
}
