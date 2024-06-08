import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
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

        // Remove duplicates and get the updated array length
        int updatedLength = removeDuplicates(array);

        // Print the updated array and its length
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < updatedLength; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nUpdated array length: " + updatedLength);

        // Close the scanner
        scanner.close();
    }

    public static int removeDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        int index = 0;

        // Traverse the array and add elements to the HashSet
        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
                array[index++] = array[i];
            }
        }

        // Return the new length of the array
        return index;
    }
}
