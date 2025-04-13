import java.io.*;
import java.util.*;

public class StickGame {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int k = in.nextInt();

    int[] moves = new int[k];
        for (int i = 0; i < k; i++) {
            moves[i] = in.nextInt();
        }

        boolean[] dp = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            for(int move: moves){
                if (i-move >=0 && !dp[i-move]){
                    dp[i] = true;
                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            res.append(dp[i] ? 'W' : 'L');
        }
        System.out.println(res.toString());
    }
}
