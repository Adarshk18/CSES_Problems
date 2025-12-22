import java.io.*;
import java.util.*;

public class LIS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] tails = new int[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            int left = 0, right = size;
            while (left < right) {
                int mid = (left + right) / 2;
                if (tails[mid] < num) left = mid + 1;
                else right = mid;
            }

            tails[left] = num;
            if (left == size) size++;
        }

        System.out.println(size);
    }
}
