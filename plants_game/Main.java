import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Game Mode: ");
        String mode = sc.nextLine();
        int numAttackers = 0;
        String input;
        do {
            System.out.print("Add a plant: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                case "Wall Nut":
                    plants.add(new Plant.WallNut());
                    break;
                case "Sun-shroom":
                    if("Night".equals(mode)){
                        plants.add(new Mushroom.SunShroom(false));
                    } else plants.add(new Mushroom.SunShroom(true));
                    break;
                // add more plants here
                case "Sunflower":
                    plants.add(new Plant.Sunflower());
                    break;
                case "Twin Sunflower":
                    Plant.Sunflower toUpgrade = null;
                    int sunFlowerIndex = -1;
                    for (int i = 0; i<plants.size(); i++){
                        if(plants.get(i) instanceof Plant.Sunflower){
                            toUpgrade = (Plant.Sunflower)plants.get(i);
                            sunFlowerIndex = i;
                            break;
                        }
                    }
                    if(toUpgrade!=null){
                        plants.remove(toUpgrade);
                        plants.set(sunFlowerIndex, (Plant)toUpgrade.upgrade());
                    }else {
                        plants.add(new Plant.TwinSunflower());
                    }
                    break;
                case "Peashooter":
                    plants.add(new Plant.Peashooter());
                    numAttackers++;
                    break;
                case "Squash":
                    plants.add(new Plant.Squash());
                    numAttackers++;
                    break;
                case "Jalapeno":
                    plants.add(new Plant.Jalapeno());
                    numAttackers++;
                    break;
                case "Coffee Bean":
                    Plant temp = plants.get(0);
                    if(temp instanceof Mushroom && !"Night".equals(mode)){
                        Plant.CoffeeBean temp2 = new Plant.CoffeeBean();
                        ((Mushroom)temp).awaken(temp2);
                        temp2.hp = 0;
                        temp2.isAlive();
                    }
                    break;
                case "Lily Pad":
                    plants.add(new Plant.LilyPad());
                    break;
                case "Cattail":
                    Plant.LilyPad toUpgradeLily = null;
                    int LilyIndex = -1;
                    for (int i = 0; i<plants.size(); i++){
                        if(plants.get(i) instanceof Plant.LilyPad){
                            toUpgradeLily = (Plant.LilyPad)plants.get(i);
                            LilyIndex = i;
                            break;
                        }
                    }
                    if(toUpgradeLily!=null){
                        plants.set(LilyIndex, (Plant)toUpgradeLily.upgrade());
                    }else {
                        plants.add(new Plant.Cattail());
                    }
                    numAttackers++;
                    break;
                case "Doom-shroom":
                    if("Night".equals(mode)){
                        plants.add(new Mushroom.DoomShroom(false));
                    } else 
                    plants.add(new Mushroom.DoomShroom(true));
                    numAttackers++;
                    break;
                case "Puff-shroom":
                    if("Night".equals(mode)){
                        plants.add(new Mushroom.PuffShroom(false));
                    } else
                    plants.add(new Mushroom.PuffShroom(true));
                    numAttackers++;
                    break;
                default:
                    System.out.println(input + " is not a plant");
            }
        } while (!input.equals("DONE"));
    
        
        do {
            System.out.print("Do something: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    break;
                    
                case "Produce Sun":
                    int i = 0;
                    int numSuns = 0;
                    for(Plant p : plants){
                        if(p instanceof SunProducer){
                            numSuns+=((SunProducer)p).produce_sun();
                            i++;
                        }
                    }
                    System.out.println(i + " sun producers gather " + numSuns + " suns");
                    break;
                    
                case "Attack":
                    int x = 0;
                    for (Plant p : plants){
                        if(p instanceof Attacker && p.isAlive()){
                            x+=((Attacker)p).attack();
                        }
                    }

                    if(numAttackers!=0){
                        System.out.println(numAttackers + " attackers dealing " + x + " damage");
                    } else {
                        System.out.println("You have no attackers");
                    }
                    break;
                    
                    
                case "Attacker Status":
                    if(numAttackers==0){
                        System.out.println("You have no attackers");
                    } else {
                        for (Plant p : plants){
                            if(p instanceof Attacker a && p.isAlive()){
                                int stat = a.rangeType();
                                if(stat==1){
                                    System.out.println(p.name + " can attack on a single line");
                                } else if (stat==2){
                                    System.out.println(p.name + " can attack using area-of-effect");
                                } else if (stat==3){
                                    System.out.println(p.name + " can attack only when enemy is nearby");
                                } else if (stat==4){
                                    System.out.println(p.name + " can attack only enemies from anywhere");
                                }
                            }
                            
                        }
                    }
                    
                    break;
                    
                case "Instant Kill Status":
                    int hasPrinted = 0;
                    for (Plant p : plants){
                        if(p instanceof InstantKiller a){
                            int stat = a.killType();
                            if(stat==1){
                                System.out.println(p.name + " can kill instantly");
                                hasPrinted = 1;
                            } else if (stat==2){
                                System.out.println(p.name + " can kill on contact");
                                hasPrinted = 1;
                            }
                        }
                    }
                    if(hasPrinted==0){
                        System.out.println("You have no plants which can kill instantly");
                    }
                    break;
                    
                case "Sort by HP":
                    plants.sort(new Plant.HPComparator());
                    for (Plant p : plants){
                        System.out.println(p);
                    }
                    break;
                    
                case "Sort by Name":
                    Collections.sort(plants);
                    for (Plant p : plants){
                        System.out.println(p);
                    }
                    break;
                    
                case "Sort by Sun Cost":
                    plants.sort(new Plant.SunCostComparator());
                    for (Plant p : plants){
                        System.out.println(p);
                    }
                    break;
                default:
                    System.out.println("Unknown action: " + input);
            }
        } while (!input.equals("DONE"));
    }
}
