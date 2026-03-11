package march_06;

import java.util.List;

public class BakerWorker implements Runnable{
    private List<String> breads;

    public BakerWorker(List<String> breads) {
        this.breads = breads;
    }


    @Override
    public void run() {
        while (true) {
            breads.add("Elorde");
            breads.add("CondeBread");
            synchronized (breads) {
                breads.notifyAll();
            }
            System.out.println("BAKED bread, NOW: " + breads.size());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
        }
    }


}
