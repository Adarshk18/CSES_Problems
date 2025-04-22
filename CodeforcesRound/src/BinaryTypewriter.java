import java.util.*;

class BinaryTypewriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();

            int cost = n + (s.charAt(0) =='1'?1:0);
            int first01 = n,first10=n;
            int last01 = -1, last10 = -1;

            for (int i = 0; i < n-1; i++) {
                if (s.charAt(i)!=s.charAt(i+1)) cost++;
                if(s.charAt(i)=='0' && s.charAt(i+1)=='1'){
                    first01 = Math.min(first01,i);
                    last01 = Math.max(last01,i);
                }else if(s.charAt(i)=='1' && s.charAt(i+1)=='0'){
                    first10 = Math.min(first10,i);
                    last10 = Math.max(last10,i);
                }
            }

            if (last01 - first01 >=2 || last10 - first10>=2){
                cost -=2;
            }

            else if (s.charAt(0)=='1' && last01!=-1) cost -=2;
            else if (s.charAt(0)=='1' && last10!=-1) cost -=1;
            else if (s.charAt(0)=='0' && s.charAt(n-1)=='0' && last01!=-1) cost -=1;

            System.out.println(cost);
        }
    }
}
