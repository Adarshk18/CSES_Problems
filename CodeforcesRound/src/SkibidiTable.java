import java.util.*;

public class SkibidiTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();          // size exponent
            int q = sc.nextInt();          // number of queries
            int size = 1 << n;             // grid size = 2^n

            while (q-- > 0) {
                String type = sc.next();
                if (type.equals("->")) {
                    int r = sc.nextInt();
                    int c = sc.nextInt();
                    System.out.println(iterativeFindXY(n, r, c));
                } else {
                    int d = sc.nextInt();
                    int[] res = iterativeFindD(n, d);
                    System.out.println(res[0] + " " + res[1]);
                }
            }
        }
        sc.close();
    }

    static int iterativeFindXY(int n, int r, int c) {
        int value = 1;
        int x = 1, y = 1;
        int size = 1 << n;

        for (int level = n; level > 0; level--) {
            int half = size >> 1;
            int subTotal = (size * size) / 4;
            int quadrant = 0;

            if (r >= x + half && c >= y + half) {
                quadrant = 1;
                x += half;
                y += half;
            } else if (r >= x + half && c < y + half) {
                quadrant = 2;
                x += half;
            } else if (r < x + half && c >= y + half) {
                quadrant = 3;
                y += half;
            } // else quadrant 0, stays in top-left

            value += subTotal * quadrant;
            size = half;
        }

        return value;
    }

    static int[] iterativeFindD(int n, int d) {
        int value = 1;
        int x = 1, y = 1;
        int size = 1 << n;

        for (int level = n; level > 0; level--) {
            int half = size >> 1;
            int subTotal = (size * size) / 4;
            int quadrant = (d - value) / subTotal;

            if (quadrant == 1) {
                x += half;
                y += half;
            } else if (quadrant == 2) {
                x += half;
            } else if (quadrant == 3) {
                y += half;
            }

            value += subTotal * quadrant;
            size = half;
        }

        return new int[]{x, y};
    }
}
