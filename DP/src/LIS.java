import java.util.*;


public class LIS {

    public static int lis(int[] arr) {

        //remember due to contraints we cannot solve this using classic dp : TC ~ O(n2) which is not possible for 2x10^5
        //so will solve using greedy + binary search in O(nlogn)


        int n = arr.length;
        int[] tails = new int[n];
        int size = 0;

        for (int x : arr) {
            int left = 0, right = size;

            while (left < right) {
                int mid = (left + right) / 2;
                if (tails[mid] < x)
                    left = mid + 1;
                else
                    right = mid;
            }

            tails[left] = x;
            if (left == size) size++;
        }

        return size;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(lis(arr));
    }
}
