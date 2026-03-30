import java.util.*;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Display Students with Marks Above X");
            System.out.println("5. Calculate Average Marks");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7. Update Student");
            System.out.println("8. Delete Student");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    filterByMarks();
                    break;
                case 5:
                    calculateAverage();
                    break;
                case 6:
                    sortStudents();
                    break;
                case 7:
                    updateStudent();
                    break;
                case 8:
                    deleteStudent();
                    break;
                case 9:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 9);
    }

    static void addStudent() {
        Student s = new Student();
        s.inputDetails(sc);
        students.add(s);
        System.out.println("Student added successfully!");
    }

    static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Student s : students) {
            s.displayDetails();
        }
    }

    static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getStudentId() == id) {
                s.displayDetails();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void filterByMarks() {
        System.out.print("Enter minimum marks: ");
        double minMarks = sc.nextDouble();

        boolean found = false;
        for (Student s : students) {
            if (s.getMarks() > minMarks) {
                s.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found above given marks.");
        }
    }

    static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        double total = 0;
        for (Student s : students) {
            total += s.getMarks();
        }

        double avg = total / students.size();
        System.out.println("Average Marks: " + avg);
    }

    static void sortStudents() {
        if (students.isEmpty()) {
            System.out.println("No data to sort.");
            return;
        }

        students.sort((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));

        System.out.println("Students sorted by marks (High to Low):");
        displayAll();
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getStudentId() == id) {
                s.updateDetails(sc);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getStudentId() == id) {
                it.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
