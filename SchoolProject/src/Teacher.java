// this class contains all information pertaining to teachers
public class Teacher {
    // all needed fields
    private String firstName;
    private String lastName;
    private String subject;

    // two constructors that allow user to have more control when using this class
    // if input is empty
    public Teacher() {
        firstName = "Not Specified";
        lastName = "Not Specified";
        subject = "Not Specified";
    }
    // if input has details
    public Teacher(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSubject() {
        return subject;
    }



    // when teacher class printed it will be in the correct format
    public String toString() {
        return "Name: \""+firstName+" "+lastName+"\" Subject: "+subject;
    }
}