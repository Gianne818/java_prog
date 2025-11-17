package Oct13_Error;
import java.util.ArrayList;
import java.util.Scanner;
import  java.util.List;

// You should not try to catch or throw errors. Most errors are abnormal conditions.
// Like stack overflow or out of memory error.
//Errors are typically thrown only by the Java Virtual Machine and designate
// the most serious situations that are
// unlikely to be recoverable, such as when the system runs out of memory.
//In contrast, exceptions designate situations in which a running program might reasonably
//be able to recover, for example, when unable to open a data file.

public class Main {
    public static void main(String[] args) {
        List<Scanner>  scanners = new ArrayList<>();
        try{
            foo();
            while (true) {
               Scanner sc = new Scanner(System.in); //never stops because of garbage collections in java
               System.out.println(sc.hashCode());
               scanners.add(sc);
               throw new OutOfMemoryError();
            }

            
        } catch (OutOfMemoryError e) {
            System.out.println("Caught the error.");
        }
        Scanner sc = new Scanner(System.in);
        scanners.add(new Scanner(System.in));
    }

    private static void foo(){
        System.out.println("Gianne Cruz");
        // try{

        // } catch()
        foo();
    }
}
