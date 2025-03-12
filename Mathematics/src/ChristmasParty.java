import java.io.*;

public class ChristmasParty {
    static final int MOD = 1000000007;
    static long[] derangement;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // Precompute derangements
        precompute(n);

        // Output the result
        System.out.println(derangement[n]);
    }

    static void precompute(int max) {
        derangement = new long[max + 1];
        derangement[0] = 1;  // By definition
        if (max > 0) derangement[1] = 0; // 1 child can't gift an apple to anyone else

        for (int i = 2; i <= max; i++) {
            derangement[i] = (i - 1) * (derangement[i - 1] + derangement[i - 2]) % MOD;
        }
    }
}
