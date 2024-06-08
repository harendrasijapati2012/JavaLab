import java.util.Scanner;

public class NumberToWords {

    private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] thousands = {
            "", "Thousand", "Million", "Billion"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the numeric amount
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        // Convert number to words
        if (number == 0) {
            System.out.println("Zero");
        } else {
            String words = convert(number);
            System.out.println("In words: " + words);
        }

        // Close the scanner
        scanner.close();
    }

    private static String convert(long number) {
        if (number == 0) {
            return "";
        }

        String word = "";

        // Split number into groups of three digits
        int group = 0;
        while (number > 0) {
            int n = (int) (number % 1000);
            if (n != 0) {
                String s = convertLessThanThousand(n);
                word = s + " " + thousands[group] + " " + word;
            }
            number /= 1000;
            group++;
        }

        return word.trim();
    }

    private static String convertLessThanThousand(int number) {
        String word;

        if (number % 100 < 20) {
            word = units[number % 100];
            number /= 100;
        } else {
            word = units[number % 10];
            number /= 10;

            word = tens[number % 10] + " " + word;
            number /= 10;
        }

        if (number == 0) {
            return word;
        }

        return units[number] + " Hundred " + word;
    }
}

