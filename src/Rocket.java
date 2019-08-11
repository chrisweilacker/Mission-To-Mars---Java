import java.util.ArrayList;

interface SpaceShip {
    public boolean launch();
    public boolean land();
    public boolean canCarry(Item item);
    public void carry(Item item);
    public int getCost();
}

public class Rocket implements SpaceShip {
    ArrayList<Item> cargo = new ArrayList<Item>();
    int maxWeight;
    int rocketWeight;
    int cargoWeight = 0;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public int getCost() {
        return 0;
    }

    public int getWeightLeft() {
        return 0;
    }

    public boolean canCarry(Item item) {

        if (item.weight < this.getWeightLeft()) {
            return true;
        } else {
            return false;
        }
    }

    public void carry(Item item) {
        if (canCarry(item)) {
            cargoWeight += item.weight;
            cargo.add(item);
        } else {
            return;
        }
    }

}

