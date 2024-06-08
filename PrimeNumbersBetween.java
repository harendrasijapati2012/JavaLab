import java.util.Scanner;

public class PrimeNumbersBetween {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read inputs
        System.out.print("Enter the starting number (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter the ending number (m): ");
        int m = scanner.nextInt();

        // Print all prime numbers between n and m
        System.out.println("Prime numbers between " + n + " and " + m + ":");
        for (int i = n; i <= m; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
