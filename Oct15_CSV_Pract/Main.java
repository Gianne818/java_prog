
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
    private Scanner sc = new Scanner(System.in);
    

    public void addContact() {
        // TODO: Implement this method
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("contacts.csv", true));
            String name, number;
            System.out.print("Enter the contact's name: ");
            name = sc.nextLine();
            System.out.print("Enter the contact's phone number: ");
            number = sc.nextLine();
    
            bw.write(name +  "," + number + "\n");
            System.out.println("Contact added successfully!");
            bw.close();
        } catch(IOException e){
            System.out.println("Error");
        }
    }

    public void viewContacts(){
        // TODO: Implement this method
        BufferedReader br = null;
        File file = new File("contacts.csv");
        if(file.length() == 0 || !file.exists()){
            System.out.println("No contacts found.");
            return;
        }

        try{
            
            br = new BufferedReader(new FileReader(file));
            String s;
            
            System.out.println();
            System.out.println("Contacts: ");
            System.out.println("Name\t\t" + "Phone");
            System.out.println("-----------------");
            while((s = br.readLine()) != null){
                String[] parts = s.split(",");
                int pad = 15-parts[0].length();
                System.out.print(parts[0]);
                for (int j = 0; j<pad; j++){
                    System.out.print(" ");
                }
                System.out.println("\t" + parts[1]);
            }
            br.close();
        } catch(IOException e){
            System.out.println("Error");
        }
        
    }

    public void searchContact(){
        // TODO: Implement this method
        BufferedReader br = null;
        
        try{
            System.out.print("Enter the name to search for: ");
            String name = sc.nextLine();
            File file = new File("contacts.csv");
            if(file.length() == 0 || !file.exists()){
                System.out.println("No contacts found.");
                return;
            }
            br = new BufferedReader(new FileReader(file));
            String s;
            while((s=br.readLine())!=null){
                String[] parts = s.split(",");
                if(name.equals(parts[0])){
                    System.out.println("\nContact found:");
                    System.out.println("Name: " + parts[0]);
                    System.out.println("Phone: " + parts[1]);
                    br.close();
                    return;
                    
                }
            }
        System.out.println("No contacts found.");
        if(br!=null) br.close();
        } catch(IOException e){
            System.out.println("Error");
        }
        
        
        
    }

    public void run() {
        while (true) {
            System.out.println("\nContact List Manager");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addContact(); break;
                case "2":
                    viewContacts(); break;
                case "3":
                    searchContact(); break;
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