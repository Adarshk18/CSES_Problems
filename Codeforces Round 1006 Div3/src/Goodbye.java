import java.io.*;
import java.util.*;

public class Goodbye {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long sum = 0;

            // Precompute for p from 2 to min(k, n)
            int limit = (int) Math.min(k, n);
            for (int p = 2; p <= limit; p++) {
                sum = (sum + rev(n, p)) % MOD;
            }

            // For p > n, rev(n, p) = n
            if (k > n) {
                long count = k - n;
                sum = (sum + (count % MOD) * n % MOD) % MOD;
            }

            pw.println(sum);
        }

        pw.flush();
        pw.close();
    }

    // Function to compute rev(n, p)
    static int rev(int n, int p) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * p + (n % p);
            n /= p;
        }
        return reversed;
    }
}