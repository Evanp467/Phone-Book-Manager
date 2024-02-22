//PhoneBook class
//Evan Phillips 

package assg9_phillipsev20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneBook {
    private BinarySearchTree<Person, String> bst;
    
    /**
    Constructs an empty phone book.
    */
    
    public PhoneBook() {
        bst = new BinarySearchTree<>();
    }
    
    /**
    Adds a contact to the phone book.
    @param person the Person object to be added to the phone book
    */
    
    public void addContact(Person person) {
        bst.insert(person);
        System.out.println("Contact added successfully.");
    }
    
    /**
    Deletes a contact from the phone book based on the contact's name.
    @param name the name of the contact to be deleted
    */
    public void deleteContact(String name) {
        Person person = new Person(name, "");
        try {
            bst.delete(person);
            System.out.println("Contact deleted successfully.");
        } catch (TreeException e) {
            System.out.println("Contact not found.");
        }
    }
    
    /**
    Searches for a contact's phone number based on the contact's name.
    @param name the name of the contact to search for
    @return the Person object corresponding to the contact, or null if the contact is not found
    */
    public Person searchPhoneNumber(String name) {
        Person person = new Person(name, "");
        Person result = bst.retrieve(person.getName());
        if (result == null) {
            return null;
        } else {
           return result;
        }
    }
    
    /**
    Updates the phone number of a contact in the phone book based on the contact's name.
    @param name the name of the contact to be updated
    @param phoneNumber the new phone number to be assigned to the contact
    */
    public void updatePhoneNumber(String name, String phoneNumber) {
        Person person = new Person(name, phoneNumber);
        try {
            bst.delete(person);
            bst.insert(person);
            System.out.println("Phone number updated successfully.");
        } catch (TreeException e) {
            System.out.println("Contact not found.");
        }
    }
    
    /**
    Displays all contacts in the phone book in alphabetical order of their names.
    */
    public void displayPhoneBook() {
        displayPhoneBookHelper(bst.root);
    }
    
    /**
    Helper method that recursively prints the contacts in the phone book in alphabetical order
    of their names.
    @param node the current node being processed
    */
    private void displayPhoneBookHelper(TreeNode<Person> node) {
        if (node != null) {
            displayPhoneBookHelper(node.leftChild);
            System.out.println(node.item.getName() + ": " + node.item.getPhoneNumber());
            displayPhoneBookHelper(node.rightChild);
        }
    }
    
    /**
    Saves the phone book to a file in tab-separated format, with each line representing
    a single contact's name and phone number.
    @param filename the name of the file to which the phone book is saved
    */
    public void savePhoneBook(String filename) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            savePhoneBookHelper(bst.root, writer);
            System.out.println("Phone book saved successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error saving phone book: file not found.");
        }
    }
    
    /**
    Helper method to recursively save contacts to a file.
    @param node the root of the subtree to save
    @param writer the writer to use for writing to the file
    */
    private void savePhoneBookHelper(TreeNode<Person> node, PrintWriter writer) {
        if (node != null) {
            savePhoneBookHelper(node.leftChild, writer);
            writer.println(node.item.getName() + "\t" + node.item.getPhoneNumber());
            savePhoneBookHelper(node.rightChild, writer);
        }
    }
    
    /**
    Loads phone book data from a file with the given filename and populates the binary search tree with the contacts.
    Each line of the file should contain the name and phone number separated by a tab character (\t).
    @param filename the name of the file to load the phone book data from
    @throws FileNotFoundException if the file with the given filename cannot be found
    */
    public void loadPhoneBook(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                String name = parts[0];
                String phoneNumber = parts[1];
                Person person = new Person(name, phoneNumber);
                bst.insert(person);
            }
            System.out.println("Phone book loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error loading phone book: file not found.");
        }
    }
}