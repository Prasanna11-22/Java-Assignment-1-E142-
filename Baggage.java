package assignment;

import java.util.ArrayList;
import java.util.List;

public class Baggage {
    private String bagTag;
    private double weight;
    private Passenger owner;
    private List<Checkpoint> route;
    private String status;

    public Baggage(String bagTag, double weight, Passenger owner) {
        this.bagTag = bagTag;
        this.weight = weight;
        this.owner = owner;
        this.route = new ArrayList<>();
        this.status = "Registered";
    }

    public String getBagTag() { return bagTag; }
    public double getWeight() { return weight; }
    public Passenger getOwner() { return owner; }
    public String getStatus() { return status; }

    public void updateMovement(Checkpoint cp) {
        route.add(cp);
        this.status = "At " + cp.getName();
    }

    public void updateMovement(String checkpointId, String name, String timestamp) {
        updateMovement(new Checkpoint(checkpointId, name, timestamp));
    }

    public void locateBag() {
        if (route.isEmpty()) {
            System.out.println("Bag " + bagTag + " has not moved yet. Status: " + status);
            return;
        }
        Checkpoint last = route.get(route.size() - 1);
        System.out.println("Bag " + bagTag + " currently at " + last.getName() + " (" + last.getTimestamp() + ")");
    }

    public void printRoute() {
        System.out.println("Route history for Bag " + bagTag + ":");
        if (route.isEmpty()) {
            System.out.println("  No checkpoints recorded.");
            return;
        }
        for (Checkpoint cp : route) {
            System.out.println("  " + cp);
        }
    }
}


