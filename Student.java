import java.util.Scanner;

class Student {
    private int studentId;
    private String name;
    private int age;
    private String course;
    private double marks;

    public void inputDetails(Scanner sc) {
        System.out.print("Enter Student ID: ");
        studentId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Age: ");
        age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();
    }

    public void displayDetails() {
        System.out.println("----------------------------------");
        System.out.println("ID     : " + studentId);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
        System.out.println("Marks  : " + marks);
    }

    public int getStudentId() {
        return studentId;
    }

    public double getMarks() {
        return marks;
    }

    public void updateDetails(Scanner sc) {
        System.out.println("Updating Student ID: " + studentId);

        System.out.print("Enter New Name: ");
        sc.nextLine();
        name = sc.nextLine();

        System.out.print("Enter New Age: ");
        age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Course: ");
        course = sc.nextLine();

        System.out.print("Enter New Marks: ");
        marks = sc.nextDouble();
    }
}
