import java.io.*;
import java.util.*;

public class GraphPathII {
    static final long INF = (long)2e18;
    static int n,m,k;
    static long[][] adjMatrix;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adjMatrix = new long[n][n];
        for (int i = 0; i < n; i++) {
           Arrays.fill(adjMatrix[i],INF);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            adjMatrix[u][v] = Math.min(adjMatrix[u][v],c);
        }

        //compute A^k
        long[][] res = matrixExpo(adjMatrix,k);
        long answer = res[0][n-1];

        pw.println( answer >= INF ? -1 : answer);
        pw.flush();

    }

    static long[][] matrixExpo(long[][] base, int exp){
        int size = base.length;
        long[][] res = new long[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(res[i],INF);
            res[i][i] = 0;
        }

        while (exp>0){
            if ((exp&1)==1){
                res = multiplyMatrix(res,base);
            }
            base = multiplyMatrix(base,base);
            exp>>=1;
        }
        return  res;
    }

    static long[][] multiplyMatrix(long[][] A ,long[][] B){
        int size = A.length;
        long[][] c = new long[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(c[i],INF);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int l = 0; l < size; l++) {
                    if (A[i][l] <INF && B[l][j]<INF){
                        c[i][j] = Math.min(c[i][j] , A[i][l] + B[l][j]);
                    }
                }
            }
        }
        return c;
    }
}
