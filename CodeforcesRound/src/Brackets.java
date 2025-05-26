import java.util.*;

public class Brackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        while(t-->0){
            String s = in.nextLine();
            int n = s.length();

            int cnt=0,sum=0;
            for(int i=0; i<n; i++){
                char ch = s.charAt(i);
                sum += (ch== ')' ? -1: 1);
                if (sum==0){
                    cnt++;
                }
            }
            System.out.println(cnt>1 ? "YES": "NO");
        }
    }
}
