package sample;

public class Friend {
    private String name;
    private int age;
    private String gender;
    private String occupation;
    private String country;

    public Friend(String name, int age, String gender, String occupation, String country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getCountry() {
        return country;
    }

    public String toString() {
        return name;
    }
}
