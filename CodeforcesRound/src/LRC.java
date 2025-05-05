import java.util.*;

public class LRC {

    private static final int MOD = 1000000007;

    // Function to compute the GCD of two numbers
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Main function to solve the problem
    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        long[] arr = new long[n];

        // Input array values
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // Copy the array and sort it
        long[] uniqueArr = arr.clone();
        Arrays.sort(uniqueArr);

        // Remove duplicates by using a set
        uniqueArr = Arrays.stream(uniqueArr).distinct().toArray();

        for (long v : uniqueArr) {
            int countV = 0, countNonV = 0;

            // Count occurrences of v and non-v values in arr
            for (int i = 0; i < n; i++) {
                if (arr[i] == v) countV++;
                else countNonV++;
            }

            if (countV > 0 && countNonV > 0) {
                long g = 0;

                // Calculate the GCD of the non-v elements
                for (int i = 0; i < n; i++) {
                    if (arr[i] != v) {
                        if (g == 0) g = arr[i];
                        else g = gcd(g, arr[i]);
                    }
                }

                // If the GCD is not equal to v, print the result
                if (g != v) {
                    System.out.println("Yes");
                    for (int i = 0; i < n; i++) {
                        if (arr[i] == v) System.out.print(1 + " ");
                        else System.out.print(2 + " ");
                    }
                    System.out.println();
                    return;
                }
            }
        }

        System.out.println("No");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // Solve each test case
        for (int i = 0; i < t; i++) {
            solve(sc);
        }

        sc.close(); // Close the Scanner after all the work is done.
    }
}
