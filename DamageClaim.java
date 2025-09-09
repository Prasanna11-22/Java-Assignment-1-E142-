package assignment;

public class DamageClaim extends Claim {
    private double compensationAmount;

    public DamageClaim(String claimId, Baggage baggage, Passenger passenger) {
        super(claimId, baggage, passenger);
    }

    @Override
    public double settle() {
        this.compensationAmount = baggage.getWeight() * 500; 
        this.status = "Settled";
        return compensationAmount;
    }

    @Override
    public String toString() {
        return super.toString() + " [Damage Claim, Compensation=" + compensationAmount + "]";
    }
}


