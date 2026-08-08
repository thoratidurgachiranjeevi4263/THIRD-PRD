import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================================");
        System.out.println("                      CAMPUSTRACK                      ");
        System.out.println("=======================================================");
        System.out.println("           Simple Student Result Management System     ");
        System.out.println("-------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Id : ");
        String studentId = sc.next();
        sc.nextLine();
        System.out.print("Enter student Name : ");
        String studentName = sc.nextLine();
        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        while (age < 16 || age > 30) {
            System.out.println("Invalid age . Age should be 16 to 30");
            System.out.print("Enter Age : ");
            age = sc.nextInt();
        }
        System.out.println("Select Course\n 1.BCA\n 2.B.Sc Computer Science \n 3.B.E/B.Tech");
        int course = sc.nextInt();
        while (course < 1 || course > 3) {
            System.out.println("Invalid course");
            System.out.print("Choose only between 1-3 courses : ");
            course = sc.nextInt();
        }
        String courseName = "";
        float fee = 0.0f;
        switch (course) {
            case 1:
                courseName = "BCA";
                fee = 30000.0f;
                break;
            case 2:
                courseName = "B.Sc Computer Science";
                fee = 35000.0f;
                break;
            case 3:
                courseName = "B.E/B.Tech";
                fee = 50000.0f;
                break;
        }
        System.out.print("Enter Java Marks :");
        int javaMarks = sc.nextInt();
        while (javaMarks < 0 || javaMarks > 100) {
            System.out.println("Invalid marks");
            System.out.print("Enter Java Marks : ");
            javaMarks = sc.nextInt();
        }
        System.out.print("Enter SQL Marks : ");
        int sqlMarks = sc.nextInt();
        while (sqlMarks < 0 || sqlMarks > 100) {
            System.out.println("Invalid Marks");
            System.out.print("Enter SQL Marks : ");
            sqlMarks = sc.nextInt();
        }
        System.out.print("Enter Aptitude Marks : ");
        int aptitudeMarks = sc.nextInt();
        while (aptitudeMarks < 0 || aptitudeMarks > 100) {
            System.out.println("Invalid Marks");
            System.out.print("Enter Aptitude Marks : ");
            aptitudeMarks = sc.nextInt();
        }
        int total = javaMarks + sqlMarks + aptitudeMarks;
        double avg = total / 3.0;
        String acadimic = "";
        if (javaMarks >= 35 && sqlMarks >= 35 && aptitudeMarks >= 35) {
            acadimic = "PASSED";
        } else {
            acadimic = "FAILED";
        }
        String grade = "";
        if (acadimic.equals("PASSED")) {
            if (avg >= 75) {
                grade = "A";
            } else if (avg >= 60 && avg < 75) {
                grade = "B";
            } else if (avg >= 50 && avg < 60) {
                grade = "C";
            } else if (avg < 50) {
                grade = "D";
            }
        } else {
            grade = "F";
        }
        System.out.print("Enter attendance percentage : ");
        double attendance = sc.nextDouble();
        while (attendance < 0 || attendance > 100) {
            System.out.println("Invalid attendance percentage");
            System.out.print("Enter valid attendance between 0-100");
            attendance = sc.nextDouble();
        }
        String attendanceStatus = attendance >= 75 ? "SUFFICIENT" : "SHORTAGE";
        System.out.print("Enter Fee paid amount : ");
        int feePaid = sc.nextInt();
        while (feePaid < 0 || feePaid > fee) {
            System.out.println("Invalid amount");
            System.out.print("Enter Fee paid amount");
            feePaid = sc.nextInt();
        }
        double feeBalance = fee - feePaid;
        String feeStatus = feeBalance == 0 ? "CLEARED" : "PENDING";
        String acadimicStatus = (acadimic.equals("PASSED") && attendance >= 75 && feeBalance == 0) ? "SEMESTER CLEARED"
                : "SEMESTER NOT CLEARED";
        System.out.println("-----------------------------------------------");
        System.out.println("Student Id         : " + studentId);
        System.out.println("Student Name       : " + studentName);
        System.out.println("Age                : " + age);
        System.out.println("Course             : " + courseName);
        System.out.println("---------------ACADEMIC DETAILS------------------");
        System.out.println("Java Marks         : " + javaMarks);
        System.out.println("SQL Marks          : " + sqlMarks);
        System.out.println("Aptitude Marks     : " + aptitudeMarks);
        System.out.println("Total              : " + total + " / " + "300");
        System.out.println("Average            : " + avg);
        System.out.println("Academic Result    : " + acadimic);
        System.out.println("Grade              : " + grade);
        System.out.println("----------------ATTENDANCE DETAILS----------------");
        System.out.println("Attendance         : " + (double) attendance + " %");
        System.out.println("Attendance Status  : " + attendanceStatus);
        System.out.println("--------------------FEE DETAILS-------------------");
        System.out.println("Semester Fee       : " + fee);
        System.out.println("FEE Paid           : " + feePaid);
        System.out.println("Fee Balance        : " + feeBalance);
        System.out.println("Fee Status         : " + feeStatus);
        System.out.println("--------------------FINAL STATUS------------------");
        System.out.println("Semester Status    : " + acadimicStatus);
        if (acadimicStatus.equals("SEMESTER NOT CLEARED")) {
            System.out.println("Reasons:");
            if (javaMarks < 35) {
                System.out.println("- Java marks are below 35.");
            }
            if (sqlMarks < 35) {
                System.out.println("- SQL marks are below 35.");
            }
            if (aptitudeMarks < 35) {
                System.out.println("- Aptitude marks are below 35.");
            }
            if (attendance < 75) {
                System.out.println("- Attendance is below 75%.");
            }
            if (feeBalance > 0) {
                System.out.println("- Semester fee is pending.");
            }
        }
        sc.close();

    }
}
