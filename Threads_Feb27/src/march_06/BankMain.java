package march_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Thread synchronization is used to protect shared resources.
// using synchronized methods, we pause other threads when a thread access a resource
// Other threads will wait for the first thread to finish before doing their operation.
// They will be in BLOCKED state. Only one at a time will run.

public class BankMain {
    public static void main(String[] args) {
//        BankAccount gianne = new BankAccount("Gianne", 1000);
        BankAccount gianne = new BankAccount("Gianne", 1000, new Scanner(System.in), new Scanner(System.in));
        System.out.println(gianne.getBalance());
//        gianne.withdraw(600);
//        gianne.withdraw(300);
//        gianne.withdraw(400);

        List<Thread> bankThreads = new ArrayList<>();
        bankThreads.add(new Thread(new CostWorker(gianne, "VECO", 600)));
        bankThreads.add(new Thread(new CostWorker(gianne, "MCWD", 300)));
        bankThreads.add(new Thread(new DebitWorker(gianne, "salary", 500)));
        bankThreads.add(new Thread(new CostWorker(gianne, "Genshin", 280)));

        for(Thread t : bankThreads){
            t.start();
        }
//        while(true){
//            for(Thread t : bankThreads){
//                System.out.println(t.getState());
//            }
//        }

//        while(true){
//            bankThreads.getLast().interrupt();
//        }
        System.out.println(gianne.getBalance());

    }
}
