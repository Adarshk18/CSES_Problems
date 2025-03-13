import java.io.*;
import java.math.BigInteger;

public class SequenceI {
    static final int MOD = 1000000007;  // Correct MOD value

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine().trim());

        // If the length is odd, we can't create a valid bracket sequence
        if (n % 2 != 0) {
            pw.println(0);
            pw.flush();
            return;
        }

        int k = n / 2;
        pw.println(calculateComb(k));
        pw.flush();
    }

    static long calculateComb(int k) {
        long[] fact = new long[2 * k + 1];
        fact[0] = 1;

        for (int i = 1; i <= 2 * k; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long comb = (fact[2 * k] * modInverse(fact[k], MOD) % MOD)
                * modInverse(fact[k], MOD) % MOD;

        return (comb * modInverse(k + 1, MOD)) % MOD;
    }


    static long modInverse(long a, long mod) {
        return BigInteger.valueOf(a).modInverse(BigInteger.valueOf(mod)).longValue();
    }
}
