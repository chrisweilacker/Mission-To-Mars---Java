import java.util.ArrayList;

public class U2 extends Rocket{
    int maxWeight = 29000;
    int cost = 120;
    int rocketWeight = 18000;

    public boolean launch() {
        double chance = (Math.random() * 100.0);
        double probability = (4.0 * ((cargoWeight * 1.0) /(this.getCargoLimit())));
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
        double probability = (8.0 * ((cargoWeight * 1.0) /(this.getCargoLimit())));
        if (dice <= probability) {
            return false;
        } else {
            return true;
        }
    }
}
