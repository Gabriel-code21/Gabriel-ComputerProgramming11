// runs all classes and methods
public class Main {
    public static void main(String[] args) {
        School mySchool = new School("Prince of Wales", 3, 34);

        // adding Students to ArrayList
        mySchool.addStudent(new Student("Kent", "James", 84));
        mySchool.addStudent(new Student("Alice", "May", 98));
        mySchool.addStudent(new Student("Bob", "Bracken", 61));
        mySchool.addStudent(new Student("Joe", "George", 92));
        mySchool.addStudent(new Student("Peter", "Chan", 90));
        mySchool.addStudent(new Student("Sandra", "Wood", 69));
        mySchool.addStudent(new Student("Mark", "Butler", 87));
        mySchool.addStudent(new Student("Ann", "Evans", 64));
        mySchool.addStudent(new Student("Leslie", "Tucker", 80));
        mySchool.addStudent(new Student("Andy", "Bell", 78));

        // adding Teachers to ArrayList
        mySchool.addTeacher(new Teacher("Susan","Johnson","Chemistry"));
        mySchool.addTeacher(new Teacher("Roger","Dodge","Social Studies"));
        mySchool.addTeacher(new Teacher("Anna","Moon","Statistics"));

        // showing the contents of both ArrayLists
        mySchool.showStudents();
        mySchool.showTeachers();

        // splits the 2 print statements making it easier to read
        System.out.println("------------------");

        // removing 2 students
        mySchool.deleteStudent(3);
        mySchool.deleteStudent(8);

        // removing 1 teacher
        mySchool.deleteTeacher(1);

        // showing the contents of both ArrayLists again
        mySchool.showStudents();
        mySchool.showTeachers();

    }
}
