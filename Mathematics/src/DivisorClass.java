import java.io.*;
import java.util.*;

public class DivisorClass {
    static final long MOD = 1000000007;

    static long pow(long b, long e) {
        long r = 1;
        b %= MOD;
        while(e > 0) {
            if((e & 1) == 1) r = r * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        long num = 1, sum = 1, N = 1;

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            num = num * (k + 1) % MOD;
            sum = sum * (pow(p, k + 1) - 1 + MOD) % MOD * pow(p - 1, MOD - 2) % MOD;
            N = N * pow(p, k) % MOD;
        }

        long halfNum = num % 2 == 0 ? num / 2 : (num * pow(2, MOD - 2)) % MOD;
        long prod = pow(N, halfNum);

        pw.println(num + " " + sum + " " + prod);
        pw.flush();
        pw.close();
    }
}