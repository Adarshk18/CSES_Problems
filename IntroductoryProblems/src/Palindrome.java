import java.io.*;
import java.util.*;


public class Palindrome {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s = br.readLine();

        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'A']++;
        }

        int oddCount =0;
        char oddChar = '\0';
        for(int i=0; i<26; i++){
            if(freq[i]%2!=0){
                oddCount++;
                oddChar = (char) (i+'A');
            }
        }

        if(oddCount>1){
            pw.println("NO SOLUTION");
        }else{
            StringBuilder left = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                if(freq[i]>1){
                    char c = (char) (i+'A');
                    int cnt = freq[i]/2;
                    left.append(String.valueOf(c).repeat(cnt));
                }
            }

            StringBuilder right = new StringBuilder(left).reverse();

            if (oddCount==1){
                left.append(oddChar);
            }

            left.append(right);
            pw.println(left.toString());
        }
        pw.flush();
        pw.close();
    }
}
