import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);
        
        // Ask the user for input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Calculate the facto4rial
        long factorial = calculateFactorial(number);
        
        // Print the result
        System.out.println("The factorial of " + number + " is: " + factorial);
        
        // Close the scanner
        scanner.close();
    }
    
    // Method to calculate factorial
    public static long calculateFactorial(int n) {
        // Factorial of 0 and 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }
        
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        
        return factorial;
    }
}

