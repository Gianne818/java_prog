import java.util.*;
public class BingoCard {
    private BingoCell[][] nums;
    private int id;
    private static int ID = 1;


    public BingoCard(BingoGame game){
        id = ID++;
        nums = new BingoCell[5][5];
        int[] start = {1, 16, 31, 46, 61};

        //TO RANDOMIZE
        Random rand = new Random();

        for(int i = 0; i < 5; i++){
            HashSet<Integer> used = new HashSet<Integer>();
            for(int j = 0; j < 5; j++){
                if(j==2 && i==2) continue;

                int num;
                do{
                    num = start[i] + rand.nextInt(15);
                }while(used.contains(num));

                used.add(num);
                nums[j][i] = game.getCell(num);
            }
        }

        nums[2][2] = game.getCell(0);
    }

    public BingoCell getCell(int r, int c){
        return nums[r][c];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Card " + id + "\n");
        sb.append("B\tI\tN\tG\tO\n");
        for(int i = 0; i < 5; i++){

            for(int j = 0; j < 5; j++){
                sb.append(nums[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getId(){
        return id;
    }

    public static void main(String[] args) {
        BingoGame game = new BingoGame();
        new Thread(game).start();
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ignored){

        }


        System.out.println(new BingoCard(game));
    }
}

//public class BingoCard{
//    private BingoCell[][] nums;
//    private static int ID = 1;
//    private  int id;
//
//    public BingoCard(BingoGame game) {
//        this.nums = nums;
//        this.id = ID++;
//    }
//}

/*
3 3 3 3 3
3 3 3 3 3
3 3 3 3 3
3 3 3 3 3
3 3 3 3 3



 */
