import java.util.*;


public class LIS {

    public static int lis(int[] arr){
        int n = arr.length;

        int[][] dp = new int[n+1][n+1];

        for (int ind = n-1; ind >= 0; ind--) {
            for (int prevInd = ind-1; prevInd >= -1; prevInd--) {
                int len = dp[ind+1][prevInd+1];
                if (prevInd==-1 || arr[ind] > arr[prevInd]){
                    len = Math.max(len, 1+dp[ind+1][ind+1]);
                }
                dp[ind][prevInd+1] = len;
            }

        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(lis(arr));
    }
}
