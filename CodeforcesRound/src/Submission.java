import java.util.*;

public class Submission {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            int sum =0, cnt=0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                sum +=arr[i];
                if (arr[i]==0) cnt++;
            }
            System.out.println(sum + cnt);
        }
    }
}
