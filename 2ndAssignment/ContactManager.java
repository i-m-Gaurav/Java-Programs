import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

public class ContactManager {
    Map<String, List<Contact>> contactMap;

    public ContactManager() {
        contactMap = new HashMap<>();
    }

    public void addContact(String name, String phone, String email) {
        Contact contact = new Contact(name, phone, email);
        if (!contactMap.containsKey(name)) {
            contactMap.put(name, new ArrayList<Contact>());
        }
        contactMap.get(name).add(contact);
    }

    public void removeContact(String name, int index) {
        if (contactMap.containsKey(name)) {
            List<Contact> contacts = contactMap.get(name);
            if (index >= 0 && index < contacts.size()) {
                contacts.remove(index);
                if (contacts.isEmpty()) {
                    contactMap.remove(name);
                }
            }
        }
    }

    public void modifyContact(String name, int index, String phone, String email) {
        if (contactMap.containsKey(name)) {
            List<Contact> contacts = contactMap.get(name);
            if (index >= 0 && index < contacts.size()) {
                Contact contact = contacts.get(index);
                contact.phone = phone;
                contact.email = email;
            }
        }
    }

    public List<String> getMostFrequentNames() {
        List<String> names = new ArrayList<>();
        int maxCount = 0;
        for (Map.Entry<String, List<Contact>> entry : contactMap.entrySet()) {
            int count = entry.getValue().size();
            if (count > maxCount) {
                maxCount = count;
                names.clear();
                names.add(entry.getKey());
            } else if (count == maxCount) {
                names.add(entry.getKey());
            }
        }
        return names;
    }

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        // Add contacts
        manager.addContact("Alice", "555-1234", "alice@example.com");
        manager.addContact("Bob", "555-5678", "bob@example.com");
        manager.addContact("Alice", "555-9012", "alice@example.com");

        // Remove a contact
        manager.removeContact("Alice", 0);

        // Modify a contact
        manager.modifyContact("Bob", 0, "555-8765", "bob@example.com");

        // Get the most frequent names
        List<String> mostFrequentNames = manager.getMostFrequentNames();
        System.out.println("Most frequent names:");
        for(String name : mostFrequentNames) {
            System.out.println(name);
        }
    }
}
