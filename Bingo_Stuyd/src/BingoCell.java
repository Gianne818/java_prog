public class BingoCell {
   private int num;
   private boolean picked;

   public BingoCell(int num){
       this.num = num;
       this.picked = false;
   }

   public void setPicked(){
       this.picked = true;
       synchronized (this){
           notifyAll();
       }
   }
   public boolean isPicked(){
       return picked;
   }

   public String toString(){
       return num + "";
   }
}
