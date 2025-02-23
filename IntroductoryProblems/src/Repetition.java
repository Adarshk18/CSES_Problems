import java.io.*;

public class Repetition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String S = br.readLine();

        int maxLen = 1, currLen =1;
        for (int i = 1; i < S.length(); i++) {
            if(S.charAt(i)==S.charAt(i-1)){
                currLen++;
            }else{
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
            }
        }
        maxLen = Math.max(maxLen,currLen);
        pw.println(maxLen);
        pw.flush();
    }
}
