package march_17.PasswordCracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordMain {
    private static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password to guess: ");
        String password = sc.nextLine();

        PasswordCracker cracker = new PasswordCracker(password);

        int length = password.length();
        int totalThreads = length*5;


        List<Thread> threads = new ArrayList<>();
        for( int i = 0; i<5; i++){
            for(int j = length-1; j>=0; j--){
                threads.add(new Thread(new GuesserThread(cracker, vowels[i], j, length)));
            }
        }

        long start = System.currentTimeMillis();
        for(Thread t : threads){
            t.start();
        }

        for(Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {

            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Password found: " + cracker.getFinder());
        System.out.println("TIME: " + (end-start));


    }
}

//public class PasswordMain {
//    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
//    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
//
//    public static void main(String[] args){
//        String password = "oten"; // Change this to test
//        PasswordCracker cracker = new PasswordCracker(password);
//
//        int n = password.length();
//        int totalThreads = n * VOWELS.length;
//        List<Thread> threads = new ArrayList<>();
//
//        int threadNum = 1;
//        for (int v = 0; v < VOWELS.length; v++) {
//            for (int pos = n - 1; pos >= 0; pos--) {
//                char vowel = VOWELS[v];
//                int tNum = threadNum++;
//
//                threads.add(new Thread(new GuesserThread(cracker, VOWELS[v], pos, n)));
////                Thread t = new Thread(new GuesserThread(cracker, vowel, pos, n, tNum));
////                threads.add(t);
//            }
//        }
//
//        long start = System.currentTimeMillis();
//
//        for (Thread t : threads) t.start();
//
//        for(Thread t : threads){
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//
//            }
//        }
//
//        System.out.println("\n--- Password found: " + cracker.getFinder() + " ---");
//        long end = System.currentTimeMillis();
//        System.out.println("Time: " + (end-start));
//
//        for (Thread t : threads) t.interrupt();
//    }
//}
