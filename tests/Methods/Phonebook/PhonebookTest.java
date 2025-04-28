package Methods.Phonebook;

import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class PhonebookTest {
    @Test
    public void testThatItCanCreateContact() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);
        HashMap<String, String> contact = new HashMap<>();
        contact.put("firstName", "usman");
        contact.put("lastName", "eletu");
        contact.put("phoneNumber", "09134969393");
        assertEquals(contact, pb.createContact("usman", "eletu", "09134969393"));
    }


    @Test
    public void testthatcontactisinthecontactlist() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);

        assertEquals("contact saved successfully", pb.addToPhoneBook("usman", "eletu", "09134969393"));
    }

    @Test
    public void testthatcontactisinthecontactlistII() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);
        pb.addToPhoneBook("usman", "eletu", "09134969393");
        assertEquals("such contact already exist", pb.addToPhoneBook("usman", "eletu", "09134969393"));
    }

    @Test
    public void testthatcontactisinthecontactlistIII() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);
        pb.addToPhoneBook("koko", "eletu", "09134964393");
        assertEquals("contact saved successfully", pb.addToPhoneBook("usman", "eletu", "09134969393"));
    }

    @Test
    public void testthatcontactisinthecontactlistIV() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);
        pb.addToPhoneBook("koko", "eletu", "09134969393");
        assertEquals("such number already exist", pb.addToPhoneBook("usman", "eletu", "09134969393"));
    }

    @Test
    public void testthatcontactCanBeDeleteFromcontactlist() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);
        pb.addToPhoneBook("koko", "eletu", "09134969393");
        assertEquals("contact has successfully delete", pb.removeContact("koko", "eletu", "09134969393"));

    }

    @Test
    public void testthatcontactCanBeDeleteFromcontactlistII() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);
        assertEquals("such contact do not exist", pb.removeContact("koko", "eletu", "09134969393"));

    }

    @Test
    public void testToFindContactWithNumber() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);
        pb.addToPhoneBook("usman", "eletu", "09134969393");
        pb.addToPhoneBook("koko", "eletu", "08055472262");
        pb.addToPhoneBook("qudus", "eletu", "09156124678");
        pb.addToPhoneBook("vic", "yek", "09012345678");
        HashMap<String, String> detail = new HashMap<>();
        detail.put("firstName", "usman");
        detail.put("lastName", "eletu");
        detail.put("phoneNumber", "09134969393");
        assertEquals(detail, pb.findByNumber("09134969393"));

    }

    @Test
    public void testToFindContactWithNumberII() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);
        pb.addToPhoneBook("usman", "eletu", "09134969393");
        pb.addToPhoneBook("koko", "eletu", "08055472262");
        pb.addToPhoneBook("qudus", "eletu", "09156124678");
        pb.addToPhoneBook("vic", "yek", "09012345678");
        HashMap<String, String> detail = new HashMap<>();

        assertEquals(detail, pb.findByNumber("09134969395"));

    }

    @Test
    public void testToFindContactWithFullname() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);

        pb.addToPhoneBook("koko", "eletu", "08055472262");
        pb.addToPhoneBook("qudus", "eletu", "09156124678");
        pb.addToPhoneBook("vic", "yek", "09012345678");
        pb.addToPhoneBook("usman", "eletu", "09134969393");
        HashMap<String, String> detail = new HashMap<>();
        detail.put("firstName", "usman");
        detail.put("lastName", "eletu");
        detail.put("phoneNumber", "09134969393");
        assertEquals(detail, pb.findByFullname("usman", "eletu"));

    }

    @Test
    public void testToFindContactWithFullnameII() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);

        pb.addToPhoneBook("koko", "eletu", "08055472262");
        pb.addToPhoneBook("qudus", "eletu", "09156124678");
        pb.addToPhoneBook("vic", "yek", "09012345678");
        pb.addToPhoneBook("usman", "eletu", "09134969393");
        HashMap<String, String> detail = new HashMap<>();

        assertEquals(detail, pb.findByFullname("usm", "elu"));

    }

    @Test
    public void testToFindContactWithname() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);
        ArrayList<HashMap<String, String>> List = new ArrayList<>();
        pb.addToPhoneBook("koko", "eletu", "08055472262");
        pb.addToPhoneBook("qudus", "eletu", "09156124678");
        pb.addToPhoneBook("vic", "yek", "09012345678");
        pb.addToPhoneBook("usman", "eletu", "09134969393");
        HashMap<String, String> detail = new HashMap<>();
        detail.put("firstName", "usman");
        detail.put("lastName", "eletu");
        detail.put("phoneNumber", "09134969393");

        HashMap<String, String> detail1 = new HashMap<>();
        detail1.put("firstName", "koko");
        detail1.put("lastName", "eletu");
        detail1.put("phoneNumber", "08055472262");
        HashMap<String, String> detail2 = new HashMap<>();
        detail2.put("firstName", "qudus");
        detail2.put("lastName", "eletu");
        detail2.put("phoneNumber", "09156124678");
        List.add(detail1);
        List.add(detail2);
        List.add(detail);
        assertEquals(List, pb.findByname("eletu"));

    }


    @Test
    public void testToFindContactWithnameII() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);
        ArrayList<HashMap<String, String>> List = new ArrayList<>();
        pb.addToPhoneBook("koko", "eletu", "08055472262");
        pb.addToPhoneBook("qudus", "eletu", "09156124678");
        pb.addToPhoneBook("vic", "yek", "09012345678");
        pb.addToPhoneBook("usman", "eletu", "09134969393");

        assertEquals(List, pb.findByname("ele"));

    }


    @Test
    public void testToEditcontact() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);

        pb.addToPhoneBook("koko", "eletu", "08055472262");
        pb.addToPhoneBook("qudus", "eletu", "09156124678");
        pb.addToPhoneBook("vic", "yek", "09012345678");
        pb.addToPhoneBook("usman", "eletu", "09134969393");
        HashMap<String, String> detail = new HashMap<>();
        detail.put("firstName", "ola");
        detail.put("lastName", "seni");
        detail.put("phoneNumber", "09134969393");

        assertEquals(detail,pb.editContact("usman", "eletu","ola","seni"));

    }


    @Test
    public void testToEditcontactII() {
        ArrayList<HashMap<String, String>> contactList = new ArrayList<>();
        Phonebook pb = new Phonebook(contactList);

        pb.addToPhoneBook("koko", "eletu", "08055472262");
        pb.addToPhoneBook("qudus", "eletu", "09156124678");
        pb.addToPhoneBook("vic", "yek", "09012345678");
        pb.addToPhoneBook("usman", "eletu", "09134969393");
        HashMap<String, String> detail = new HashMap<>();


        assertEquals(detail,pb.editContact("uan", "etu","ola","seni"));

    }

}



