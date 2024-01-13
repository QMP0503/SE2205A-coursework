package Lab5;

public class Passenger implements Comparable<Passenger>{
    private String name;
    private Integer seat;
    public Passenger(String name, Integer seat){
        this.name=name;
        this.seat = seat;
    }
    public String getName(){
        return name;
    }//getter method for name
    public void setName(String firstName){
        this.name=name;
    }//setter method for name
    public void setSeat(Integer seat) {
        this.seat = seat;
    }//setter method for seat
    public Integer getSeat(){
        return seat;
    }//getter method for seat

    public int compareTo(Passenger other) {
        // Custom comparator based on seat number (lower seat number has higher priority)
        int seatPriority = Integer.compare(this.seat, other.seat);

        // If seat numbers are the same, compare by name
        return (seatPriority == 0) ? this.name.compareTo(other.name) : seatPriority;
    }
    public String toString(){
        return String.format("[Name: %s, Seat: %d]",getName(),getSeat());
    }
}
