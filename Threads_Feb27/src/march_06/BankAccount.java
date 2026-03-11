package march_06;

import java.util.Scanner;

public class BankAccount {
    private String name;
    private double balance;

    private Scanner a;
    private Scanner b;

    public BankAccount(String name, double balance, Scanner a, Scanner b) {
        this.name = name;
        this.balance = balance;
        this.a = a;
        this.b = b;
    }

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

//    synchronized public boolean withdraw(double amount){
//        System.out.println("WITHDRAWING");
//        if(balance>=amount){
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            balance-=amount;
//            return true;
//        }
//        return false;
//    }


    // in synchronization of threads
    //all object has a lock. this lock can be held only by one object at a time.
    //Thread without a lock will be asleep, and will not be awoken until it gets the lock

    //eliminates race condirions
//    public boolean withdraw(double amount){
//        System.out.println("WITHDRAWING");
//        synchronized (this){ //synchronization is for object, so use "this"
//            if(balance>=amount){
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    System.out.println("INTERRUPTED");
//                }
//                balance-=amount;
//                return true;
//            }
//        }
//
//        return false;
//    }

    public boolean withdraw(double amount){
        synchronized(a){
            System.out.println("WITHDRAWING");
            try{
                Thread.sleep(1000);
                synchronized (b){}
            } catch(InterruptedException e){
                System.out.println("YEy");
            }

        }

        synchronized (this){ //synchronization is for object, so use "this"
            if(balance>=amount){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("INTERRUPTED");
                }
                balance-=amount;
                return true;
            }
        }

        return false;
    }


//    synchronized public void deposit(double amount){
//        System.out.println("DEPOSITING");
//        balance+=amount;
//    }

    public void deposit(double amount){
        System.out.println("DEPOSITING");
        synchronized (this){
            balance+=amount;
        }
    }


    public double getBalance() {
        return balance;
    }
}
