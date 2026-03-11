package march_06;

import java.util.ArrayList;
import java.util.List;

public class BakerMain {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        List<String> breads = new ArrayList<>();

        threads.add(new Thread(new SellerWorker(breads)));
        threads.add(new Thread(new SellerWorker(breads)));
        threads.add(new Thread(new BakerWorker(breads)));

        for(Thread t : threads){
            t.start();
        }
    }
}
