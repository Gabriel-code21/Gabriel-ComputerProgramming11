package sample;

public class Person {
    private String name;
    private int age;
    private String occupation;
    private String countryOfBirth;

    public Person() {
        this.name = "Unknown Name";
        this.age = -1;
        this.occupation = "Unknown Occupation";
        this.countryOfBirth = "Unknown Country of Birth";
    }

    public Person(String name, int age, String occupation, String countryOfBirth) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.countryOfBirth = countryOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "Name: "+name+" Age: "+age+" Occupation: "+ occupation+" Country of Birth: "+countryOfBirth;
    }
}
