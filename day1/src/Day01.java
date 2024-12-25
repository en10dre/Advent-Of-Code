import java.io.*;
import java.util.*;

public class Day01 {
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne() {
        String filePath = "../puzzle.input";

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length == 2) {
                    left.add(Integer.parseInt(parts[0]));
                    right.add(Integer.parseInt(parts[1]));
                }
            }
            left.sort(Integer::compare);
            right.sort(Integer::compare);

            int totalDistance = 0;
            for (int i = 0; i < left.size(); i++) {
                if(right.get(i) > left.get(i)) {
                    totalDistance += right.get(i) - left.get(i);
                } else if (left.get(i) > right.get(i)) {
                    totalDistance += left.get(i) - right.get(i);
                }
            }

            System.out.println("--- Part One ---");
            System.out.println("Answer: " + totalDistance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void partTwo() {
        String filePath = "../puzzle.input";

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length == 2) {
                    left.add(Integer.parseInt(parts[0]));
                    right.add(Integer.parseInt(parts[1]));
                }

                // Create a frequency map for the right list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : right) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int total = 0;

        // Count occurrences of left list numbers in the right list
        for (int num : left) {
            int count = frequencyMap.getOrDefault(num, 0);
            int product = num * count;

            total += product;
        }
        System.out.println();
        System.out.println("--- Part Two ---");
        System.out.println("Answer: " + total);
    }
}
