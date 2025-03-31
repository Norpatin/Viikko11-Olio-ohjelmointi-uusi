package com.example.testi;

import java.util.ArrayList;

public class ContactStorage {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private static ContactStorage contactStorage = null;

    private ContactStorage(){
    }


    public static ContactStorage getInstance() {
        if(contactStorage == null){
            contactStorage = new ContactStorage();
        }
        return contactStorage;
    }
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);



    }

    public Contact getContactByIdWithoutRemove(int id) {
        return contacts.get(id);
    }


    public Contact getContactById(int id) {
        return contacts.remove(id);
    }

    public void removeContact(int id) {
        int i = 0;
        String idString = String.valueOf(id);
        for(Contact r : contacts) {
            int test = r.getId();
            String testString = String.valueOf(test);
            if(testString.equals(idString)){
                break;
            }
            i++;
        }
        contacts.remove(i);
    }

    /*public void setContacts(ArrayList<Contact> contacts) {
        this.contacts.clear();
        this.contacts.addAll(contacts);
    }/**/

}
