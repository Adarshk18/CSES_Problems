import java.util.*;

public class Sahur {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.next();
            String p = in.next();

            if (s.charAt(0) != p.charAt(0)) {
                System.out.println("NO");
                continue;
            }

            List<Integer> v1 = new ArrayList<>();
            List<Integer> v2 = new ArrayList<>();

            s = "." + s;
            p = "." + p;

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    int last = v1.remove(v1.size() - 1);
                    v1.add(last + 1);
                } else {
                    v1.add(1);
                }
            }

            for (int i = 1; i < p.length(); i++) {
                if (p.charAt(i) == p.charAt(i - 1)) {
                    int last = v2.remove(v2.size() - 1);
                    v2.add(last + 1);
                } else {
                    v2.add(1);
                }
            }

            StringBuilder sCompressed = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    sCompressed.append(s.charAt(i));
                }
            }

            StringBuilder pCompressed = new StringBuilder();
            for (int i = 1; i < p.length(); i++) {
                if (p.charAt(i) != p.charAt(i - 1)) {
                    pCompressed.append(p.charAt(i));
                }
            }

            if (!sCompressed.toString().equals(pCompressed.toString())) {
                System.out.println("NO");
                continue;
            }

            boolean ok = true;
            for (int i = 0; i < v1.size(); i++) {
                if (v2.get(i) < v1.get(i) || v2.get(i) > 2 * v1.get(i)) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }

        in.close();
    }
}
