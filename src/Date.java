

public class Date implements Comparable<Date> {
    private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    //the property that the value of a data object never changes once it constructed.
    private final int month;
    private final int day;
    private final int year;

    public Date(int month, int day, int year) {
        if (!isValid(month, day, year)) {
            throw new IllegalArgumentException("Invalid data");
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date(String date) {
        String[] fields = date.split("/");
        if (fields.length != 3) throw new IllegalArgumentException("Invalid date");
        month = Integer.parseInt(fields[0]);
        day = Integer.parseInt(fields[1]);
        year = Integer.parseInt(fields[2]);
        if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    private boolean isValid(int m, int d, int y) {
        if (m < 1 || m > 12)  return false;
        if (d < 1 || d > DAYS[m]) return false;
        if (m == 2 && d == 29 && !isLeapYear(y))  return false;
        if (y < 0) return false;
        return true;
    }

    private boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }

    public Date next() {
        if (isValid(month, day + 1, year)) {
            return new Date(month, day + 1, year);
        }
        else if (isValid(month + 1, 1, year)) {
            return new Date(month + 1, 1, year);
        }
        else {
            return new Date(1, 1, year + 1);
        }
    }

    @Override
    public int compareTo(Date o) {
        if (this.year < o.year) return -1;
        if (this.year > o.year) return +1;
        if (this.month < o.month) return -1;
        if (this.month > o.month) return +1;
        if (this.day < o.day) return -1;
        if (this.day > o.day) return +1;
        return 0;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Date)) return false;
        Date that = (Date) o;
        return this.month == that.month &&
                this.day == that.day &&
                this.year == that.year;
    }

    @Override
    public int hashCode() {
        return day + 31*month + 31*12*year;
    }

    public static void main(String[] args) {
        Date today = new Date(10, 29, 2020);
        System.out.println(today);
        for (int i = 0; i < 10; i++) {
            today = today.next();
            System.out.println(today);
        }
        System.out.println(today.isAfter(today.next()));
        System.out.println(today.isAfter(today));
        System.out.println(today.next().isAfter(today));

        Date birthday = new Date(10, 16, 1971);
        System.out.println(birthday);
        for (int i = 0; i < 10; i++) {
            birthday = birthday.next();
            System.out.println(birthday);
        }

    }

    private boolean isAfter(Date next) {
        return compareTo(next) < 0;
    }
    //p: 128  12 8  4
    //q: 12   8  4  0
    public static int gcd(int p, int q) {
        System.out.println(p + ", " + q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

}

