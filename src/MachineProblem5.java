import java.time.LocalDate;
import java.util.Scanner;

public class MachineProblem5 {

    public static void main(String[] args) {
        Calendar currentCalendar = new Calendar(LocalDate.now());

        System.out.println("Initial value: " + currentCalendar);

        Calendar newCalendar = getNewCalendar();

        while ( currentCalendar.equals(newCalendar) ) {
            System.out.println("Dates are equal. Please enter another one");
            newCalendar = getNewCalendar();
        }

        currentCalendar = newCalendar;

        System.out.println("Current value: " + currentCalendar);
    }

    public static Calendar getNewCalendar() {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if( year < 0 ) {
            System.err.println("Year should be positive.");
            System.exit(1);
        }

        System.out.print("Enter month (1-12 only): ");
        int month = sc.nextInt();

        if( month < 1 || month > 12 ) {
            System.err.println("Month should only be between 1 and 12.");
            System.exit(1);
        }

        System.out.print("Enter day (1-31 only): ");
        int day = sc.nextInt();

        if( day < 1 || day > 31 ) {
            System.err.println("Day should only be between 1 and 31.");
            System.exit(1);
        }

        return new Calendar( day, month, year );
    }
}
