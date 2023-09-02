package math;

public class Functions {
    public static int gaussAddition(int n) {
        n = n * (n + 1) / 2;

        return n;
    }

    public static String dateToDay(int year, int month, int day){
        int f = (int) Math.floor((14 - month) / 12);
        int y = year - f;
        int m = month + (12 * f) - 2;

        int d = (day + y + ((31 * m) / 12) + (y / 4) - (y / 100) + (y / 400)) % 7;
        return switch (d) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> throw new IllegalStateException("Unexpected value: " + d);
        };
    }
}
