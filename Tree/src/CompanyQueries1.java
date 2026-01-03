import java.io.*;
import java.util.*;

public class CompanyQueries1 {
    static int n, q;
    static int[][] up;
    static int LOG;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        LOG = (int)(Math.log(n)/Math.log(2)+1);

        up = new int[n+1][LOG];
        up[1][0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            up[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                if (up[i][j-1]!=0){
                    up[i][j] = up[up[i][j-1]][j-1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(kthAncestor(x,k)).append("\n");
        }
        System.out.print(sb);
    }

    static int kthAncestor(int node, int k){
        for (int j = 0; j < LOG; j++) {
            if ((k & (1<<j))!=0){
                node = up[node][j];
                if (node==0) return -1;
            }
        }
        return node==0 ? -1:node;
    }
}
