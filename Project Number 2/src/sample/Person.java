package sample;

public class Person {
    private String name;
    private String occupation;
    private String countryOfBirth;

    // Constructor with no parameters
    public Person() {
        this.name = "Unknown Name";
        this.occupation = "Not Specified";
        this.countryOfBirth = "Not Specified";
    }

    // Constructor with 3 parameters
    public Person(String name, String occupation, String countryOfBirth) {
        this.name = name;
        this.occupation = occupation;
        this.countryOfBirth = countryOfBirth;
    }
    // Constructor with 1 parameters
    public Person(String name) {
        this.name = name;
        this.occupation = "Not Specified";
        this.countryOfBirth = "Not Specified";
    }

    // Constructor with 3 parameters
    public Person(String name, boolean flag, String s) {
        this.name = name;
        this.occupation = "Not Specified";
        this.countryOfBirth = "Not Specified";
        if (flag) {
            this.occupation = s;
//            this.countryOfBirth = "Not Specified";
        } else {
//            this.occupation = "Not Specified";
            this.countryOfBirth = s;
        }
    }

//    // Constructor with 1 parameters
//    public Person(String name, String countryOfBirth) {
//        this.name = name;
//        this.occupation = occupation;
//        this.countryOfBirth = "Not Specified";
//    }

    // Getters and Setters for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    // toString has been overridden to be able to print the Person Object
    @Override
    public String toString() {
        return "Name: "+name+" Occupation: "+ occupation+" Country of Birth: "+countryOfBirth;
    }
}
