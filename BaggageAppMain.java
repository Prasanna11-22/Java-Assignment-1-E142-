package assignment;
import java.util.Scanner;

public class BaggageAppMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaggageService service = new BaggageService();

        Passenger currentPassenger = null;
        Baggage currentBaggage = null;

        int choice;
        do {
            System.out.println("\n=== Baggage Tracking System Menu ===");
            System.out.println("1. Register Passenger");
            System.out.println("2. Register Baggage");
            System.out.println("3. Update Baggage Movement");
            System.out.println("4. Locate Baggage");
            System.out.println("5. Print Baggage Route");
            System.out.println("6. Raise Loss Claim");
            System.out.println("7. Raise Damage Claim");
            System.out.println("8. Settle All Claims");
            System.out.println("9. Print Passenger Claims");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Passenger ID: ");
                    String paxId = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Flight No: ");
                    String flightNo = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();
                    currentPassenger = new Passenger(paxId, name, flightNo, contact);
                    System.out.println("Passenger registered successfully.");
                    break;

                case 2:
                    if (currentPassenger == null) {
                        System.out.println("Register a passenger first!");
                        break;
                    }
                    System.out.print("Enter Bag Tag: ");
                    String bagTag = sc.nextLine();
                    System.out.print("Enter Weight: ");
                    double weight = sc.nextDouble();
                    sc.nextLine();
                    currentBaggage = new Baggage(bagTag, weight, currentPassenger);
                    service.registerBag(currentBaggage);
                    break;

                case 3:
                    if (currentBaggage == null) {
                        System.out.println("Register baggage first!");
                        break;
                    }
                    System.out.print("Enter Checkpoint ID: ");
                    String cpId = sc.nextLine();
                    System.out.print("Enter Checkpoint Name: ");
                    String cpName = sc.nextLine();
                    System.out.print("Enter Timestamp: ");
                    String ts = sc.nextLine();
                    currentBaggage.updateMovement(cpId, cpName, ts);
                    System.out.println("Movement updated.");
                    break;

                case 4: 
                    if (currentBaggage != null) {
                        service.locateBag(currentBaggage.getBagTag());
                    } else {
                        System.out.println("No baggage registered yet.");
                    }
                    break;

                case 5: 
                    if (currentBaggage != null) {
                        currentBaggage.printRoute();
                    } else {
                        System.out.println("No baggage registered yet.");
                    }
                    break;

                case 6:
                    if (currentBaggage == null || currentPassenger == null) {
                        System.out.println("Register passenger and baggage first!");
                        break;
                    }
                    System.out.print("Enter Claim ID: ");
                    String lossId = sc.nextLine();
                    Claim lossClaim = new LossClaim(lossId, currentBaggage, currentPassenger);
                    service.raiseClaim(lossClaim);
                    break;

                case 7:
                    if (currentBaggage == null || currentPassenger == null) {
                        System.out.println("Register passenger and baggage first!");
                        break;
                    }
                    System.out.print("Enter Claim ID: ");
                    String damageId = sc.nextLine();
                    Claim damageClaim = new DamageClaim(damageId, currentBaggage, currentPassenger);
                    service.raiseClaim(damageClaim);
                    break;

                case 8:
                    if (currentPassenger != null) {
                        service.settleClaims(currentPassenger);
                    } else {
                        System.out.println("No passenger registered yet.");
                    }
                    break;

                case 9:
                    if (currentPassenger != null) {
                        currentPassenger.printClaims();
                    } else {
                        System.out.println("No passenger registered yet.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}

