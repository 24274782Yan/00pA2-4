import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First, compare visitors by age
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        // If ages are not equal, return the result of the age comparison
        if (ageCompare != 0) {
            return ageCompare;
        }
        // If ages are equal, compare visitors by name
        return v1.getName().compareTo(v2.getName());
    }
}