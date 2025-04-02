import java.io.*;
import java.util.*;

public class GraphPath1 {
    static final int MOD = 1000000007;
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

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjMatrix[u][v]++;
        }

        //compute A^k
        long[][] res = matrixExpo(adjMatrix,k);
        pw.println(res[0][n-1]);
        pw.flush();
        
    }

    static long[][] matrixExpo(long[][] base, int exp){
        int size = base.length;
        long[][] res = new long[size][size];

        for (int i = 0; i < size; i++) {
            res[i][i] = 1;
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
            for (int j = 0; j < size; j++) {
                for (int l = 0; l < size; l++) {
                    c[i][j] = (c[i][j] + A[i][l] * B[l][j]) % MOD;
                }
            }
        }
        return c;
    }
}
