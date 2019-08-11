import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Simulation {

    public ArrayList<Item> LoadItems(String fileLocation) {
        ArrayList<Item> items = new ArrayList();
        try {
            File file = new File(fileLocation);
            Scanner scanner = new Scanner(file);



            while (scanner.hasNext()) {
                String i = scanner.nextLine();
                String[] arrOfStr = i.split("=");
                Item item = new Item();
                item.name = arrOfStr[0];
                item.weight = Integer.parseInt(arrOfStr[1]);
                items.add(item);
            }

            return items;
        } catch (Exception e) {
            return items;
        }

    }

    public ArrayList<Rocket> loadU1 (ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList();
        U1 rocket = new U1();
        for (int i=0; i<items.size(); i++) {
            if (rocket.canCarry(items.get(i))) {
                rocket.carry(items.get(i));
            } else {
                rockets.add(rocket);
                rocket = new U1();
                rocket.carry(items.get(i));
            }
        }
        rockets.add(rocket);
        return rockets;
    }

    public ArrayList<Rocket> loadU2 (ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList();
        U2 rocket = new U2();
        for (Item item: items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = new U2();
                rocket.carry(item);
            }
        }
        rockets.add(rocket);
        return rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int totalCost = 0;
        for (Rocket rocket: rockets) {
            totalCost += rocket.getCost();
            boolean launched = rocket.launch();
            boolean landed = rocket.land();
            while(!launched && !landed) {
                totalCost += rocket.getCost();
                landed = rocket.land();
                launched = rocket.launch();
            }
        }
        return totalCost;
    }


}
