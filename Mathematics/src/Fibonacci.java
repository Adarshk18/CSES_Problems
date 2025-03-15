import java.io.*;

public class Fibonacci {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        long n = Long.parseLong(br.readLine().trim());

        if (n == 0) {
            pw.println(0);
        } else {
            long[][] result = matrixExpo(n - 1);
            pw.println(result[0][0]);
        }

        pw.flush();
    }

    // Matrix Exponentiation function
    static long[][] matrixExpo(long n) {
        long[][] result = {{1, 0}, {0, 1}};  // Identity matrix
        long[][] base = {{1, 1}, {1, 0}};

        while (n > 0) {
            if ((n & 1) == 1) {
                result = multiplyMatrix(result, base);
            }
            base = multiplyMatrix(base, base);  // Square the base
            n >>= 1;  // Divide n by 2
        }

        return result;
    }

    // Matrix Multiplication function
    static long[][] multiplyMatrix(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        res[0][0] = (a[0][0] * b[0][0] % MOD + a[0][1] * b[1][0] % MOD) % MOD;
        res[0][1] = (a[0][0] * b[0][1] % MOD + a[0][1] * b[1][1] % MOD) % MOD;
        res[1][0] = (a[1][0] * b[0][0] % MOD + a[1][1] * b[1][0] % MOD) % MOD;
        res[1][1] = (a[1][0] * b[0][1] % MOD + a[1][1] * b[1][1] % MOD) % MOD;
        return res;
    }
}
