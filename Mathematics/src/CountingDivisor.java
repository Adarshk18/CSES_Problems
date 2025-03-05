import java.io.*;
import java.util.*;

public class CountingDivisor {
    static final int MAX = 1000000;
    static int[] distinctCnt = new int[MAX+1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        precompute();
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            int x = Integer.parseInt(br.readLine());
            pw.println(distinctCnt[x]);
        }
        pw.flush();
    }

    static void precompute(){
        for (int i = 1; i <= MAX; i++) {
            for (int j = i; j <= MAX; j+=i) {
                distinctCnt[j]++;
            }
        }
    }
}
