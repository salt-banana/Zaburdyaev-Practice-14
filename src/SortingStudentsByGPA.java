import java.util.ArrayList;

public class SortingStudentsByGPA {

    public void sort(ArrayList<ComparableStudent> studentsList, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;
            Student midStudent = (Student) studentsList.get(mid);

            int i = left;
            int j = right;

            while (i <= j) {

                Student studentA = (Student) studentsList.get(i);
                Student studentB = (Student) studentsList.get(j);

                while (studentA.compareByGPA(midStudent) < 0) {
                    i++;
                    studentA = (Student) studentsList.get(i);
                }
                while (studentB.compareByGPA(midStudent) > 0) {
                    j--;
                    studentB = (Student) studentsList.get(j);
                }

                if (i >= j)
                    break;

                studentsList.set(i, studentB);
                studentsList.set(j, studentA);

                i++;
                j--;

            }

            sort(studentsList, left, j);
            sort(studentsList, j + 1, right);

        }

    }

}
