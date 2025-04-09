import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Number {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t= Integer.parseInt(br.readLine());

        while(t-->0){
            String s = br.readLine();
            int n = s.length();
            int ans = n-1;
            int last = n-1;

            for (int i = n-1; i >=0 ; i--) {
                if (s.charAt(i)!='0'){
                    last = i;
                    break;
                }
            }

            for (int i = 0; i < last; i++) {
                if (s.charAt(i)=='0') ans--;
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
