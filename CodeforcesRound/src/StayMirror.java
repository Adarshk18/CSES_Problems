import java.util.*;

public class StayMirror {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();

            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(in.nextInt());
            }
            int ans =0;
            for (int i = 1; i <= n; i++) {
                int pos = 0;
                while (a.get(pos)!=i) pos++;

                ans += Math.min(pos,a.size()-pos-1);
                a.remove(pos);
            }
            System.out.println(ans);
        }
    }
}
