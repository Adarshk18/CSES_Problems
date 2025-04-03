import java.io.*;
import java.util.*;

public class LargeArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim()); // Number of test cases

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            long[] prefix = new long[n + 1];

            // Compute prefix sum for array `a`
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                prefix[i + 1] = prefix[i] + a[i];
            }

            long sumA = prefix[n]; // Total sum of one complete cycle of `a`
            long totalB = sumA * k; // Total sum of full `b`

            // If even full `b` doesn't reach `x`, answer is 0
            if (totalB < x) {
                pw.println(0);
                continue;
            }

            int count = 0;
            for (int l = 0; l < n * k; l++) {
                long sum = 0;
                for (int r = l; r < n * k; r++) {
                    sum += a[r % n]; // Cyclic array simulation
                    if (sum >= x) {
                        count += (n * k - r);
                        break;
                    }
                }
            }

            pw.println(count);
        }
        pw.flush();
        pw.close();
    }
}
