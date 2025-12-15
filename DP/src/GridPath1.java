import java.util.*;

public class GridPath1 {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }

        long[] prev = new long[n];
        long[] curr = new long[n];

        if (grid[0][0]=='*'){
            System.out.println(0);
            return;
        }

        prev[0] = 1;

        for (int i = 0; i < n; i++) {
            Arrays.fill(curr, 0);
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='*'){
                    curr[j] = 0;
                }else{
                    if (j==0){
                        curr[j] = prev[j];
                    }else{
                        curr[j] = (prev[j] + curr[j-1])%MOD;
                    }
                }
            }
            long[] temp = prev;
            prev = curr;
            curr = temp;
        }
        System.out.println(prev[n-1]);
    }
}
