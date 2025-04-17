import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int[] a = new int[n];

            // Step 1: Fill the array with 0, 1, 2, ..., k-1
            int k = Math.min(n, 30); // MEX cannot exceed 30 because x < 2^30
            for (int i = 0; i < k; i++) {
                a[i] = i;
            }

            // Step 2: Calculate the current OR of the array
            int currentOr = 0;
            for (int num : a) {
                currentOr |= num;
            }

            // Step 3: If the current OR does not equal x, adjust the array
            if (currentOr != x) {
                // Add x to the array if there is space
                if (k < n) {
                    a[k] = x;
                } else {
                    // Replace the last element with x
                    a[k - 1] = x;
                }
            }

            // Step 4: Ensure the OR condition is satisfied
            currentOr = 0;
            for (int num : a) {
                currentOr |= num;
            }

            // Step 5: If the OR condition is still not satisfied, adjust further
            if (currentOr != x) {
                // Replace the first element with x
                a[0] = x;
            }

            // Step 6: Print the array
            for (int num : a) {
                pw.print(num + " ");
            }
            pw.println();
        }

        pw.flush();
        pw.close();
    }
}