import java.io.*;
import java.util.*;

public class Exponentiation {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long result = modExpo(a, b, MOD);
            pw.println(result);
        }
        pw.flush();
    }

    // **Efficient Modular Exponentiation using Binary Exponentiation (O(log b))**
    static long modExpo(long base, long exp, int mod) {
        long result = 1;
        base %= mod; // To prevent overflow at the start

        while (exp > 0) {
            if ((exp & 1) == 1) { // If `exp` is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod; // Square the base
            exp >>= 1; // Divide exponent by 2
        }
        return result;
    }
}
