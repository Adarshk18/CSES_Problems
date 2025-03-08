import java.io.*;
import java.util.*;

public class CountingCoprime {
    // Precompute smallest prime factor (SPF) for factorization
    public static int[] computeSPF(int max) {
        int[] spf = new int[max + 1];
        for (int i = 0; i <= max; i++) spf[i] = i;
        for (int i = 2; i * i <= max; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= max; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
        return spf;
    }

    public static void main(String[] args) throws Exception {
        // Use BufferedReader for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Use PrintWriter for output
        PrintWriter pw = new PrintWriter(System.out);

        // Read n
        int n = Integer.parseInt(br.readLine().trim());

        // Read array using StringTokenizer
        int[] arr = new int[n];
        int[] freq = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            freq[arr[i]]++;
        }

        int max = 1000000;
        int[] spf = computeSPF(max);

        // Total pairs
        long totalPairs = (long) n * (n - 1) / 2;

        // For each number, count pairs that are NOT coprime
        long[] nonCoprime = new long[max + 1];
        for (int x = 1; x <= max; x++) {
            if (freq[x] == 0) continue;
            // Get prime factors of x
            int temp = x;
            Set<Integer> primes = new HashSet<>();
            while (temp > 1) {
                primes.add(spf[temp]);
                temp /= spf[temp];
            }
            // For each subset of prime factors (except empty)
            long count = 0;
            for (int mask = 1; mask < (1 << primes.size()); mask++) {
                int product = 1;
                int bitCount = 0;
                int index = 0;
                for (int p : primes) {
                    if ((mask & (1 << index)) != 0) {
                        product *= p;
                        bitCount++;
                    }
                    index++;
                }
                // Numbers divisible by product are not coprime with x
                int multipleCount = 0;
                for (int m = product; m <= max; m += product) {
                    multipleCount += freq[m];
                }
                // Subtract x itself if present
                if (x % product == 0) multipleCount--;
                count += (bitCount % 2 == 1 ? 1 : -1) * multipleCount;
            }
            nonCoprime[x] = count;
        }

        long nonCoprimePairs = 0;
        for (int x = 1; x <= max; x++) {
            if (freq[x] > 0) {
                nonCoprimePairs += freq[x] * nonCoprime[x];
            }
        }
        nonCoprimePairs /= 2; // Each pair counted twice

        long coprimePairs = totalPairs - nonCoprimePairs;
        pw.println(coprimePairs);

        // Flush and close
        pw.flush();
        pw.close();
        br.close();
    }
}