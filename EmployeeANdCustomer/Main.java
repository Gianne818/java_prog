package EmployeeANdCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();

        // TODO: add Manager, Developer, and Customer objects to persons list

        persons.add(new Manager("Sami", 19, 1230000, "2423123"));
        persons.add(new Manager("Sami2", 19, 1230000, "2423123"));
        persons.add(new Manager("Sami3", 19, 1230000, "2423123"));
        persons.add(new Developer("Gianne", 19, 123100, "235433"));
        persons.add(new Developer("Gianne2", 19, 123100, "235433"));
        persons.add(new Developer("Gianne3", 19, 123100, "235433"));
        persons.add(new Developer("Gianne4", 19, 123100, "235433"));


        String input;
        do {
            System.out.print("Action: ");
            input = sc.nextLine();

            switch (input) {
                case "DONE":
                    break;

                case "List":
                    for (Person p : persons) {
                        System.out.println(p);
                    }
                    break;

                case "Work":
                    System.out.print("Enter manager name: ");
                    String managerName = sc.nextLine();
                    System.out.print("Enter developer name: ");
                    String devName = sc.nextLine();

                    Developer temp = null;
                    Manager temp2 = null;
                    for (Person p : persons){
                        if(p instanceof Manager e && e.getName().equals(managerName)){
                            temp2 = e;
                        }
                        else if(p instanceof Developer d && d.getName().equals(devName)){
                            temp = d;
                        }
                        
                    }

                    if(temp!=null && temp2 != null){
                        temp2.work(temp);
                    }

                    // TODO: find Manager and Developer in persons list
                    // TODO: make manager instruct developer to work
                    break;

                case "Give Raise":
                    System.out.print("Enter manager name: ");
                    String mName = sc.nextLine();
                    System.out.print("Enter employee name: ");
                    String eName = sc.nextLine();

                    Developer tempD = null;
                    Manager tempM = null;
                    for (Person p : persons){
                        if(p instanceof Developer d){
                            if(d.getName().equals(eName)){
                                tempD = d;
                            }
                        } 
                        else if(p instanceof Manager e){
                            if(e.getName().equals(mName)){
                                tempM = e;
                            }
                        }
                    }

                    if(tempD != null && tempM != null){
                        tempM.giveRaise(tempD);
                    }

                    // TODO: find Manager and Employee in persons list
                    // TODO: make manager give raise to employee
                    break;

                case "Purchase":
                    System.out.print("Enter customer name: ");
                    String cname = sc.nextLine();
                    System.out.print("Item: ");
                    String item = sc.nextLine();
                    System.out.print("Amount (double for price, int for quantity): ");
                    String amount = sc.nextLine();

                    // TODO: find Customer in persons list
                    // TODO: call correct purchase() method depending on input type
                    break;

                default:
                    System.out.println("Unknown command.");
            }

        } while (!input.equals("DONE"));
        sc.close();
    }
}   