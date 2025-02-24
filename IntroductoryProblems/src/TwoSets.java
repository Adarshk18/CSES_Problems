import java.io.*;
import java.util.*;

public class TwoSets {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);


        int n = Integer.parseInt(br.readLine());

        long sum = (long) n * (n+1)/2;
        if(sum%2!=0){
            pw.println("NO");
        }else{
            pw.println("YES");

            long target = sum/2;
            List<Integer> setA = new ArrayList<>();
            List<Integer> setB = new ArrayList<>();

            for(int i=n; i>=1; i--){
                if(i<=target){
                    setA.add(i);
                    target -= i;
                }else{
                    setB.add(i);
                }
            }

            //print the first set
            pw.println(setA.size());
            for(int num: setA){
                pw.print(num + " ");
            }
            pw.println();


            //print the second set
            pw.println(setB.size());
            for(int num: setB){
                pw.print(num + " ");
            }
            pw.println();
        }
        pw.flush();
    }
}
