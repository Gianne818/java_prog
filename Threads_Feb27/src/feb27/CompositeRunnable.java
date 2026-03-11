import java.util.function.DoubleToIntFunction;

public class CompositeRunnable implements Runnable {
    int start, end;

    static int staticCount = 0;

    public CompositeRunnable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run(){
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){

        }
        int countLocal = 0;
        System.out.println("STARTING " + end);
        int count = 0;
        for (int i = start; i <= end; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    countLocal++;
                    count++;
                    break;
                }
            }
        }
        staticCount += countLocal;
//        System.out.println(end + " COUNT = " + count);
//        System.out.println("MAIN COUNT = " + staticCount);
    }

    int getEnd(){
        return end;
    }
}
