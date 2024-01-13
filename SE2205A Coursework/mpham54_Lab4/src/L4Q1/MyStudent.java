package L4Q1;

public class MyStudent {
    private String firstName;
    private Double score;
    public MyStudent() {
        firstName = "Quang";
        score = 70.00;
    }
    public MyStudent(String firstName,Double score) {
        this.firstName = firstName;
        this.score = score;
    }
    //Used to display information with format
    public String toString() {
        return String.format("%s: %.2f", getFirstName(),getScore());
    }
    //Declaring getter method for first name and score
    public String getFirstName() {
        return firstName;
    }
    public Double getScore(){
        return score;
    }
}
