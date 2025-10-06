import java.util.Comparator;

public abstract class Plant implements Comparable<Plant>{
    public static final int INFINITE = Integer.MAX_VALUE;

    String name;
    int hp;
    int sun_cost;

    public Plant(String name, int sun_cost) {
        this.name = name;
        this.hp = 6;
        this.sun_cost = sun_cost;
    }

    public Plant(String name, int hp, int sun_cost) {
        this.name = name;
        this.hp = hp;
        this.sun_cost = sun_cost;
    }

    public boolean isAlive() {
       if(hp>0){
           return true;
       } else
        System.out.println(die());
        return false;
    }

    public String die() {
        hp = 0;
        return name + " dies";
    }
    
    public int compareTo(Plant o){
        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }

    @Override
    public String toString() {
        if(hp==INFINITE){
            return name + " (" + "?" + ") " + "- cost: " + sun_cost;
        } else {
            return name + " (" + hp + ") " + "- cost: " + sun_cost;
        }
    }
    
    public static class HPComparator implements Comparator<Plant>{
        public int compare(Plant o1, Plant o2){
            return o1.hp == o2.hp ? o1.compareTo(o2) : -(Integer.compare(o1.hp, o2.hp));
        }
    }
    
    public static class SunCostComparator implements Comparator<Plant>{
        public int compare(Plant o1, Plant o2){
            return o1.sun_cost == o2.sun_cost ? o1.compareTo(o2) : -(Integer.compare(o1.sun_cost, o2.sun_cost));
        }
    }

    public static class WallNut extends Plant{
        public WallNut() {
            super("Wall Nut", 25, 50);
        }
    }

    public static class CoffeeBean extends Plant{
        public CoffeeBean() {
            super("Coffee Bean", INFINITE, 75);
        }
    }
    
    public static class Sunflower extends Plant implements Upgradable, SunProducer{
        public Sunflower() { super("Sunflower", 50); }
        
        public int produce_sun(){ System.out.println(name + " produces 25 suns"); return 25; }
        
        public PlantUpgrade upgrade(){ return new TwinSunflower(50); }
    }
    
    public static class TwinSunflower extends Plant implements PlantUpgrade, SunProducer{
        private boolean exists = false;
        public TwinSunflower() { super("Twin Sunflower", 250); exists = true; }
        public TwinSunflower(int sun_cost){ super("Twin Sunflower", sun_cost); }
        
        public int produce_sun(){ System.out.println(name + " produces 25 suns"); return 50; }
        public int concurrentSunCost(){ return 50; }
    }
    
    public static class Peashooter extends Plant implements Attacker{
        public Peashooter(){ super("Peashooter", 100); }
        public int rangeType(){ return 1; }
        public int attack(){ System.out.println(name + " attacks"); return 1; }
    }
    
    public static class Squash extends Plant implements InstantKiller, Attacker{
        public Squash(){ super("Squash", INFINITE, 50); }
        public int rangeType(){ return 3; }
        public int attack(){ System.out.println(name + " attacks"); System.out.println(this.die()); return 3; }
        public String die() { this.hp = 0; return name + " dies while squashing zombies"; }
        public int killType(){ return 2; }
    }
    
    public static class Jalapeno extends Plant implements InstantKiller, Attacker{
        public Jalapeno(){ super("Jalapeno", INFINITE, 125); }
        public int rangeType(){ return 3; }
        public int attack(){ System.out.println(name + " attacks"); System.out.println(this.die()); this.die(); return 5; }
        public String die() { this.hp = 0; return name + " dies while exploding"; }
        public int killType(){ return 1; }
    }
    
    public static class LilyPad extends Plant implements Upgradable{
        public LilyPad() { super("Lily Pad", 25); }
        public PlantUpgrade upgrade(){ return new Cattail(225); }
    }
    
    public static class Cattail extends Plant implements PlantUpgrade, Attacker{
        public Cattail() { super("Cattail", 225); }
        public Cattail(int sun_cost) { super("Cattail", sun_cost); }
        public int attack(){ System.out.println(name + " attacks"); this.die(); return 1; }
        public int rangeType(){ return 4; }
        public int concurrentSunCost(){ return 50; }
    }
}
