import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================================");
        System.out.println("                      CAMPUSTRACK                      ");
        System.out.println("=======================================================");
        System.out.println("           Simple Student Result Management System     ");
        System.out.println("-------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Enter Student Id : ");
            String studentId = sc.next();
            sc.nextLine();
            System.out.print("Enter student Name : ");
            String studentName = sc.nextLine();
            System.out.print("Enter Age : ");
            int age = sc.nextInt();
            while (age < 15 || age > 35) {
                System.out.println("Invalid age . Age should be 15 to 35");
                System.out.print("Enter Age : ");
                age = sc.nextInt();
            }
            System.out.print("Enter Mail Id :");
            String mail = sc.next();
            System.out.println("Select Course\n 1.BCA\n 2.B.Sc Computer Science \n 3.B.E/B.Tech\n 4.MCA \n 5.other");
            System.out.println("Enter your course");
            int course = sc.nextInt();
            while (course < 1 || course > 5) {
                System.out.println("Invalid course");
                System.out.print("Choose only between 1-5 courses : ");
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
                case 4:
                    courseName = "MCA";
                    fee = 45000.0f;
                    break;
                case 5:
                    courseName = "other";
                    fee = 25000.0f;
                    break;
            }
            System.out.print("Enter semester (1-8) : ");
            int sem = sc.nextInt();
            while (sem < 1 || sem > 8) {
                System.out.println("Invalid semester");
                System.out.print("Enter semester (1-8) : ");
                sem = sc.nextInt();
            }
            System.out.print("Enter  career goal: ");
            sc.nextLine();
            String goal = sc.nextLine();

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
            System.out.print("Enter Web Technology Marks : ");
            int webTechnologyMarks = sc.nextInt();
            while (webTechnologyMarks < 0 || webTechnologyMarks > 100) {
                System.out.println("Invalid Marks");
                System.out.print("Enter Web Technology Marks : ");
                webTechnologyMarks = sc.nextInt();
            }
            System.out.print("Enter Aptitude Marks : ");
            int aptitudeMarks = sc.nextInt();
            while (aptitudeMarks < 0 || aptitudeMarks > 100) {
                System.out.println("Invalid Marks");
                System.out.print("Enter Aptitude Marks : ");
                aptitudeMarks = sc.nextInt();
            }
            System.out.print("Enter communication marks : ");
            int communicationMarks = sc.nextInt();
            while (communicationMarks < 0 || communicationMarks > 100) {
                System.out.println("Invalid communication marks");
                System.out.print("Enter communication marks : ");
                communicationMarks = sc.nextInt();
            }
            int total = javaMarks + sqlMarks + webTechnologyMarks + aptitudeMarks + communicationMarks;
            // Total Average
            double avg = total / 5.0;
            String acadimic = "";
            if (javaMarks >= 35 && sqlMarks >= 35 && webTechnologyMarks >= 35 && aptitudeMarks >= 35
                    && communicationMarks >= 35 && avg >= 40) {
                acadimic = "PASSED";
            } else {
                acadimic = "FAILED";
            }
            String grade = "";
            if (acadimic.equals("PASSED")) {
                if (avg >= 85) {
                    grade = "A+";
                } else if (avg >= 75 && avg < 85) {
                    grade = "A";
                } else if (avg >= 65 && avg < 75) {
                    grade = "B";
                } else if (avg >= 50 && avg < 65) {
                    grade = "C";
                } else if (avg < 50 && avg >= 40) {
                    grade = "D";
                }
            } else {
                grade = "F";
            }
            System.out.print("Enter total classes :");
            int TotalClass = sc.nextInt();
            while (TotalClass < 0 || TotalClass > 300) {
                System.out.println("Invalid number ");
                System.out.print("enter number between 1-300");
            }
            System.out.print("Enter present classes : ");
            int presentClass = sc.nextInt();
            while (presentClass < 0 || presentClass > TotalClass) {
                System.out.println("Invalid number");
                System.out.print("Enter present classes between 0 and");
            }
            double attendancePercentage = ((double) presentClass / TotalClass) * 100;
            String attendanceStatus = attendancePercentage >= 75 ? "REGULAR" : "SHORTAGE";
            System.out.print("Enter number of Assessments 1 - 10");
            int assignmentNum = sc.nextInt();
            while (assignmentNum < 0 || assignmentNum > 10) {
                System.out.println("Invalid number");
                System.out.print("Enter number between 1 - 10");
                assignmentNum = sc.nextInt();
            }
            int assessCount = 0;
            int assessScore = 0;
            for (int i = 1; i <= assignmentNum; i++) {
                System.out.print("Assignment number " + i + "  :");
                int AssignmentMark = sc.nextInt();
                if (AssignmentMark == -1) {
                    break;
                }
                if (AssignmentMark < -1 || AssignmentMark > 10) {
                    System.out.println("This entry is skipped");
                    continue;
                }
                assessCount++;
                assessScore += AssignmentMark;
            }
            if (assessCount > 0) {
                double assignmentAvg = ((double) assessScore / assignmentNum);
            } else {
                double assignmentAvg = 0.0;
            }
            String assResult = (assessCount >= 1 && assignmentNum >= 5) ? "SATISFACTORY" : "NEED IMPROVEMENT";
            // Scholorship calculation
            int scholarship = 0;
            if (acadimic.equals("PASSED") && attendancePercentage >= 85 && avg >= 85) {
                scholarship = 10;
            } else if (acadimic.equals("PASSED") && attendancePercentage >= 75 && avg >= 75) {
                scholarship = 5;
            }
            // applying scholarship on fee
            float Scfee = fee;
            float Scamount = 0;
            if (scholarship > 0) {
                Scamount = fee * (float) (scholarship / 100.0f);
            }
            if (scholarship > 0) {
                Scfee = fee - Scamount;
            }
            System.out.print("Enter Fee paid amount : ");
            int feePaid = sc.nextInt();
            while (feePaid < 0 || feePaid > Scfee) {
                System.out.println("Invalid amount");
                System.out.print("Enter Fee paid amount");
                feePaid = sc.nextInt();
            }
            double feeBalance = Scfee - feePaid;
            String feeStatus = feeBalance == 0 ? "CLEARED" : "PENDING";
            String acadimicStatus = (acadimic.equals("PASSED") && attendancePercentage >= 75 && feeBalance == 0
                    && assResult.equals("SATISFACTORY"))
                            ? "CLEARED FOR NEXT SEMESTER"
                            : "ACTION REQUIRED";

            System.out.println("-----------------------------------------------");
            System.out.println("Student Id             : " + studentId);
            System.out.println("Student Name           : " + studentName);
            System.out.println("Age                    : " + age);
            System.out.println("Email                  : " + mail);
            System.out.println("Course                 : " + courseName);
            System.out.println("Career Goal            : " + goal);
            System.out.println("---------------ACADEMIC DETAILS------------------");
            System.out.println("Java Marks             : " + javaMarks);
            System.out.println("SQL Marks              : " + sqlMarks);
            System.out.println("Web Technology Marks   : " + webTechnologyMarks);
            System.out.println("Aptitude Marks         : " + aptitudeMarks);
            System.out.println("Communication Marks    : " + communicationMarks);
            System.out.println("Total                  : " + total + " / " + "500");
            System.out.println("Percentage             : " + avg);
            System.out.println("Academic Result        : " + acadimic);
            System.out.println("Grade                  : " + grade);
            System.out.println("----------------ATTENDANCE DETAILS----------------");
            System.out.println("Classes Conducted      : " + TotalClass);
            System.out.println("Classes Attended       : " + presentClass);
            System.out.println("Attendance Precentage  : " + (double) attendancePercentage + " %");
            System.out.println("Attendance Status      : " + attendanceStatus);
            System.out.println("--------------------FEE SUMMARY-------------------");
            System.out.println("Base Semester Fee      : " + fee);
            System.out.println("Scholarship percentage : " + scholarship + " %");
            System.out.println("Scholarship Amount     : " + Scamount);
            System.out.println("Final payable Fee      : " + Scfee);
            System.out.println("Amount Paid            : " + feePaid);
            System.out.println("Fee Balance            : " + feeBalance);
            System.out.println("Fee Status             : " + feeStatus);
            System.out.println("--------------------FINAL STATUS-------------------");
            System.out.println("Semester Status        : " + acadimicStatus);
            System.out.println("--------------------FAIL CONDITION-----------------");
            if (acadimicStatus.equals("ACTION REQUIRED")) {
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
                if (webTechnologyMarks < 35) {
                    System.out.println("- Web Technology marks are below 35.");
                }
                if (communicationMarks < 35) {
                    System.out.println("- Communication marks are below 35.");
                }
                if (avg < 40) {
                    System.out.println("- Overall percentage is less than 40 %");
                }
                if (attendancePercentage < 75) {
                    System.out.println("- Attendance is below 75%.");
                }
                if (feeBalance > 0) {
                    System.out.println("- Semester fee is pending.");
                }
                if (assessCount > 0 && ((double) assessScore / assignmentNum) < 5.0) {
                    System.out.println("- Assignment average is below 5.00.");
                }
                if (assessCount == 0) {
                    System.out.println("- No valid assignment score was entered.");
                }
                System.out.println("--------------------RECOMMENDATIONS----------------");

                if (javaMarks < 35 || sqlMarks < 35 || webTechnologyMarks < 35 || aptitudeMarks < 35
                        || communicationMarks < 35) {
                    System.out.println("- Revisit the failed subject and complete additional practice.");
                }
                if (avg < 40) {
                    System.out.println("- Improve overall academic performance.");
                }
                if (attendancePercentage < 75) {
                    System.out.println("- Attend classes regularly and clear the attendance shortage.");
                }
                if (assResult.equals("NEED IMPROVEMENT")) {
                    System.out.println("- Complete assignments consistently and maintain an average of at least 5.00.");
                }
                if (feeBalance > 0) {
                    System.out.println("- Pay the pending semester fee before clearance.");
                }

                if (acadimicStatus.equals("CLEARED FOR NEXT SEMESTER")) {
                    System.out.println("- Maintain the current performance in the next semester.");
                }
            }
            System.out.println("Do you want to process another student?");
            System.out.println("1. Yes");
            System.out.println("0. No");
            System.out.print("Enter choice: ");
            do {
                choice = sc.nextInt();
                if (choice != 1 && choice != 0) {
                    System.out.println("Invalid choice. Enter only 1 or 0.");
                    System.out.print("Enter choice: ");
                }
            } while (choice != 1 && choice != 0);
        } while (choice == 1);
        System.out.println("Thank you for using CampusTrack.");
        sc.close();
    }
}
