import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MachineProblem4 {

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        Student[] students;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students (max is 50): ");
        int numberOfStudents = sc.nextInt();
        sc.nextLine();

        if( numberOfStudents > 50 ) {
            System.err.println("Invalid input. Max number of students is 50.");
            return;
        }

        students = new Student[numberOfStudents];

        System.out.println("Do you want to specify the name of each student? (y/n)");
        boolean isSpecifyName;
        String isSpecify = sc.nextLine();

        if("y".equalsIgnoreCase(isSpecify)) {
            isSpecifyName = true;
        }else if("n".equalsIgnoreCase(isSpecify)) {
            isSpecifyName = false;
        }else {
            System.err.println("Invalid input. Only enter y or n.");
            return;
        }

        for( int i = 0; i < students.length; i++ ) {
            Student s = new Student();
            String nameOfStudent;
            if( isSpecifyName ) {
                System.out.print("Enter name of student: ");
                if( i > 0 ) {
                    sc.nextLine();
                }

                nameOfStudent = sc.nextLine();
            }else {
                nameOfStudent = "Student"+(i+1);
            }

            s.setName( nameOfStudent );
            System.out.print("Enter score for " + nameOfStudent + ": " );
            s.setScore( sc.nextDouble() );

            students[i] = s;
        }

        Student[] studentHighestScorers = getHighestScorers( students );
        double averageScore = getAverageScore(students);


        System.out.println("\nThe Class Size is " + students.length + "\nThe highest score is " + studentHighestScorers[0].getScore()
        +"\nThe student"+ (studentHighestScorers.length > 1 ? "s" : "") + " who got the highest score " + (studentHighestScorers.length > 1 ? "are" : "is") );
        printArray(studentHighestScorers);

        System.out.println("Average Score is "+ decimalFormat.format(averageScore) +"\nStudent/s who got below average is/are");
        for( Student student : students ) {
            if( student.getScore() < averageScore ) {
                System.out.println("\t"+student);
            }
        }

    }

    public static void printArray(Student[] students) {
        for(Student student : students) {
            System.out.println("\t"+student);
        }
    }

    public static double getAverageScore(Student[] students) {
        double totalScore = 0;
        for(Student student : students) {
            totalScore += student.getScore();
        }

        return totalScore / students.length;
    }

    public static Student[] getHighestScorers(Student[] students) {
        double max = Double.MIN_VALUE;
        int maxCount = 0;

        for (Student student : students) {
            if (student.getScore() > max) {
                max = student.getScore();
                maxCount = 1;
            } else if (student.getScore() == max) {
                maxCount++;
            }
        }

        Arrays.sort(students, Comparator.comparingDouble(Student::getScore).reversed());
        System.out.println("Max count: " + maxCount + ", max: " + max);

        return Arrays.copyOfRange( students, 0, maxCount );
    }
}
