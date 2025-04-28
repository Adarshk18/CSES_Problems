import java.io.*;
import java.util.*;

public class Move {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] parts = br.readLine().split(" ");
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(parts[i]);
            }

            // Initialize suffix sum array
            long[] suffix = new long[n + 1];
            suffix[n] = 0;

            for (int i = n - 1; i >= 0; i--) {
                suffix[i] = suffix[i + 1] + a[i];
            }

            long[] result = new long[n];
            for (int k = 1; k <= n; k++) {
                long maxSum = Long.MIN_VALUE;

                // Try moving each element to the end and calculate the sum of the last k elements
                for (int i = 0; i <= n - k; i++) {
                    long sum = suffix[n - k] + a[i];
                    maxSum = Math.max(maxSum, sum);
                }

                result[k - 1] = maxSum;
            }

            // Output the result
            for (long res : result) {
                out.print(res + " ");
            }
            out.println();
        }
        out.flush();
    }
}
