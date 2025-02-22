import java.io.*;
import java.util.*;

public class IncreasingArray {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());

       StringTokenizer st = new StringTokenizer(br.readLine());

       long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long moves =0;
        for (int i = 1; i < n; i++) {
            if (arr[i]<arr[i-1]){
                moves += (arr[i-1]-arr[i]);
                arr[i] = arr[i-1];
            }
        }
        System.out.println(moves);
    }
}
