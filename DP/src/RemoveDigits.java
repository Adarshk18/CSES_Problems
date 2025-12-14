import java.util.*;

public class RemoveDigits {
    public static int[] extractDigit(int n){
        String s = String.valueOf(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
       return digits;
    }
    public static int digit(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int[] digits = extractDigit(i);
            int minSteps = Integer.MAX_VALUE;
            for(int digit: digits){
                if (digit>0){
                    minSteps = Math.min(minSteps,dp[i-digit]);
                }
            }
            dp[i] = minSteps+1;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(digit(n));
    }
}
