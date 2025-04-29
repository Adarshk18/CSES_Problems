import java.io.*;
import java.util.*;

public class CardGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            String s = in.next();

            if (s.charAt(0)==s.charAt(n-1)){
                if (s.charAt(0)=='A'){
                    System.out.println("Alice");
                }else{
                    System.out.println("Bob");
                }
            }else if(s.charAt(0)=='A' && s.charAt(n-1)=='B'){
                long cnt = s.chars().filter(ch->ch=='B').count();
                if (cnt==1)
                {
                    System.out.println("Alice");
                }else{
                    System.out.println("Bob");
                }
            }else{
                if (n==2){
                    System.out.println("Bob");
                }else{
                    if (s.charAt(n-2)=='A'){
                        System.out.println("Alice");
                    }else{
                        System.out.println("Bob");
                    }
                }
            }
        }
    }
}
