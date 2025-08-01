import java.util.*;

public class Pathless {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int s = in.nextInt();

            int sum =0;
            int[] cnt = new int[3];

            for (int i = 0; i < n; i++) {
              int x = in.nextInt();
              if (x<0 || x>2) continue;
              sum += x;
              cnt[x]++;
            }
            int diff = s-sum;
            if (sum > s || diff==1){
                List<Integer> result = new ArrayList<>();
                for (int i = 0; i < cnt[0]; i++) result.add(0);
                for (int i = 0; i < cnt[2]; i++) result.add(2);
                for (int i = 0; i < cnt[1]; i++) result.add(1);
                for (int i = 0; i < result.size(); i++) {
                    System.out.print(result.get(i));
                    if (i < result.size() - 1) System.out.print(" ");
                }
                System.out.println();
            }else{
                System.out.println("-1");
            }

        }
    }
}
