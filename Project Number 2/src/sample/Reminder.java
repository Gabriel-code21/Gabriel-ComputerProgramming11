package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Reminder {
    private String name;
    private String date;
    private Location place;
    public Person person;


    public Reminder() {
        this.name = "Not specified";
        this.date = "Not specified";
        this.place = new Location();
        this.person = new Person();
    }

    public Reminder(String reminderName, String reminderDueDate, Person person, Location loc) {
        this.name = reminderName;
        this.date = reminderDueDate;
        this.person = person;
        this.place = loc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getPlace() {
        return place;
    }

    public void setPlace(Location place) {
        this.place = place;
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

    @Override
    public String toString() {
        return name;
    }
}
