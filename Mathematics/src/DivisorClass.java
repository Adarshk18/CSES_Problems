import java.io.*;
import java.util.*;

public class DivisorClass {
    static final int MOD = 1_000_000_007;

    // Function to compute (a^b) % mod using modular exponentiation
    static long powerMod(long a, long b, long mod) {
        long res = 1;
        a = a % mod;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    // Function to compute modular inverse using Fermat's theorem
    static long modInverse(long a, long mod) {
        return powerMod(a, mod - 2, mod);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int m = Integer.parseInt(br.readLine().trim()); // Number of prime factors

        long D = 1; // Number of divisors
        long S = 1; // Sum of divisors
        long n = 1; // The number itself

        while (m-- > 0) {  // Iterate using `m`
            String[] input = br.readLine().trim().split(" ");

            int p = Integer.parseInt(input[0]);  // Prime number
            int k = Integer.parseInt(input[1]);  // Power

            // Update the number of divisors
            D = (D * (k + 1)) % MOD;  // MOD for number of divisors

            // Compute sum of divisors: (p^(k+1) - 1) / (p - 1)
            long pk1 = powerMod(p, k + 1, MOD); // p^(k+1) % MOD
            long sumDiv = (pk1 - 1 + MOD) % MOD;
            sumDiv = (sumDiv * modInverse(p - 1, MOD)) % MOD;
            S = (S * sumDiv) % MOD;

            // Compute the number n
            n = (n * powerMod(p, k, MOD)) % MOD;
        }

        // Compute the product of divisors
        long P;
        if (D % 2 == 0) {
            // If D is even, P = n^(D/2) % MOD
            P = powerMod(n, D / 2, MOD);
        } else {
            // If D is odd, n is a perfect square, so P = n^((D-1)/2) * sqrt(n) % MOD
            // Compute sqrt(n) by halving the exponents of its prime factors
            long sqrtN = 1;
            long tempN = n;
            for (int i = 2; i * i <= tempN; i++) {
                if (tempN % i == 0) {
                    int count = 0;
                    while (tempN % i == 0) {
                        tempN /= i;
                        count++;
                    }
                    sqrtN = (sqrtN * powerMod(i, count / 2, MOD)) % MOD;
                }
            }
            if (tempN > 1) {
                sqrtN = (sqrtN * powerMod(tempN, 1 / 2, MOD)) % MOD;
            }
            P = (powerMod(n, (D - 1) / 2, MOD) * sqrtN) % MOD;
        }

        pw.println(D + " " + S + " " + P);
        pw.flush();
    }
}