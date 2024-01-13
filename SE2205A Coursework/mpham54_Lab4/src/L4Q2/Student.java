package L4Q2;

public class Student implements Comparable<Student> {
    private Double score;
    private String firstName;
    private String lastName;
    //declaring fields for student info
    public Student(){
        firstName="Quang";
        lastName="Pham";
        score= 100.00;
    }//empty constructor with student info of student who wrote this program
    public Student(String firstName, String lastName, Double score){
        this.firstName=firstName;
        this.lastName=lastName;
        this.score=score;
    }//constructor with parameter assigned to fields
    public double getScore(){
        return score;
    }//getter method for score
    public void setScore(Double score){
        this.score = score;
    }//setter method for score
    public String toString(){
        return String.format("%s %s: %.2f", firstName,lastName,score);
    }//format to print student firstName lastName: score
    public int compareTo(Student sc){
        int rv = 0;
        if(this.score>sc.score)
            rv = 1;
        else if(this.score<sc.score)
            rv = -1;
        else
            rv=0;
        return rv;
    }//comparing students score
    public String getFirstName(){
        return firstName;
    }//getter method for first name
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }//setter method for firstname
    public String getLastName(){
        return lastName;
    }//getter method for last name›
    public void setLastName(String lastName){
        this.lastName=lastName;
    }//setter method for last name

}
