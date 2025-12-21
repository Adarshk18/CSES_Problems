import java.util.*;

public class TwoSetsII {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long totalSum = (long) n*(n+1)/2;

        if (totalSum%2!=0){
            System.out.println(0);
            return;
        }

        int target = (int)(totalSum/2);

        long[] prev = new long[target+1];
        prev[0] = 1;

        for (int num = 1; num <= n; num++) {
            for (int s = target; s >= num; s--) {
                prev[s] = (prev[s] + prev[s-num])%MOD;
            }
        }

        long inv2 = (MOD+1)/2;
        long res = (prev[target] * inv2)%MOD;

        System.out.println(res);
    }
}
