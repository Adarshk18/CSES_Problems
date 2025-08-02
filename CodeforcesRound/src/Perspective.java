import java.util.*;

class Pair{
    int a,b,index;

    Pair(int a,int b, int index){
        this.a = a;
        this.b = b;
        this.index = index;
    }
}
public class Perspective {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();

            List<Pair> ls = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                ls.add(new Pair(a,b,i));
            }

            ls.sort(Comparator.comparingInt(p->p.b));


            List<Integer> ans = new ArrayList<>();
            int mx = -1;

            for(Pair p: ls){
                if (p.a>mx){
                    ans.add(p.index+1);
                    mx = p.b;
                }
            }

            System.out.println(ans.size());
            for(int x: ans){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
