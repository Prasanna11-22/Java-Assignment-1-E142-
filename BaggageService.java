package assignment;
import java.util.HashMap;
import java.util.Map;

public class BaggageService {
    private Map<String, Baggage> baggageRegistry;

    public BaggageService() {
        baggageRegistry = new HashMap<>();
    }

    // Register bag
    public void registerBag(Baggage bag) {
        baggageRegistry.put(bag.getBagTag(), bag);
        System.out.println("Bag registered: " + bag.getBagTag());
    }

    // Locate bag
    public void locateBag(String bagTag) {
        if (baggageRegistry.containsKey(bagTag)) {
            baggageRegistry.get(bagTag).locateBag();
        } else {
            System.out.println("Bag not found.");
        }
    }

    // Raise claim
    public void raiseClaim(Claim claim) {
        claim.passenger.addClaim(claim);
        System.out.println("Claim raised: " + claim.getClaimId() + " for passenger " + claim.passenger.getName());
    }

    // Settle claims
    public void settleClaims(Passenger p) {
        for (Claim c : p.getClaims()) {
            if (c.getStatus().equals("Pending")) {
                double payout = c.settle();
                System.out.println("Claim " + c.getClaimId() + " settled with payout: " + payout);
            }
        }
    }
}

