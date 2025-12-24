import java.util.*;

public class CountingTilings {
    static final int MOD = 1_000_000_007;
    static int n,m;
    static long[] dp, nextDp;

    static void dfs(int row, int currMask, int nextMask){
        if (row==n){
            nextDp[nextMask] = (nextDp[nextMask] + dp[currMask])%MOD;
            return;
        }

        //if current cell is already filled
        if ((currMask & (1<<row))!=0){
            dfs(row+1,currMask,nextMask);
        }else{
            //vertical domino
            if (row +1 < n && (currMask & (1<<(row+1)))==0){
                dfs(row+2,currMask,nextMask);
            }

            //horizontal domino
            dfs(row+1,currMask,nextMask | (1<<row));
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        int maxMask = 1<<n;
        dp = new long[maxMask];
        dp[0] = 1;

        for (int col = 0; col < m; col++) {
            nextDp = new long[maxMask];
            for (int mask = 0; mask < maxMask; mask++) {
                if (dp[mask]!=0){
                    dfs(0,mask,0);
                }
            }
            dp = nextDp;
        }
        System.out.println(dp[0]);
    }
}
