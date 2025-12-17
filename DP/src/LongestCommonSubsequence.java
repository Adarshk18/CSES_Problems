import java.util.*;


public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }

        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }

        int[][] dp = new int[n+1][m+1];


//        for (int j = 0; j <= m; j++) {
//            prev[j] = 0;  //base case if array is empty then LCS wud be zero .
//        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (arr1[ind1-1] == arr2[ind2-1]){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }else{
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }

        //backtracking
        int i=n, j=m;
        List<Integer> lcs = new ArrayList<>();
        while (i>0 && j>0){
            if (arr1[i-1]==arr2[j-1]){
                lcs.add(arr1[i-1]);
                i--;
                j--;
            }else if(dp[i-1][j] >dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }

        Collections.reverse(lcs);
        System.out.println(dp[n][m]);

        for(int val: lcs){
            System.out.print(val + " ");
        }

    }
}
