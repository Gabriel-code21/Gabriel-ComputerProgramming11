package sample;

public class Reminder {
    private String name;
    private String date;
    private Location location;
    public Person person;

    // Constructor with no parameters
    public Reminder() {
        this.name = "Not specified";
        this.date = "Not specified";
        this.person = new Person();
        this.location = new Location();
    }

    // Constructor with 4 parameters
    public Reminder(String reminderName, String reminderDueDate, Person person, Location loc) {
        this.name = reminderName;
        this.date = reminderDueDate;
        this.person = person;
        this.location = loc;
    }

    // Getters and Setters for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Used to check if person and or place are empty
    public String isEmpty() {
        String toReturn = "";
        if (this.person.getName().equals("Unknown Name") && this.location.getZipCode().equals("N/A")) {
            toReturn = "Person and Location: Empty";
        } else if (this.person.getName().equals("Unknown Name")) {
            toReturn = "Person: Empty";
        } else if (this.location.getZipCode().equals("N/A")) {
            toReturn = "Location: Empty";
        } else {
            toReturn = "Complete";
        }
        return toReturn;
    }

    // toString has been overridden to be able to print the Reminder.name
    @Override
    public String toString() {
        return name;
    }
}
