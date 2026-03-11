public abstract class BingoChecker implements Runnable{
    public BingoCard card;

    public BingoChecker(BingoCard card){
        this.card = card;
    }

    public BingoCard getCard(){
        return card;
    }
}
