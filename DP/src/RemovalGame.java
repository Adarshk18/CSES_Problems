import java.util.*;

public class RemovalGame {

    static long rgspace(int[] arr){
        int n = arr.length;
        long[] prev = new long[n];

        for (int i = 0; i < n; i++) {
            prev[i] = arr[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0;i+len-1<n; i++) {
                int j = i +len-1;
                prev[i] = Math.max(arr[i]-prev[i+1],arr[j]-prev[i]);
            }
        }

        long total =0;
        for(int x: arr) total += x;

        return (total + prev[0])/2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(rgspace(arr));

    }
}
