import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class Calendar {

    private int year;

    private int day;

    private int month;

    public Calendar(LocalDate date) {
        this.year = date.getYear();
        this.month = date.getMonth().getValue();
        this.day = date.getDayOfMonth();
    }

    public Calendar(int day, int month, int year) {
        this.year = year;
        this.day = day;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return Month.of(month) + " " + day + ", " + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return year == calendar.year &&
                day == calendar.day &&
                month == calendar.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, day, month);
    }
}
