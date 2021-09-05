import java.util.ArrayList;

// school class "manages" all instances of the Student and Teacher classes
public class School {
    // all needed fields
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    private String schoolName;
    private int numSchoolTrophies;
    private int numCourses;

    private ArrayList<Courses> courses; // not used, but is required in the assignment description

    // two constructors that allow user to have more control when using this class
    // if input is empty
    public School() {
        schoolName = "Not Specified";
    }

    // if input has details
    public School(String schoolName, int numSchoolTrophies, int numCourses) {
        this.schoolName = schoolName;
        this.numSchoolTrophies = numSchoolTrophies;
        this.numCourses = numCourses;
    }
    // uses "add" method of the ArrayList class
    public void addTeacher(Teacher newTeacher) {
        teachers.add(newTeacher);
    }
    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    // uses "remove" method of ArrayList class
    public void deleteTeacher(int index) {
        teachers.remove(index);
    }
    public void deleteStudent(int index) {
        students.remove(index);
    }

    // iterates and prints each value in the ArrayList
    public void showTeachers() {
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println(teachers.get(i));
        }
    }
    public void showStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    // setters
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setNumSchoolTrophies(int numSchoolTrophies) {
        this.numSchoolTrophies = numSchoolTrophies;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    // getters
    public String getSchoolName() {
        return schoolName;
    }

    public int getNumSchoolTrophies() {
        return numSchoolTrophies;
    }

    public int getNumCourses() {
        return numCourses;
    }

}


