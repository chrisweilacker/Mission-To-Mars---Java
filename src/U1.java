import java.util.ArrayList;

public class U1 extends Rocket{
    ArrayList<Item> cargo;
    int maxWeight = 18000;
    int cost = 100;
    int rocketWeight = 10000;

    public boolean launch() {
        double chance = (Math.random() * 100.0);
        double probability = (5.0 * ((cargoWeight * 1.0) /(this.getCargoLimit())));
        if (chance <= probability) {
            return false;
        } else {
            return true;
        }
    }

    public int getCost() {
        return this.cost;
    }

    public int getWeightLeft() {
        return maxWeight - rocketWeight - cargoWeight;
    }

    public int getCargoLimit() {
        return maxWeight - rocketWeight;
    }

    public boolean land() {
        double dice = (Math.random() * 100.0);
        double probability = (1.0 * ((cargoWeight * 1.0) /(this.getCargoLimit())));
        if (dice <= probability ) {
            return false;
        } else {
            return true;
        }
    }
}
