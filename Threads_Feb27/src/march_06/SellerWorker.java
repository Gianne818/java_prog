package march_06;

import java.util.List;

public class SellerWorker implements Runnable{

    private List<String> breads;
    private static int ID;
    private  int id;

    public SellerWorker(List<String> breads) {
        this.breads = breads;
        id = ID++;
    }

    @Override
    public void run() {
        while(true) {
            try {
                synchronized (breads) {
                    if (breads.isEmpty()) {
                        System.out.println("WAITING");
                        breads.wait();
                    }
                    breads.removeFirst();
                    System.out.println(id + " SOLD bread, NOW: " + breads.size());
                }
            } catch (InterruptedException e) {

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
//    public void run() {
//        while (true) {
//            try {
//                synchronized (breads) {
//                    if (breads.isEmpty()) {
//                        System.out.println("WAITING");
//                        breads.wait();
//                    }
//                    breads.removeFirst();
//                    System.out.println(id + " SOLD bread, NOW: " + breads.size());
//                }
//            } catch (InterruptedException e) {
//
//            }
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }

}
