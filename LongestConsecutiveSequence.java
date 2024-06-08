import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array length
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Input the array elements
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Find the length of the longest consecutive elements sequence
        int longestLength = findLongestConsecutiveSequence(array);

        // Print the result
        System.out.println("The length of the longest consecutive elements sequence is: " + longestLength);

        // Close the scanner
        scanner.close();
    }

    public static int findLongestConsecutiveSequence(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }

        int longestLength = 0;

        for (int num : array) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestLength = Math.max(longestLength, currentStreak);
            }
        }

        return longestLength;
    }
}
