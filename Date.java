import java.util.ArrayList;
import java.util.Arrays;

/**
 * Date
 */
public class Date {

    private static Integer[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private static ArrayList<Integer> daysInMonth = new ArrayList<>(Arrays.asList(days));

    private int day;
    private int month;
    private int year;
    private String date;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.date = year + "-" + month + "-" + day;
    }

    public Date(String copyDate) {

        int day = -1;
        int month = -1;
        int year = -1;
        
        day = Integer.parseInt(copyDate.substring(copyDate.lastIndexOf("-")));
        month = Integer.parseInt(copyDate.substring(copyDate.indexOf("-"), copyDate.lastIndexOf("-")));
        year = Integer.parseInt(copyDate.substring(0,copyDate.indexOf("-")));

        this.day = day;
        this.month = month;
        this.year = year;

        date = copyDate;
    }

    public Date(Date copyDate) {
        this.day = copyDate.day;
        this.month = copyDate.month;
        this.year = copyDate.year;
        this.date = copyDate.date;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Integer> getArrayList(int year1) {

        if (isLeapYear()) {
            daysInMonth.set(2, 29);
        }
        return daysInMonth;
    }

    public void initDaysInMonth(ArrayList<Integer> a) {

        daysInMonth = a;
    }

    public void setYear(int yearO) {
        year = yearO;
    }

    public void setMonth(int month1) {

        if (month1 >= 1 && month1 <= 12)

            month = month1;
    }

    public void setDays(int year2) {
        if (isLeapYear()) {
            daysInMonth.set(1, 29);
        }

        day = daysInMonth.get(month);
    }

    public void setDate(String date1) {
        date = date1;
    }

    public boolean isLeapYear() {

        if ((this.year / 100) % 2 == 0 && (this.year / 400) % 2 == 0) {
            return true;
        }

        return false;
    }

    public String toString(Date random) {

        return random.getDate();
    }

    public int countLeapYears(Date r) {
        int year = r.year;
        int toReturn = 0;

        if (r.month <= 2) {
            year--;
        }

        toReturn = year / 4 - year / 100 - year / 400;

        return toReturn;
    }

    public int daysBetween(Date rand) {

        int first = rand.year * 365 + rand.day;
        int second = this.year * 365 + this.day;

        for (int i = 0; i < rand.month - 1; i++) {
            first += daysInMonth.get(i);
        }

        first += countLeapYears(rand);

        for (int i = 0; i < this.month - 1; i++) {
            second += daysInMonth.get(i);
        }
        second += countLeapYears(this);

        return (Math.abs(second - first));
    }

    public Date addDays(int randDay) {

        int year = this.year;
        int month = this.month;
        int day = this.day;

        int maxDays = this.getArrayList(year).get(month-1);

        day += randDay;

        if (day > maxDays) {
            day -= maxDays;
            month++;

            if (month > 12) {
                year++;
                month = 1;
            }
        }

        this.day = day;
        this.month = month;
        this.year = year;

        Date random = new Date(this.year, this.month, this.day);

        return random;
    }

    public boolean isBefore(Date a) {

        if (a.date.compareTo(this.date) > 0) {
            return true;
        } else {
            return false;
        }

    }

    public String toString() {
        return date;
    }

}
