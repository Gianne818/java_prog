import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BingoGame implements Runnable{

    private BingoCell[] possibleCellValues;
    private boolean bingo;

    private Thread[] threads;

    @Override
    public void run() {
        this.bingo = false;
        possibleCellValues = new BingoCell[76]; //1 to 75

        //initialize bingo cells, from 0-75
        for(int i = 0; i <= 75; i++){
            possibleCellValues[i] = new BingoCell(i);
        }
        possibleCellValues[0].setPicked(); //result is the bonus on r=2 c=2


        Scanner sc = new Scanner(System.in);
        System.out.println("How many players? ");
        int n = sc.nextInt();
        threads = new Thread[n];

        //each player gets one bingo card. this determines the number of BingoPattern threads
        BingoCard[] cards = new BingoCard[n];
        for (int i = 0; i < n; i++){
            cards[i] = new BingoCard(this);
            System.out.println(cards[i]);
        }

        System.out.print("Select pattern (+ , #): ");
        sc.nextLine();
        char op = sc.nextLine().charAt(0);


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

            default:
                System.out.println("Wrong input.");
                return;

        }
        for(Thread t : threads){
            t.start();
        }

        //now we draw the bingo balls value
        List<Integer> chosen = new ArrayList<>();
        while(!bingo){
            int num;
            do{
                num = (int) (Math.random() * 75 + 1);
            }while(chosen.contains(num));
            chosen.add(num);

            possibleCellValues[num].setPicked();
            System.out.println("CHOSEN " + num);
            System.out.println("LIST: ");
            for(int i : chosen){
                System.out.print(i + " ");
            }
            System.out.println();
            try{
                Thread.sleep(0);
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

        synchronized(this){}
    }

    public BingoCell getCell(int index){
        return possibleCellValues[index];
    }

    public static void main(String[] args) {
        new Thread(new BingoGame()).start();
    }
}
