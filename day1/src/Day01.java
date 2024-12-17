import java.io.*;
import java.util.*;

public class Day01 {
    public static void main(String[] args) {
        // File path (update to your actual file path)
        String filePath = "../puzzle.input";

        int grandTotal = 0; // To store the cumulative sum of total sums

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split the line into two parts (left and right numbers)
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 2) {
                    // Sort digits of each number and store as character arrays
                    char[] leftDigits = sortDigits(parts[0]);
                    char[] rightDigits = sortDigits(parts[1]);

                    // Ensure both arrays are of the same length
                    if (leftDigits.length == rightDigits.length) {
                        int totalSum = 0;
                        // Perform subtraction for corresponding digits (from smallest to largest)
                        for (int i = 0; i < leftDigits.length; i++) {
                            int leftValue = Character.getNumericValue(leftDigits[i]);
                            int rightValue = Character.getNumericValue(rightDigits[i]);

                            if(leftValue < rightValue) {
                                totalSum += (rightValue - leftValue);
                            } else if (rightValue < leftValue){
                                totalSum += (leftValue - rightValue); // Subtract left - right
                            }
                        }

                        // Add the totalSum for the current line to the grand total
                        grandTotal += totalSum;

                        // Output result for the current line
                        System.out.println(Arrays.toString(leftDigits) + Arrays.toString(rightDigits) + " = " + totalSum);
                        System.out.println();
                    } else {
                        System.out.println("Error: Numbers have different lengths, skipping line.");
                    }
                }
            }

            // Output the grand total of all lines
            System.out.println("Grand Total of All Subtractions: " + grandTotal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to sort digits of a number and return them as a char array
    private static char[] sortDigits(String number) {
        char[] digits = number.toCharArray();
        Arrays.sort(digits); // Sort the digits in ascending order
        return digits;
    }
}

