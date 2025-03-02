import java.util.*;

public class AppleDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Read number of apples
        long[] weights = new long[n];
        long totalSum = 0;

        // Read apple weights and compute total sum
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            totalSum += weights[i];
        }
        scanner.close();

        long minDifference = Integer.MAX_VALUE;

        // Iterate over all subsets using bitmasking
        int subsetCount = 1 << n; // 2^n possible subsets
        for (int mask = 0; mask < subsetCount; mask++) {
            long subsetSum = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // Check if the i-th element is included
                    subsetSum += weights[i];
                }
            }

            long difference = Math.abs(totalSum - 2 * subsetSum);
            minDifference = Math.min(minDifference, difference);
        }

        // Print the minimum possible difference
        System.out.println(minDifference);
    }
}
