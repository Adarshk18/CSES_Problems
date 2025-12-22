import java.util.*;

public class MountainRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();


        // Traverse from left to right
        for (int i = 0; i < n; i++) {
            int cnt =0;

            while (!stack.isEmpty() && h[i] > h[stack.peek()]) {
                cnt++;
                stack.pop();
            }

            if (!stack.isEmpty()){
                cnt++;
            }
            left[i] = cnt;
            stack.push(i);
        }

        stack.clear();

        //cnt from right to left
        for (int i = n-1; i >= 0; i--) {
            int cnt=0;

            while (!stack.isEmpty() && h[i] > h[stack.peek()]) {
                cnt++;
                stack.pop();
            }

            if (!stack.isEmpty()){
                cnt++;
            }
            right[i] = cnt;
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i] + 1);
        }

        System.out.println(ans);
    }
}
