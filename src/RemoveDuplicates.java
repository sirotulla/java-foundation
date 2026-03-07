import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] numbers = {10, 0, 2, 9, 2, 3, 4, 5, 7, 5, 10};
        System.out.println("Original numbers: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));
        int[] uniqueNumbers = reverseDuplicates(numbers);
        System.out.println("Unique numbers: " + Arrays.toString(uniqueNumbers));
    }



    public static int[] reverseDuplicates(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return numbers;
        }

        int temp[] = new int[numbers.length];
        int t = 0;

        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] != numbers[i+1]) {
                temp[t++] = numbers[i];
            }
        }
        temp[t++] = numbers[numbers.length-1];

        int result[] = new int[t];
        for (int i = 0; i < t; i++) {
            result[i] = temp[i];
        }

        return result;
    }

}
