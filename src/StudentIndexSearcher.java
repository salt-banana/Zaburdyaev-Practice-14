import java.util.ArrayList;

public class StudentIndexSearcher {

    private int linearRecursiveIndex = 0;
    private int binaryRecursiveLeft = -1;
    private int binaryRecursiveRight;

    StudentIndexSearcher() {}

    public int linearSearchIterative(ArrayList<ComparableStudent> studentsList, Student student) {
        int index = 0;
        for (ComparableStudent compStudent: studentsList) {
            if (compStudent.equals(student))
                return index;
            ++index;
        }
        return -1;
    }

    public int linearSearchRecursive(ArrayList<ComparableStudent> studentsList, Student student) {

        if (this.linearRecursiveIndex >= studentsList.size()) {
            this.linearRecursiveIndex = 0;
            return -1;
        }

        ComparableStudent compStudent = studentsList.get(linearRecursiveIndex);

        if (compStudent.equals(student))
            return this.linearRecursiveIndex;
        else
            ++this.linearRecursiveIndex;

        return linearSearchRecursive(studentsList, student);

    }

    public int binarySearchRecursive(ArrayList<ComparableStudent> studentsList, Student student) {

        if (this.binaryRecursiveLeft == -1) {
            this.binaryRecursiveLeft = 0;
            this.binaryRecursiveRight = studentsList.size() - 1;
        }

        if (this.binaryRecursiveLeft > this.binaryRecursiveRight) {
            this.binaryRecursiveLeft = -1;
            this.binaryRecursiveRight = 0;
            return -1;
        }

        int index = (this.binaryRecursiveLeft + this.binaryRecursiveRight) / 2;

        ComparableStudent compStudent = studentsList.get(index);

        if (compStudent.equals(student))
            return index;

        if (compStudent.compareByGPA(student) == 1)
            this.binaryRecursiveRight = index - 1;
        else
            this.binaryRecursiveLeft = index + 1;

        return binarySearchRecursive(studentsList, student);

    }

    public int binarySearchIterative(ArrayList<ComparableStudent> studentsList, Student student) {
        int left = 0;
        int right = studentsList.size() - 1;
        int index;
        ComparableStudent compStudent;

        while (left <= right) {

            index = (left + right) / 2;

            compStudent = studentsList.get(index);

            if (compStudent.equals(student))
                return index;

            if (compStudent.compareByGPA(student) == 1)
                right = index - 1;
            else
                left = index + 1;

        }

        return -1;

    }

}
