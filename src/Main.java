import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<ComparableStudent> studentsList = new ArrayList<>();

        Student a = new Student(80); studentsList.add(a);
        Student b = new Student(70); studentsList.add(b);
        Student c = new Student(50); studentsList.add(c);
        Student d = new Student(60); studentsList.add(d);
        Student e = new Student(30); studentsList.add(e);
        Student f = new Student(20); studentsList.add(f);
        Student g = new Student(40); studentsList.add(g);

        System.out.println("==== INITIAL LIST ====");

        for (ComparableStudent student: studentsList) {
            System.out.println(student);
        }



        StudentIndexSearcher sis = new StudentIndexSearcher();

        Student existingStudent = new Student(30);
        Student nonExistingStudent = new Student(88);

        int indexLinItExisting = sis.linearSearchIterative(studentsList, existingStudent);
        int indexLinItNonExisting = sis.linearSearchIterative(studentsList, nonExistingStudent);
        int indexLinRecExisting = sis.linearSearchRecursive(studentsList, existingStudent);
        int indexLinRecNonExisting = sis.linearSearchRecursive(studentsList, nonExistingStudent);

        System.out.println("==== LINEAR SEARCH INDEXES ====");
        System.out.println("indexLinItExisting = " + indexLinItExisting + "\n" +
                           "indexLinItNonExisting = " + indexLinItNonExisting + "\n" +
                           "indexLinRecExisting = " + indexLinRecExisting +"\n" +
                           "indexLinRecNonExisting = " + indexLinRecNonExisting);

        existingStudent = new Student(40);
        nonExistingStudent = new Student(99);

        indexLinRecExisting = sis.linearSearchRecursive(studentsList, existingStudent);
        indexLinRecNonExisting = sis.linearSearchRecursive(studentsList, nonExistingStudent);

        System.out.println("indexLinRecExisting = " + indexLinRecExisting +"\n" +
                           "indexLinRecNonExisting = " + indexLinRecNonExisting);



        SortingStudentsByGPA Sorter = new SortingStudentsByGPA();

        Sorter.sort(studentsList, 0, studentsList.size() - 1);

        System.out.println("==== SORTED LIST ====");

        for (ComparableStudent student: studentsList) {
            System.out.println(student);
        }

        existingStudent = new Student(60);
        nonExistingStudent = new Student(77);

        int indexBinItExisting = sis.binarySearchIterative(studentsList, existingStudent);
        int indexBinItNonExisting = sis.binarySearchIterative(studentsList, nonExistingStudent);
        int indexBinRecExisting = sis.binarySearchRecursive(studentsList, existingStudent);
        int indexBinRecNonExisting = sis.binarySearchRecursive(studentsList, nonExistingStudent);

        System.out.println("==== BINARY SEARCH INDEXES ====");
        System.out.println("indexBinItExisting = " + indexBinItExisting + "\n" +
                "indexBinItNonExisting = " + indexBinItNonExisting + "\n" +
                "indexBinRecExisting = " + indexBinRecExisting +"\n" +
                "indexBinRecNonExisting = " + indexBinRecNonExisting);

        existingStudent = new Student(40);
        nonExistingStudent = new Student(99);

        indexBinRecExisting = sis.binarySearchRecursive(studentsList, existingStudent);
        indexBinRecNonExisting = sis.binarySearchRecursive(studentsList, nonExistingStudent);

        System.out.println("indexBinRecExisting = " + indexBinRecExisting +"\n" +
                           "indexBinRecNonExisting = " + indexBinRecNonExisting);

    }

}
