import java.io.*;
import java.util.*;

public class Permutation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-->0){
            pp(br,bw);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void pp(BufferedReader br, BufferedWriter bw) throws IOException{
        //taking the inputs
        int n = Integer.parseInt(br.readLine());

        int[] p = new int[n+1];
        String[] pStr = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(pStr[i-1]);
        }

        //creating the grp
        int[] grp = new int[n+1];
        Arrays.fill(grp,-1);
        int k =1;

        for (int i = 1; i <= n; i++) {
            if (grp[i]!=-1) continue;

            grp[i] = k;
            int j = p[i];
            while(j!=i){
                grp[j] = k;
                j = p[j];
            }
            k++;
        }

        boolean[] check = new boolean[k+1];
        int[] size = new int[k+1];

        for (int i = 1; i <= n; i++) {
            size[grp[i]]++;
        }

        int ans = 0;
        String[] queryStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(queryStr[i]);
            int grpId = grp[d];
            if (!check[grpId]){
                ans += size[grpId];
                check[grpId] = true;
            }
            bw.write(ans + " ");
        }
        bw.newLine();
    }
}
