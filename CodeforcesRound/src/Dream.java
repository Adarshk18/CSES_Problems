import java.util.*;

public class Dream {
    public static boolean find(int x, int y){
        int max = Math.max(x,y);
        int min = Math.min(x,y);
        return max<=2*min+2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();

            int firstR = a, firstK = b;
            int secondR = c-a,secondK = d-b;

            if (find(firstR,firstK) && find(secondR,secondK)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
