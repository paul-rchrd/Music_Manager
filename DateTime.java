import java.util.Calendar;

public class DateTime {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int second;

    public DateTime() {
        Calendar c = Calendar.getInstance();
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.month = c.get(Calendar.MONTH);
        this.year = c.get(Calendar.YEAR);
        this.hour = c.get(Calendar.HOUR_OF_DAY);
        this.minute = c.get(Calendar.MINUTE);
        this.second = c.get(Calendar.SECOND);
    }

    public boolean equals(DateTime other) {
        return this.day == other.day && this.month == other.month && this.year == other.year &&
            this.hour == other.hour && this.minute == other.minute && this.second == other.second;
    }
    public boolean isBefore(DateTime other) {
        if (this.year < other.year) {
            return true;
        }
        if (this.year == other.year && this.month < other.month) {
            return true;
        }
        if (this.year == other.year && this.month == other.month && this.day < other.day) {
            return true;
        }
        if (this.year == other.year && this.month == other.month && this.day == other.day &&
            this.hour < other.hour) {
            return true;
        }
        if (this.year == other.year && this.month == other.month && this.day == other.day &&
            this.hour == other.hour && this.minute < other.minute) {
            return true;
        }
        if (this.year == other.year && this.month == other.month && this.day == other.day &&
            this.hour == other.hour && this.minute == other.minute && this.second < other.second) {
            return true;
        }
        return false;
    }

    public boolean isAfter(DateTime other) {
        if (this.year > other.year) {
            return true;
        }
        if (this.year == other.year && this.month > other.month) {
            return true;
        }
        if (this.year == other.year && this.month == other.month && this.day > other.day) {
            return true;
        }
        if (this.year == other.year && this.month == other.month && this.day == other.day &&
            this.hour > other.hour) {
            return true;
        }
        if (this.year == other.year && this.month == other.month && this.day == other.day &&
            this.hour == other.hour && this.minute > other.minute) {
            return true;
        }
        if (this.year == other.year && this.month == other.month && this.day == other.day &&
            this.hour == other.hour && this.minute == other.minute && this.second > other.second) {
            return true;
        }
        return false;
    }

    public DateTime plusMinutes(long minutes) {
        DateTime copy = new DateTime();
        copy.day = this.day;
        copy.month = this.month;
        copy.year = this.year;
        copy.hour = this.hour;
        copy.minute = this.minute + (int)minutes;
        copy.second = this.second;

        return copy;
    }

    public String toString() {
        return String.format("%02d.%02d.%04d %02d:%02d:%02d", day, month, year, hour, minute, second);
    }
}