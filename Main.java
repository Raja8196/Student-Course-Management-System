import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. Add Course");
                System.out.println("3. Enroll Student");
                System.out.println("4. View Students");
                System.out.println("5. View Courses");
                System.out.println("6. View Grades");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("ID: ");
                        int sid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String sname = sc.nextLine();
                        System.out.print("Email: ");
                        String semail = sc.nextLine();
                        Student.addStudent(sid, sname, semail);
                        break;
                    case 2:
                        System.out.print("ID: ");
                        int cid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Course Name: ");
                        String cname = sc.nextLine();
                        System.out.print("Credits: ");
                        int credits = sc.nextInt();
                        Course.addCourse(cid, cname, credits);
                        break;
                    case 3:
                        System.out.print("Student ID: ");
                        int esid = sc.nextInt();
                        System.out.print("Course ID: ");
                        int ecid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Grade: ");
                        String grade = sc.nextLine();
                        Enrollment.enrollStudent(esid, ecid, grade);
                        break;
                    case 4:
                        Student.showStudents();
                        break;
                    case 5:
                        Course.showCourses();
                        break;
                    case 6:
                        Enrollment.showGrades();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
