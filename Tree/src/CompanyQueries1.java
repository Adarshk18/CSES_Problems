import java.io.*;
import java.util.*;

public class CompanyQueries1 {
    static int n, q;
    static long[][] up;
    static int LOG;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        LOG = (int)Math.ceil(Math.log(n)/Math.log(2))+1;

        up = new long[n+1][LOG];
        up[1][0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            up[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                if (up[i][j-1]!=0){
                    up[i][j] = up[(int) up[i][j-1]][j-1];
                }
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pw.println(kthAncestor(x,y));
        }
        pw.close();
        br.close();
    }

    static int kthAncestor(int node, int k){
        for (int j = 0; j < LOG; j++) {
            if ((k & (1<<j))!=0){
                node = (int) up[node][j];
                if (node==0) return -1;
            }
        }
        return node==0 ? -1:node;
    }
}
