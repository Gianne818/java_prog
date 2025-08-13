package classes_Encapsulation;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Employee e = new Employee("Gianne");
        e.setSalary(99999.99f, sc);
        e.setID("24-0920-213", sc);

        System.out.println("Name: " + e.getName());
        System.out.println("ID: " + e.getID(sc));
        System.out.println("Salary: " + e.getSalary(sc));

        sc.close();
    }
}
