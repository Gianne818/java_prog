package Oct15_CSV_Pract;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
}

class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    

    public void addContact() {
        // TODO: Implement this method
        BufferedWriter bw = null;
        String name, number;
        System.out.print("Enter the contact's name: ");
        name = scanner.nextLine();
        System.out.print("Enter the contact's phone number: ");
        number = scanner.nextLine();
        
        try{
            bw = new BufferedWriter(new FileWriter("contacts.csv", true));
            bw.write(name +  "," + number + "\n");
            System.out.println("Contact added successfully!");
            bw.close();
        } catch (IOException e){
            System.out.println("Error writing to file!");
        }
        
        
    }

    public void viewContacts() {
        // TODO: Implement this method
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("contacts.csv"));
            String s;
            System.out.println();
            System.out.println("Contacts: ");
            System.out.println("Name\t\t" + "Phone");
            System.out.println("-----------------");
            while((s = br.readLine()) != null){
                String[] parts = s.split(",", 2);
                int pad = 15-parts[0].length();
                System.out.print(parts[0]);
                for (int j = 0; j<pad; j++){
                    System.out.print(" ");
                }
                System.out.println("\t" + parts[1]);
            }
        } catch(IOException e){
            System.out.println("No contacts found.");
        }
    }

    public void searchContact() {
        // TODO: Implement this method
    }

    public void run() {
        while (true) {
            System.out.println("\nContact List Manager");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    viewContacts();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        manager.run();
    }
}