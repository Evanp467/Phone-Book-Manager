//PhoneBookManager class
//Evan Phillips
package assg9_phillipsev20;


import java.util.Scanner;

public class PhoneBookManager {
 public static void main(String[] args) {
     PhoneBook phoneBook = new PhoneBook();
     Scanner scanner = new Scanner(System.in);

     phoneBook.loadPhoneBook("assg9_phoneBook.txt");

     while (true) {
         printMenu();
         int option = scanner.nextInt();
         scanner.nextLine();

         switch (option) {
             case 1:
                 addContact(phoneBook, scanner);
                 break;
             case 2:
                 deleteContact(phoneBook, scanner);
                 break;
             case 3:
                 searchContact(phoneBook, scanner);
                 break;
             case 4:
                 updatePhoneNumber(phoneBook, scanner);
                 break;
             case 5:
                 displaySortedContacts(phoneBook);
                 break;
             case 6:
                 saveAndExit(phoneBook);
                 return;
             default:
                 System.out.println("Invalid option. Please try again.");
         }
     }
 }

 private static void printMenu() {
     System.out.println("\nPhone Book Menu");
     System.out.println("1. Add a contact");
     System.out.println("2. Delete a contact");
     System.out.println("3. Search phone number");
     System.out.println("4. Update phone number");
     System.out.println("5. Display phone book in sorted order");
     System.out.println("6. Save and exit");
     System.out.print("Please enter your option (1-6): ");
 }

 private static void addContact(PhoneBook phoneBook, Scanner scanner) {
     System.out.print("Enter the name: ");
     String name = scanner.nextLine();
     System.out.print("Enter the phone number: ");
     String phoneNumber = scanner.nextLine();
     phoneBook.addContact(new Person(name, phoneNumber));
     pressEnterToContinue(scanner);
 }

 private static void deleteContact(PhoneBook phoneBook, Scanner scanner) {
     System.out.print("Enter the name: ");
     String name = scanner.nextLine();
     phoneBook.deleteContact(name);
     pressEnterToContinue(scanner);
 }

 private static void searchContact(PhoneBook phoneBook, Scanner scanner) {
     System.out.print("Enter the name: ");
     String name = scanner.nextLine();
     Person person = phoneBook.searchPhoneNumber(name);
     if (person != null) {
         System.out.println("Phone number: " + person.getPhoneNumber());
     } else {
         System.out.println("Contact not found.");
     }
     pressEnterToContinue(scanner);
 }

 private static void updatePhoneNumber(PhoneBook phoneBook, Scanner scanner) {
     System.out.print("Enter the name: ");
     String name = scanner.nextLine();
     System.out.print("Enter the new phone number: ");
     String newPhoneNumber = scanner.nextLine();
     phoneBook.updatePhoneNumber(name, newPhoneNumber);

     pressEnterToContinue(scanner);
 }

 private static void displaySortedContacts(PhoneBook phoneBook) {
     System.out.println("Phone book in sorted order:");
     phoneBook.displayPhoneBook();
     System.out.println("Press Enter to continue...");
     new Scanner(System.in).nextLine();
     
     
 }

 private static void saveAndExit(PhoneBook phoneBook) {
     phoneBook.savePhoneBook("assg9_phoneBook.txt");

 }

 private static void pressEnterToContinue(Scanner scanner) {
     System.out.println("Press Enter to continue...");
     scanner.nextLine();
 }
}
