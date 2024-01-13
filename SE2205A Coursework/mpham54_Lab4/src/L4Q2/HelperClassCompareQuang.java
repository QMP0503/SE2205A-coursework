package L4Q2;

import java.util.Comparator;

public class HelperClassCompareQuang implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        return s1.getFirstName().compareTo(s2.getFirstName());
    }//comparing students first name
}
