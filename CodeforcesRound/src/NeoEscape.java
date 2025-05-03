import java.util.*;

public class NeoEscape {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(in.nextInt());
            }

            //Removing the consecutive duplicates
            List<Integer> b = new ArrayList<>();
            int l = -1;
            for (int i = 0; i < n; i++) {
                if (a.get(i)!=l){
                    b.add(a.get(i));
                }
                l = a.get(i);
            }

            n = b.size();
            List<int[]> vex = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                vex.add(new int[]{b.get(i),i});
            }

            //sort the array in decreasing order
            vex.sort((x,y)-> Integer.compare(y[0],x[0]));

            int[] chk = new int[n];
            int ans =0;
            for (int i = 0; i < n; i++) {
                int j = vex.get(i)[1];
                if (j>0 && chk[j-1]==1){
                    chk[j] = 1;
                    continue;
                }
                if (j<n-1 && chk[j+1]==1){
                    chk[j]=1;
                    continue;
                }
                chk[j] = 1;
                ans++;
            }
            System.out.println(ans);
        }


    }
}
