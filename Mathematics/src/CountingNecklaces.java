import java.io.*;
import java.util.*;

public class CountingNecklaces {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] input = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        long result = 0;

        // Burnside's Lemma Implementation
        for (int i = 0; i < n; i++) {
            result = (result + modPow(m, gcd(i, n), MOD)) % MOD;
        }

        // Final calculation
        result = (result * modInverse(n, MOD)) % MOD;

        pw.println(result);
        pw.flush();
    }

    // Fast Exponentiation (m^exp % MOD)
    static long modPow(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // Greatest Common Divisor
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Modular Inverse using Fermat's Little Theorem
    static long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }
}
