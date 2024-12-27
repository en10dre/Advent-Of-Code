import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day02 {
    public static void main(String[] args) {
        String filePath = "../puzzle.input";
        int safeLevelCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] inputArray = line.split(" ");

                List<Integer> arrayList = new ArrayList<>();
                for(String str : inputArray) {
                    arrayList.add(Integer.parseInt(str));
                }
                if(isSafe(arrayList)) {
                    safeLevelCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(safeLevelCount);
    }

    // Method to parse a line of numbers
    public static List<Integer> parseLine(String line) {
        List<Integer> numbers = new ArrayList<>();
        String[] parts = line.trim().split("\\s+");
        for (String part : parts) {
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }

    public static boolean isSafe(List<Integer> list) {
        // Check if the list has fewer than 2 elements
        if (list.size() < 2) {
            return true;
        }

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);

            if(Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false;
            }

            if(diff > 0) {
                decreasing = false;
            } else if(diff < 0) {
                increasing = false;
            }
        }

        return increasing || decreasing;
    }
}
