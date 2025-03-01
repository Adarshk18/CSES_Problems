import java.io.*;
import java.util.*;

public class TowerOfHanoi {
    static StringBuilder sb = new StringBuilder();
    public static void solve(int n, int from, int to, int aux){
        if (n==0) return;

        //Move n-1 from 'from' to 'aux'
        solve(n-1,from,aux,to);

        //Move nth from 'from' to 'to'
        sb.append(from).append(" ").append(to).append("\n");

        //Move n-1 from 'aux' to 'to'
        solve(n-1,aux,to,from);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int moves = (1<<n)-1; //2^n -1
        sb.append(moves).append("\n");

        solve(n,1,3,2);
        System.out.println(sb.toString());
    }
}
