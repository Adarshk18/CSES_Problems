import java.io.*;
import java.util.*;

public class JosephusQuery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            sb.append(findKthRemoved(n, k)).append("\n");
        }
        pw.print(sb);
        pw.flush();
    }

    static long findKthRemoved(long n, long k) {
        if (n == 1) return 1; // Base case

        if (k <= (n + 1) / 2) {
            // If k is in the first half, the k-th child removed is 2k
            return 2 * k;
        } else {
            // Otherwise, solve for k - (n + 1) / 2 in a smaller circle of size n / 2
            long temp = findKthRemoved(n / 2, k - (n + 1) / 2);
            if (n % 2 == 1) {
                // If n is odd, adjust the result by adding 1
                return 2 * temp + 1;
            } else {
                // If n is even, adjust the result by subtracting 1
                return 2 * temp - 1;
            }
        }
    }
}