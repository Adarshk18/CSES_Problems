import java.io.*;
import java.util.*;

public class Chimpanzini {
    public static void solve(Scanner sc) {
        Deque<Long>[] q = new Deque[2];
        q[0] = new ArrayDeque<>();
        q[1] = new ArrayDeque<>();

        long n = 0;
        long numq = sc.nextLong();
        long sum = 0;
        boolean rev = false;
        long sum2 = 0;
        long ans = 0;

        for (long i = 0; i < numq; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                long la = q[rev ? 1 : 0].peekLast();
                sum2 -= 2 * (sum - la);
                sum2 += 2 * (n - 1) * la;
                ans += (sum - la);
                ans -= (n - 1) * la;

                q[rev ? 1 : 0].pollLast();
                q[rev ? 1 : 0].addFirst(la);

                long temp = q[!rev ? 1 : 0].pollFirst();
                q[!rev ? 1 : 0].addLast(temp);

                System.out.println(ans);
            } else if (type == 2) {
                ans += sum2;
                sum2 = -sum2;
                rev = !rev;
                System.out.println(ans);
            } else {
                long k = sc.nextLong();
                n++;
                q[rev ? 1 : 0].addLast(k);
                q[!rev ? 1 : 0].addFirst(k);
                ans += n * k;
                sum2 += sum;
                sum2 += (1 - n) * k;
                sum += k;
                System.out.println(ans);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            solve(sc);
        }
    }
}
