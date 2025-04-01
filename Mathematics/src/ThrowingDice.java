import java.io.*;

public class ThrowingDice {
    static final int MOD = 1000000007;

    // Function to multiply two matrices
    static long[][] multiply(long[][] A, long[][] B) {
        int size = A.length;
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return result;
    }

    // Function to perform matrix exponentiation
    static long[][] matrixExpo(long[][] base, long exp) {
        int size = base.length;
        long[][] result = new long[size][size];

        // Initialize identity matrix
        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exp /= 2;
        }
        return result;
    }

    // Function to compute the number of ways
    static long findWays(long n) {
        if (n <= 6) {
            long[] baseCases = {1, 2, 4, 8, 16, 32};
            return baseCases[(int) n - 1];
        }

        long[][] transformationMatrix = {
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}
        };

        long[][] resultMatrix = matrixExpo(transformationMatrix, n - 6);

        long[] baseCases = {32, 16, 8, 4, 2, 1};
        long answer = 0;

        for (int i = 0; i < 6; i++) {
            answer = (answer + resultMatrix[0][i] * baseCases[i]) % MOD;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        long n = Long.parseLong(br.readLine().trim());
        pw.println(findWays(n));

        pw.flush();
        pw.close();
    }
}
