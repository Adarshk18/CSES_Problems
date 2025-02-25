import java.io.*;
import java.util.*;

public class NewArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(k<-n*p || k>n*p){
                pw.println(-1);
                continue;
            }

            if (k==0){
                pw.println(0);
                continue;
            }

            //calculating min operations
            int minOperations = Math.abs(k)/p;
            if(Math.abs(k)%p!=0){
                minOperations++;
            }
            pw.println(minOperations);
        }
        pw.flush();
    }
}
