package Oct16_file;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        ArrayList<String> arr = new ArrayList<>();
        System.out.print("Enter the number of siblings: ");
        int n = sc.nextInt();
        sc.nextLine();
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter("siblings.txt"));
            int eldest = -1;
            String eldestName = "";
            for (int i = 1; i<=n; i++){
                System.out.println("Enter sibling " + i + " details:");
                System.out.print("Name: ");
                
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                if(age > eldest){
                    eldest = age;
                    eldestName = name;
                }
                arr.add(name + ", Age: " + age);
                bw.write(name + ", Age: " + age);
                bw.newLine();
            } 
            if(n <= 0){
                    throw new IOException();
            }
            bw.close();
            BufferedWriter be = new BufferedWriter(new FileWriter("eldest.txt"));
            be.write(eldestName);
            be.close();
            
            //br = new BufferedReader(new FileReader("siblings.txt"));
            System.out.println();
            System.out.println("List of Siblings:");
            int i = 1;
            String temp = "";
            for (String s : arr){
                System.out.println(i + ". " + s);
                i++;
            }
            System.out.println("The eldest sibling is " + eldestName + ".");

        } catch (IOException e){
                System.out.println("No siblings to record");
        }
        sc.close();
        
    }
}