import java.util.*;

public class PickyCat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(in.nextInt());
            }

            long x = Math.abs(arr.get(0));
            long l =0, r =0;
            for (int i = 1; i < n; i++) {
                long y = Math.abs(arr.get(i));
                if (y<x){
                    l++;
                }else if(y>x){
                    r++;
                }
            }
            int xc =(n+1)/2-1;

            if (l<=xc || r>=xc){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
