import java.io.*;
import java.util.*;

public class Square {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());


            if (l==r && d==u && l==d){
                pw.println("Yes");
            }else{
                pw.println("No");
            }
        }
        pw.flush();
    }
}
