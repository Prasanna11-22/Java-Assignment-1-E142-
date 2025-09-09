package assignment;

public class Checkpoint {
    private String id;
    private String name;
    private String timestamp;

    public Checkpoint(String id, String name, String timestamp) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + name + " (ID: " + id + ")";
    }
}


