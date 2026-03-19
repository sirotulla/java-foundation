import java.util.HashSet;
import java.util.Scanner;

public class ContainsNearbyDuplicate {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int lengthOfArray = getInt("Enter the length of the array: ");

        int[] numbers = new int[lengthOfArray];

        for (int i = 0; i < lengthOfArray; i++) {
            int num = getInt("Enter the " + (i+1) +  " element of the array: ");
            numbers[i] = num;
        }

        int k = getInt("Enter the value of k: ");

        boolean isCheck = isDuplicate(numbers,k);
        System.out.println("With loop: " + isCheck);

        boolean result = containsNearbyDuplicate(numbers, k);
        System.out.println("Hashset: " + result);

    }


    // With Hashset
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 1. Check if the current value is already in our 'k' sized window
            if (uniqueNums.contains(nums[i])) {
                return true;
            }

            // 2. Add current value to window
            uniqueNums.add(nums[i]);

            // 3. Keep the window size exactly 'k' by removing the oldest element
            if (uniqueNums.size() > k) {
                uniqueNums.remove(nums[i-k]);
            }
        }

        return false;
    }


    // With nested loop
    public static boolean isDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (j - i) <= k) {
                    return true;
                }
            }
        }

        return false;
    }


    public static int getInt(String prompt){
        System.out.println(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer");
            }
        }
    }


}
