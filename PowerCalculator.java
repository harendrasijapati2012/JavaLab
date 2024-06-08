public class PowerCalculator {
    public static void main(String[] args) {
        // Test cases
        System.out.println("2 to the power 3 (int, int): " + power(2, 3));
        System.out.println("2.5 to the power 3 (double, int): " + power(2.5, 3));
        System.out.println("2 to the power 3.5 (int, double): " + power(2, 3.5));
        System.out.println("2.5 to the power 3.5 (double, double): " + power(2.5, 3.5));
    }

    // Method for int, int
    public static int power(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }

    // Method for double, int
    public static double power(double x, int y) {
        double result = 1.0;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }

    // Method for int, double
    public static double power(int x, double y) {
        return Math.pow(x, y);
    }

    // Method for double, double
    public static double power(double x, double y) {
        return Math.pow(x, y);
    }
}

