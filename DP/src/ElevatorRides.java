import java.util.*;

public class ElevatorRides {

    static class Pair{
        int rides;
        long weight;

        Pair(int rides, long weight){
            this.rides = rides;

            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long x = in.nextLong();

        long[] w = new long[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextLong();
        }

        int N = 1<<n;
        Pair[] dp = new Pair[N];

        for (int i = 0; i < N; i++) {
            dp[i] = new Pair(n+1,0);
        }
        dp[0] = new Pair(1,0);

        for (int mask = 0; mask < N; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1<<i))==0){
                    Pair curr = dp[mask];
                    Pair next;

                    if (curr.weight + w[i] <=x){
                        next = new Pair(curr.rides, curr.weight+w[i]);
                    }else{
                        next = new Pair(curr.rides+1, w[i]);
                    }

                    int newMak = mask | (1<<i);

                    if (next.rides < dp[newMak].rides || (next.rides == dp[newMak].rides && next.weight < dp[newMak].weight)){
                        dp[newMak] = next;
                    }
                }
            }
        }
        System.out.println(dp[N-1].rides);

    }
}
