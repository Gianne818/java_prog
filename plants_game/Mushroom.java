public abstract class Mushroom extends Plant{
    boolean stateAsleep;
    public Mushroom(String name, int sun_cost, boolean stateAsleep) {
        super(name, sun_cost);
        this.stateAsleep = stateAsleep;
    }

    public boolean isAwake() { return !stateAsleep; }

    public void awaken(CoffeeBean coffeeBean) { this.stateAsleep = false; }
    
    public String die() { return name + " dies"; }

    public static class SunShroom extends Mushroom implements SunProducer {
        public SunShroom(boolean stateAsleep) {
             super("Sun-shroom", 25, stateAsleep); 
        }
        public int produce_sun() {
            if (isAwake()) {
                 System.out.println(name + " produces 10 suns"); 
                 return 10; 
            }
            System.out.println(name + " is asleep and cannot produce sun"); 
            return 0;
        }
    }

    public static class PuffShroom extends Mushroom implements Attacker{
        public PuffShroom(boolean stateAsleep){
            super("Puff-shroom", 0, stateAsleep); 
        }

        public int rangeType(){
            return 3; 
        }

        public int attack(){
            if(isAwake()){
                System.out.println(name + " attacks"); 
                return 1; 
            }
            else {
                System.out.println(name + " is asleep and cannot attack");
                return 0; 
            }
        }
    }
    
    public static class DoomShroom extends Mushroom implements InstantKiller, Attacker{
        public DoomShroom(boolean stateAsleep){
            super("Doom-shroom", 125, stateAsleep); 
        }
        public int rangeType(){
            return 2; 
        }

        public int killType(){
            return 1; 
        }

        public int attack(){
            if(isAwake()){
                System.out.println(name + " attacks"); 
                die(); 
                return 1; 
            }
            else { System.out.println(name + " is asleep and cannot attack");
                return 0; 
            }
        }
        
        public String die() {
            hp = 0;
            return super.die() + " while exploding and leaves a creater"; 
        }
    }
}
