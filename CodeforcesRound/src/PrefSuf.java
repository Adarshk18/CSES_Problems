import java.util.*;

public class PrefSuf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            char[] res = new char[n];
            Arrays.fill(res,'0');

            int currMin = Integer.MAX_VALUE;
            for (int ind = 0; ind < n; ind++) {
                if (arr[ind] < currMin){
                    currMin = arr[ind];
                    res[ind] = '1';
                }
            }

            int currMax = Integer.MIN_VALUE;
            for (int ind = n-1; ind >= 0; ind--) {
                if (arr[ind]>currMax){
                    currMax = arr[ind];
                    res[ind] = '1';
                }
            }

            for(char c: res){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
