public class BingoRowChecker extends BingoChecker{
    private int row;
    public BingoRowChecker(BingoCard card, int row) {
        super(card);
        this.row = row;
    }

    @Override
    public void run() {

            for(int col = 0; col < 5; col++){
                if(!getCard().getCell(row, col).isPicked()){
                    synchronized (getCard().getCell(row, col)){
                        try {
                            getCard().getCell(row, col).wait();
                        } catch (InterruptedException e) {
                            System.out.println("Card " + getCard().getId() + "'s row loses while waiting for " + getCard().getCell(row, col));
                            return;
                        }

                    }
                }
            }


    }
}
