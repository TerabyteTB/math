package math;

public class Functions {
    public static int gaussAddition(int n) {
        n = n * (n + 1) / 2;

        return n;
    }

    public static String dateToDay(int year, int month, int day){
        double f = (14.00 - month) / 12;
        double y = year - f;
        double m = month + 12 * f - 2;

        int d = (int) ((day + y + (31 * m / 12) + (y / 4) - (y / 100) + (y / 400)) % 7);
        return switch (d) {
            case 0 -> "Monday";
            case 1 -> "Tuesday";
            case 2 -> "Wednesday";
            case 3 -> "Thursday";
            case 4 -> "Friday";
            case 5 -> "Saturday";
            case 6 -> "Sunday";
            default -> throw new IllegalStateException("Unexpected value: " + d);
        };
    }
}
