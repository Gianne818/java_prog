public class BingoColumnChecker extends BingoChecker{
    private int col;
    public BingoColumnChecker(BingoCard card, int col) {
        super(card);
        this.col = col;
    }

    @Override
    public void run() {
        for(int row = 0; row < 5; row ++){
            if(!getCard().getCell(row, col).isPicked()){
                synchronized (getCard().getCell(row, col)){
                    try {
                        getCard().getCell(row, col).wait();
                    } catch (InterruptedException e) {
                        System.out.println("Card " + getCard().getId() + "'s column loses while waiting for " + getCard().getCell(row, col));
                        return;
                    }
                }
            }
        }
    }
}
