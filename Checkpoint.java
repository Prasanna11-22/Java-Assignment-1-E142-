package assignment;

public class Checkpoint {
    private String id;
    private String name; // Check-in, Security, Loading, etc.
    private String timestamp;

    // Constructor
    public Checkpoint(String id, String name, String timestamp) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + name + " (ID: " + id + ")";
    }
}

