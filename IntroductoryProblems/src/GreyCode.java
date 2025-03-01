import java.util.*;
import java.io.*;

public class GreyCode {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        int total = 1<<n;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<total; i++){
            int gray = i ^ (i>>1);
            String binary = String.format("%" + n + "s", Integer.toBinaryString(gray)).replace(' ', '0');
            sb.append(binary).append("\n");
        }
        pw.println(sb);
        pw.flush();
    }
}
