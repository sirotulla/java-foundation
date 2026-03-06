import java.util.Arrays;
import java.util.Scanner;

public class DiagonalSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the column and rows for matrix: ");
        int column = scanner.nextInt();
        scanner.nextLine();

        // filling matrix with user input
        int[][] matrix = new int[column][column];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter the number at index: " + i + " " + j + " -- ");
                int index = scanner.nextInt();
                matrix[i][j] = index;
            }
        }

        System.out.println("------------------------------------------------------");
        //System.out.println("Matrix: " + Arrays.deepToString(matrix));
        // printing matrix
        for (int[] rows : matrix) {
            for (int num : rows) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("------------------------------------------------------");
        // min and max numbers in matrix
        int min = matrix[0][0], max = matrix[0][0];
        for (int[] rows : matrix) {
            for (int num : rows) {
                if (min > num) min = num;
                if (max < num) max = num;
            }
        }
        System.out.println("The smallest number in matrix: " + min);
        System.out.println("The greatest number in matrix: " + max);

        // sum of matrix
        int sum = 0;
        for (int[] rows : matrix) {
            for (int num : rows) sum += num;
        }
        System.out.println("The sum of matrix: " + sum);


        System.out.println("------------------------------------------------------");
        // sum of primary and secondary diagonals
        int primarySum = 0, secondarySum = 0;

        // primary
        for (int i = 0; i < matrix.length; i++) {
            primarySum += matrix[i][i];
        }

        // secondary
        for (int i = 0; i < matrix.length; i++) {
            // Avoid counting the middle element twice in case of an odd-sized matrix
            if (i != matrix.length-1-i) {
                secondarySum += matrix[i][matrix.length-1-i];
            }
        }

        // sum of diagonals
        int diagonalsSum = primarySum + secondarySum;
        System.out.println("Sum of primary and secondary diagonals is: " + diagonalsSum);
        scanner.close();

    }
}
