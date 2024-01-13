package L4Q2;

import java.util.Comparator;

public class HelperClassComparePham implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        return s1.getLastName().compareTo(s2.getLastName());
    }//comparing students last name
}
