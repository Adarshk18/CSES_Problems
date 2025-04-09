import java.util.Scanner;

public final class  IdealGenerator{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i=0; i<t; i++){
            int k = in.nextInt();
            if(k%2==1 || k==1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        in.close();
    }
}