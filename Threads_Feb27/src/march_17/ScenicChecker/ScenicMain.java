package march_17.ScenicChecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ScenicMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter upperbound: ");
        int end = sc.nextInt();

        int start = 1;
        int numThreads = 4;
        int rangeSize = (end - start + 1) / numThreads;

        List<Integer> scenicNumbers = new ArrayList<>();  // just a normal arraylist

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            int threadStart = start + (i * rangeSize);
            int threadEnd = (i == numThreads - 1) ? end : threadStart + rangeSize - 1;
            int threadNum = i + 1;

            threads.add(new Thread(new ScenicThread(scenicNumbers, threadStart, threadEnd, threadNum)));
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        Collections.sort(scenicNumbers);
        System.out.println("\n--- Scenic Numbers from " + start + " to " + end + " ---");
        System.out.println(scenicNumbers);
        System.out.println("Total: " + scenicNumbers.size());
    }
}