import java.util.*;

public class MixMexMax {

    public static boolean isGood(List<Integer> a) {
        Set<Integer> st = new HashSet<>();

        for (int it : a) {
            if (it != -1) {
                st.add(it);
            }
        }

        if (st.isEmpty()) {
            return true;
        }

        if (st.size() > 1) {
            return false;
        }


        int k = st.iterator().next();
        return k > 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }

            System.out.println(isGood(a) ? "YES" : "NO");
        }

        sc.close();
    }
}
