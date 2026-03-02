import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int max = 500_000;
        int prev = 2;
        int thr = 100;
        int div = max/thr;
        List<Thread> composites = new ArrayList<>();
        for(int i = 1; i<=thr; i++){
//            composites.add(new Thread(new CompositeRunnable(50_000*i+1, 50_000*(i+1))));
            composites.add(new Thread(new CompositeRunnable(prev, i == thr ? max : div*i)));
            prev = div * i + 1;
        }

        System.out.println(composites.getFirst().isAlive());
        System.out.println(composites.getFirst().getState());



        System.out.println(composites.getFirst().getState());

//        try{
//            Thread.sleep(1000);
//        } catch(InterruptedException e){
//
//        }
        System.out.println("Waking up!");

//        while(composites.getLast().isAlive());

        long start = System.currentTimeMillis();
        for (Thread c : composites){
            c.start();
        }
        int i = 0;
        for(Thread c : composites){
//            while(c.isAlive());
            try{
                c.join();
                System.out.println(i++ + " dies");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("MAIN COUNT on main: " + CompositeRunnable.staticCount);
        System.out.println("MAIN TIME: " + (end-start));

         //indeterminancy, threads will fight for resources,  who gets the output console first
//        List<Thread> threads = new ArrayList<>();
//        for(int i = 0; i<1000; i++){
//            threads.add(new NamedThread("Thread " + (i+1)));
//        }
//
//        for(Thread t : threads){
//            t.start();
//        }
//
//        for(Thread t : threads){
//            t.run();
//        }

//        List<Thread> runnables = new ArrayList<>();
//        for(int i = 0; i<1000; i++){
//            runnables.add(new Thread(new NamedRunnable("Runnable " + (i+1))));
//        }
//
//        for(Thread r : runnables){
//            r.start();
//        }
//
//        NamedThread gianneThread = new NamedThread("Gianne");
//        gianneThread.start(); //start starts a new thread. calling run will just put call the run function within the same thread
//
//        System.out.println("Mana si main");
//        System.out.println("Enter age: ");
//        Scanner sc = new Scanner(System.in);
//        int age = sc.nextInt();
//        System.out.println("The age: " + age);
    }
}
