import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter integer input: ");
        BigInteger num1 = new BigInteger(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter string input: ");
        BigInteger num2 = new BigInteger(sc.nextLine());
        System.out.print("Enter operation [+/*]: ");
        char op = sc.nextLine().charAt(0);
        switch (op) {
            case '+':
                System.out.println("Sum = " + num2.add(num1));
                break;
            case '*':
                System.out.println("Product = " + num1.multiply(num2));
                break;
        }
    }
}