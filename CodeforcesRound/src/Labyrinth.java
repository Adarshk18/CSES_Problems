import java.io.*;
import java.util.*;

public class Labyrinth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n + 1]; // Destination array

            // Step 1: Create an initial valid cycle of size 2 (1<->2, 3<->4, ...)
            for (int i = 1; i < n; i += 2) {
                a[i] = i + 1;
                a[i + 1] = i;
            }

            // If n is odd, connect the last cell to n-1 (since it must not point to itself)
            if (n % 2 == 1) {
                a[n] = n - 1;
            }

            // Step 2: If k is odd, apply teleportation once more to swap each pair
            if (k % 2 == 1) {
                for (int i = 1; i <= n; i++) {
                    a[i] = a[a[i]];
                }
            }

            // Step 3: Print the teleportation configuration
            for (int i = 1; i <= n; i++) {
                pw.print(a[i] + " ");
            }
            pw.println();
        }

        pw.flush();
    }
}
