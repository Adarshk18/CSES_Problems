import java.io.*;
import java.util.*;

public class CloudberryJam {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());


        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int berriesNeeded = 2*n;
            pw.println(berriesNeeded);
            pw.flush();

        }
    }
}
