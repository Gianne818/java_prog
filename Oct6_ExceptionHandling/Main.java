package Oct6_ExceptionHandling;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

//import java.util* --- import everything from util, but not reco

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age;
        String name, lastName;

        while(true){
            try {
                System.out.print("Enter name: ");
                name = sc.nextLine();

                int dot = name.lastIndexOf('.');
                if(dot==-1){
                    throw new NameException(name);
                }
                lastName = name.substring(dot+2); 

                System.out.print("Enter age: ");
                age = sc.nextInt();
                if(age<0){
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e){
                System.out.println("Entered age is not valid.");
                sc.nextLine(); //clear the buffer
            } catch (StringIndexOutOfBoundsException | NameException e){
                System.out.println("Entered name is not valid.");
            } finally {
                System.out.println("FINALLY Ariel happened to me.");
            }
            // catch(NameException e){
            //     System.out.println(e.getMessage());
            // }
        }
       

        System.out.println(lastName + ", your age is " + age + ".");
    }

    public static void validateName(String name) throws NameException{
        if(name.indexOf(' ' ) == name.lastIndexOf(' ')){
            throw new NameException();
        }
    }
}
 