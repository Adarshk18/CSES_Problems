import java.util.*;

public class ArrayGcd {
    public static void main(String[] args) {
        final int N = (int) 1e7;
        boolean[] isprime = new boolean[N + 1];
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Long> spu = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int t = 1;
        if (sc.hasNextInt()) {
            t = sc.nextInt();
        }

        Arrays.fill(isprime, true);
        isprime[0] = isprime[1] = false;

        for (int i = 2; i <= N; i++) {
            if (isprime[i]) {
                primes.add(i);
                for (long j = (long) i * 2; j <= N; j += i) {
                    isprime[(int) j] = false;
                }
                if (primes.size() >= 4e5) break;
            }
        }

        spu.add(0L);
        for (int i = 0; i < primes.size(); i++) {
            spu.add(spu.get(i) + primes.get(i));
        }

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Arrays.sort(a);
            reverse(a);

            long[] pre = new long[n + 1];
            pre[0] = 0;
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] + a[i];
            }

            for (int i = n; i >= 0; i--) {
                if (i < spu.size() && pre[i] >= spu.get(i)) {
                    System.out.println(n - i);
                    break;
                }
            }
        }
    }

    static void reverse(long[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            long temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
