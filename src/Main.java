import java.util.ArrayList;

public class Main {
    public static void main (String args[]) {
        Simulation sim = new Simulation();
        ArrayList <Item> phase1 = sim.LoadItems("/Users/chrisweilacker/Desktop/Java/Mission To Mars/src/phase-1.txt");
        ArrayList <Item> phase2 = sim.LoadItems("/Users/chrisweilacker/Desktop/Java/Mission To Mars/src/phase-2.txt");
        ArrayList <Rocket> u1P1 = sim.loadU1(phase1);
        ArrayList <Rocket> u1P2 = sim.loadU1(phase2);
        int budgetU1 = sim.runSimulation(u1P1);
        budgetU1 += sim.runSimulation(u1P2);

        System.out.println("Total budget for U-1 Rockets is: "  + budgetU1 + " millions");

        ArrayList <Rocket> u2P1 = sim.loadU2(phase1);
        ArrayList <Rocket> u2P2 = sim.loadU2(phase2);
        int budgetU2 = sim.runSimulation(u2P1);
        budgetU2 += sim.runSimulation(u2P2);

        System.out.println("Total budget for U-2 Rockets is: "  + budgetU2 + " millions");

    }
}
