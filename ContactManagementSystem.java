import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagementSystem {

    // Contact class to store individual contact information
    public static class Contact {
        private String name;
        private String phone;
        private String email;

        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
        }
    }

    // List to store all contacts
    private static ArrayList<Contact> contacts = new ArrayList<>();

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Contact Management System -----");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Please select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact(scanner);
                    break;
                case 4:
                    deleteContact(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method to add a contact
    private static void addContact(Scanner scanner) {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully.");
    }

    // Method to view all contacts
    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\n----- Contact List -----");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    // Method to update a contact
    private static void updateContact(Scanner scanner) {
        System.out.print("Enter the name of the contact to update: ");
        String name = scanner.nextLine();

        // Find the contact by name
        Contact contactToUpdate = null;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contactToUpdate = contact;
                break;
            }
        }

        if (contactToUpdate == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.print("Enter new name (or press Enter to keep the same): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                contactToUpdate.setName(newName);
            }

            System.out.print("Enter new phone number (or press Enter to keep the same): ");
            String newPhone = scanner.nextLine();
            if (!newPhone.isEmpty()) {
                contactToUpdate.setPhone(newPhone);
            }

            System.out.print("Enter new email address (or press Enter to keep the same): ");
            String newEmail = scanner.nextLine();
            if (!newEmail.isEmpty()) {
                contactToUpdate.setEmail(newEmail);
            }

            System.out.println("Contact updated successfully.");
        }
    }

    // Method to delete a contact
    private static void deleteContact(Scanner scanner) {
        System.out.print("Enter the name of the contact to delete: ");
        String name = scanner.nextLine();

        // Find and remove the contact by name
        Contact contactToDelete = null;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contactToDelete = contact;
                break;
            }
        }

        if (contactToDelete == null) {
            System.out.println("Contact not found.");
        } else {
            contacts.remove(contactToDelete);
            System.out.println("Contact deleted successfully.");
        }
    }
}
