// this class contains all information pertaining to students and has a static field for incrementing the Student Number
public class Student {
    // all needed fields
    private int studentNumber;
    private static int studentNumberCounter = 0;

    private String firstName;
    private String lastName;
    private int grade;

    // two constructors that allow user to have more control when using this class
    // if input is empty
    public Student() {
        firstName = "Not Specified";
        lastName = "Not Specified";
        studentNumber = studentNumberCounter;
        studentNumberCounter++;
    }
    // if input has details
    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;

        studentNumber = studentNumberCounter;
        studentNumberCounter++;
    }

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }
    // studentNumber getter, there is no setter for studentID because it is not allowed to change
    public int getStudentNumber() {
        return studentNumber;
    }

    // when student class printed it will be in the correct format
    public String toString() {
        return "Name: \""+firstName+" "+lastName+"\" Grade: "+grade;
    }
}
