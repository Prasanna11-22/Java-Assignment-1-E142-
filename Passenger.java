package assignment;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String paxId;
    private String name;
    private String flightNo;
    private String contact;
    private List<Claim> claims;

    public Passenger(String paxId, String name, String flightNo, String contact) {
        this.paxId = paxId;
        this.name = name;
        this.flightNo = flightNo;
        this.contact = contact;
        this.claims = new ArrayList<>();
    }
    public String getPaxId() { return paxId; }
    public String getName() { return name; }
    public String getFlightNo() { return flightNo; }
    public String getContact() { return contact; }
    public List<Claim> getClaims() { return claims; }

    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    public void printClaims() {
        System.out.println("Claims for Passenger " + name + ":");
        for (Claim c : claims) {
            System.out.println(c);
        }
    }
}

