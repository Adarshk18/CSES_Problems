import java.io.*;
import java.util.*;

public class Queens {
    static char[][] board = new char[8][8];
    static boolean[] col = new boolean[8];
    static boolean[] dig1 = new boolean[15];
    static boolean[] dig2 = new boolean[15];
    static int count = 0;

    static void solve(int row){
        if (row == 8){
            count++;
            return;
        }

        for (int c = 0; c < 8; c++) {
            if (board[row][c] == '.' && !col[c] && !dig1[row-c+7] && !dig2[row+c]){
                col[c] = dig1[row-c+7] = dig2[row+c] = true;
                solve(row+1);
                col[c] = dig1[row-c+7] = dig2[row+c] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
        }

        solve(0);

        pw.println(count);
        pw.flush();

    }
}
