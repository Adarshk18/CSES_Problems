import java.io.*;
import java.util.*;

public class CountingGrids {
    static final int MOD = 1_000_000_007;

    // Modular Exponentiation
    static long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        if (n == 1) {
            System.out.println(2);  // Base case for n = 1
            return;
        }

        long nSquared = (long) n * n;

        // Correct calculation for rotations
        long total = (modPow(2, nSquared, MOD)                  // 0° rotation
                + 2 * modPow(2, (nSquared + 3) / 4, MOD)   // 90° and 270° rotations (fixed rounding)
                + modPow(2, (nSquared + 1) / 2, MOD)) % MOD; // 180° rotation (fixed rounding)

        long result = (total * modPow(4, MOD - 2, MOD)) % MOD;  // Divide by 4 using modular inverse

        System.out.println(result);
    }
}
