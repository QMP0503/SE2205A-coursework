package LE7Q1;

public class QuangValueEntry {
    private Integer key;
    public QuangValueEntry(){
        key = -1;
    }
    public QuangValueEntry(Integer key){
        this.key = key;
    }
    public void setKey(Integer key){
        this.key = key;
    }
    public Integer getKey(){
        return key;
    }
    public String toString() {
        if (key == -1) {
            return "null";
        } else if (key == -111) {
            return "available";
        }else{
            return String.format("%d", key);
        }
    }
}
