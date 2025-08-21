import java.util.*;

public class HomeWork {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            String a = in.next();
            int m = in.nextInt();
            String b = in.next();
            String c = in.next();

            StringBuilder sb = new StringBuilder(a);

            for (int i = 0; i < m; i++) {
                if (c.charAt(i)=='V'){
                    sb.insert(0,b.charAt(i));
                }else{
                    sb.append(b.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
