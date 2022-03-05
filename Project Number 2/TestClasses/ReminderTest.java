import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import sample.Location;
import sample.Person;
import sample.Reminder;
import sample.Controller;

public class ReminderTest {
    Reminder r;
    Person p;
    Location l;
    Controller c;

    // Setup
    @Before
    public void setup() {
        r = new Reminder();
        p = new Person();
        l = new Location();
        c = new Controller();
    }

    // Testing to check whether the isEmpty() method in the reminder class works.
    @Test
    public void checkIfEmpty() {
        assertEquals(r.isEmpty(), "Person and Location: Empty");
        r.setPerson(new Person("Bob", "Computer Engineer", "France"));
        assertEquals(r.isEmpty(), "Location: Empty");
        r.setPerson(new Person());
        r.setLocation(new Location("Beach Ave", "Vancouver", "BC", "V6E 1V2"));
        assertEquals(r.isEmpty(), "Person: Empty");
        r.setPerson(new Person("James", "Architect", "Canada"));
        assertEquals(r.isEmpty(), "Complete");
    }

    // Testing to make sure the Controller class is able to take in user input in the form of a Person.
    @Test
    public void testAddPerson() {
        c.tempReminder = r;
        assertEquals(c.tempReminder.isEmpty(), "Person and Location: Empty");
        p = new Person("Bob", "Computer Engineer", "France");
        c.tempReminder.setPerson(p);
        assertEquals(c.tempReminder.getPerson().getName(), "Bob");
    }

    // Testing to make sure the Controller class is able to take in user input in the form of a Location.
    @Test
    public void testAddLocation() {
        c.tempReminder = r;
        assertEquals(c.tempReminder.isEmpty(), "Person and Location: Empty");
        l = new Location("123 Cool Ave", "Vancouver", "BC", "V6E 1P5");
        c.tempReminder.setLocation(l);
        assertEquals(c.tempReminder.getLocation().getAddress(), "123 Cool Ave");
    }


    // Testing to make sure all the constructors of the Person class work
    @Test
    public void testInstantiatePerson() {
        Person p1 = new Person();
        Person p2 = new Person("Bob", true, "Basketball Player");
        Person p3 = new Person("Bob", false, "Canada");
        Person p4 = new Person("Bob", "Basketball Player", "Canada");

        assertEquals(p2.getName(), p3.getName());
        assertEquals(p2.getName(), p4.getName());
        assertEquals(p2.getOccupation(), p4.getOccupation());
        assertEquals(p3.getCountryOfBirth(), p4.getCountryOfBirth());
        assertEquals(p1.getName(), "Unknown Name");
    }

}
