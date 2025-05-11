import java.util.*;

class QuartetSwapping {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }


            List<Integer> evenIndexValues = new ArrayList<>();
            List<Integer> oddIndexValues = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    evenIndexValues.add(a[i]);
                } else {
                    oddIndexValues.add(a[i]);
                }
            }


            Collections.sort(evenIndexValues);
            Collections.sort(oddIndexValues);


            int evenPtr = 0, oddPtr = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    System.out.print(evenIndexValues.get(evenPtr++) + " ");
                } else {
                    System.out.print(oddIndexValues.get(oddPtr++) + " ");
                }
            }
            System.out.println();
        }


    }
}
