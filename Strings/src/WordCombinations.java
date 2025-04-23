import java.util.*;

public class WordCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        String s = scanner.nextLine();
        int n = s.length();
        int k = Integer.parseInt(scanner.nextLine());
        String[] words = new String[k];
        for (int i = 0; i < k; i++) {
            words[i] = scanner.nextLine();
        }

        // Constants
        final long MOD = 1_000_000_007;

        // DP array
        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: one way to form empty string

        // For each position i in the string
        for (int i = 1; i <= n; i++) {
            // Try each word in the dictionary
            for (String word : words) {
                int len = word.length();
                // Check if the word can be placed ending at position i
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    dp[i] = (dp[i] + dp[i - len]) % MOD;
                }
            }
        }

        // Output the result
        System.out.println(dp[n]);

        scanner.close();
    }
}