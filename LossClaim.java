package assignment;

public class LossClaim extends Claim {
    private double compensationAmount;

    public LossClaim(String claimId, Baggage baggage, Passenger passenger) {
        super(claimId, baggage, passenger);
    }

    @Override
    public double settle() {
        // Example logic: Full compensation based on weight
        this.compensationAmount = baggage.getWeight() * 1000; 
        this.status = "Settled";
        return compensationAmount;
    }

    @Override
    public String toString() {
        return super.toString() + " [Loss Claim, Compensation=" + compensationAmount + "]";
    }
}

