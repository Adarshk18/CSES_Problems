import java.util.*;
import java.io.*;

public class PalindromicString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int k= in.nextInt();
            in.nextLine();
            String s = in.nextLine();

            int cnt = 0;
            for(char c: s.toCharArray()){
                if (c=='0'){
                    cnt++;
                }
            }

            int cntt = n-cnt;
            int totalPair = n/2;
            int badPair = totalPair-k;

            if (cnt<badPair || cntt<badPair){
                System.out.println("NO");
                continue;
            }

            int zeroGood = cnt - badPair;
            int oneGood = cntt-badPair;

            int gP0 = zeroGood/2;
            int gP1 = oneGood/2;

            int maxGood = gP0+gP1;

            if (maxGood>=k){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
