import java.io.*;
import java.util.*;

public class ThreeDecks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while(t-->0){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            int total = a+b+c;
            if (total%3!=0){
                System.out.println("NO");
            }else{
                int x = total/3;
                if (x>=a && x>=b && x<=c){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}
