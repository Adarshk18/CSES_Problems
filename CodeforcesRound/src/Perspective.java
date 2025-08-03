import java.util.*;

public class Perspective {
    static class Pair {
        int a, b, index;

        Pair(int a, int b, int index) {
            this.a = a;
            this.b = b;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            List<Pair> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                intervals.add(new Pair(a, b, i));
            }


            intervals.sort(Comparator.comparingInt(p -> p.b));

            List<Integer> ans = new ArrayList<>();
            int lastEnd = -1;

            for (Pair p : intervals) {
                if (p.a >= lastEnd) {
                    ans.add(p.index + 1);
                    lastEnd = p.b;
                }
            }

            System.out.println(ans.size());
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
