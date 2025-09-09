package assignment;

public abstract class Claim {
    protected String claimId;
    protected Baggage baggage;
    protected Passenger passenger;
    protected String status;

    public Claim(String claimId, Baggage baggage, Passenger passenger) {
        this.claimId = claimId;
        this.baggage = baggage;
        this.passenger = passenger;
        this.status = "Pending";
    }

    public String getClaimId() { return claimId; }
    public String getStatus() { return status; }

    public abstract double settle();

    @Override
    public String toString() {
        return "Claim ID: " + claimId + ", Status: " + status + ", BagTag: " + baggage.getBagTag();
    }
}


