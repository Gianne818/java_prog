package march_17.ScenicChecker;

import java.util.List;

public class ScenicThread implements Runnable {
    private final List<Integer> scenicNumbers;
    private final int start;
    private final int end;
    private final int threadNum;

    public ScenicThread(List<Integer> scenicNumbers, int start, int end, int threadNum) {
        this.scenicNumbers = scenicNumbers;
        this.start = start;
        this.end = end;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        System.out.printf("Thread %02d: checking range [%d - %d]%n", threadNum, start, end);
        for (int i = start; i <= end; i++) {
            if (isScenic(i)) {
                System.out.printf("Thread %02d: found scenic number %d%n", threadNum, i);
                synchronized (scenicNumbers) {   // lock on the list itself
                    scenicNumbers.add(i);
                }
            }
        }
    }

    private boolean isScenic(int n) {
        if (n < 2) return false;
        int count = 0;
        for (int f = 2; f <= n; f++) {
            while (n % f == 0) {
                count++;
                n /= f;
            }
            if (count > 3) return false;
        }
        return count == 3;
    }

    private boolean isScenic_interpretation2(int n) {
        if (n < 2) return false;
        int distinctCount = 0;
        for (int f = 2; f <= n; f++) {
            if (n % f == 0) {
                distinctCount++;
                while (n % f == 0) n /= f; // divide out all occurrences
            }
            if (distinctCount > 3) return false; // early exit
        }
        return distinctCount == 3;
    }
}

}