package Nov18_Exception;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of grades: ");

        int num = sc.nextInt();
        int[] arr = new int[num];
        int sum = 0;

        for (int i = 0; i < num; i++) {
            System.out.println("Enter grade " + (i + 1) + ": ");
            try {
                int val = sc.nextInt();
                sc.nextLine();
                if(val < 0 || val > 99){
                    throw new ArithmeticException();
                }
                arr[i] = val;
                sum+=val;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input (not a number)");
                i--;
                sc.nextLine();
            } catch (ArithmeticException e) {
                System.out.println("Grade must be between 1 and 99");
                i--;
            }
        }

        double avg = Math.ceil((double)sum/num);
        System.out.println("Average grade is " + avg);

        sc.close();
    }
}