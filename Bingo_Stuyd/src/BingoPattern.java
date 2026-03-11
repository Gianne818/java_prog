import java.util.*;
public abstract class BingoPattern implements Runnable{
    protected List<Thread> threads;
    private BingoGame game;
    private BingoCard card;

    public BingoPattern(BingoGame game, BingoCard card){
        this.card = card;
        this.game = game;
        threads = new ArrayList<>();
    }

    @Override
    public void run(){
        for(Thread t: threads){
            t.start();
            //System.out.println(t.getState());
        }
//
//        for(Thread t: threads){
//            System.out.println(t.getState());
//        }


        //t1 runnable end... terminate
        //t2 runnable end... terminate
        //t3 runnable end... terminate

        for(Thread t : threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                for(Thread t1 : threads){
                    t1.interrupt();
                }
                return;
            }
        }
        game.setBingo();
        System.out.println("Card " + card.getId() + " complete pattern");
        System.out.println(card);
    }


}
