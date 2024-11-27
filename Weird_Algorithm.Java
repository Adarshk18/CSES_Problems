import java.util.*;


class Weird_Algorithm{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while(n!=1){
            System.out.print(n+ " ");
        if(n%2==0){
            n /=2;
        }else{
           n = 3*n+1;
        }
    }
        System.out.println(n);
    }
}