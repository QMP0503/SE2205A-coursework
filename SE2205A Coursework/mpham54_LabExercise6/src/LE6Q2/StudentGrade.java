package LE6Q2;

public class StudentGrade implements Comparable<StudentGrade> {
    private String firstName;
    private String lastName;
    private int grade;
    public StudentGrade() {
        // Empty constructor
    }
    public StudentGrade(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int compareTo(StudentGrade other) {
        // Compare based on grades
        return Integer.compare(this.grade, other.grade);
    }
    public String toString() {
        return String.format("%s %s : %d ", firstName, lastName, grade);
    }
}

