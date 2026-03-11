import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingoGame implements Runnable{

    private BingoCell[] result;
    private boolean bingo;

    private Thread[] threads;

    @Override
    public void run() {
        this.bingo = false;
        result = new BingoCell[76];
        for(int i = 0; i <= 75; i++){
            result[i] = new BingoCell(i);
        }
        result[0].setPicked();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players? ");
        int n = sc.nextInt();
        BingoCard[] cards = new BingoCard[n];
        for (int i = 0; i < n; i++){
            cards[i] = new BingoCard(this);
            System.out.println(cards[i]);
        }
        System.out.print("Select pattern (+ , #): ");
        sc.nextLine();
        char op = sc.nextLine().charAt(0);
        threads = new Thread[n];

        switch(op){
            case '+':
                for(int i = 0; i < n; i++){
                    threads[i] = new Thread(new BingoPatternPlus(this, cards[i]));
                }
                break;
            case '#':
                for(int i = 0; i < n; i++){
                    threads[i] = new Thread(new BingoPatternHash(this, cards[i]));
                }
                break;

        }
        for(Thread t : threads){
            t.start();
        }

        List<Integer> chosen = new ArrayList<>();
        while(!bingo){
            int num;
            do{
                num = (int) (Math.random() * 75 + 1);
            }while(chosen.contains(num));
            chosen.add(num);
            result[num].setPicked();
            System.out.println("CHOSEN " + num);
            System.out.println("LIST: ");
            for(int i : chosen){
                System.out.print(i + " ");
            }
            System.out.println();
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){

            }
        }


    }

    public synchronized void setBingo() {
        this.bingo = true;
        if (threads != null) {
            for (Thread t : threads) {
                if (t.isAlive()) {
                    t.interrupt();
                }
            }
        }
    }

    public BingoCell getCell(int index){
        return result[index];
    }

    public static void main(String[] args) {
        new Thread(new BingoGame()).start();
    }
}
