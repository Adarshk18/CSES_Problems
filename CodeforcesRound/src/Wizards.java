import java.io.*;
import java.util.*;

public class Wizards {
    static int countInversions(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);
            invCount += merge(arr, temp, left, mid, right);
        }
        return invCount;
    }

    static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left, invCount = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (i = left; i <= right; i++) arr[i] = temp[i];
        return invCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int minInversions = countInversions(a.clone());
            int bestL = 1, bestR = 1; // 1-based indexing

            for (int l = 0; l < n; l++) {
                for (int r = Math.min(n - 1, l + 10); r < n; r++) { // **Optimization**
                    int[] temp = a.clone();

                    // Apply cyclic shift on [l, r]
                    int first = temp[l];
                    for (int i = l; i < r; i++) {
                        temp[i] = temp[i + 1];
                    }
                    temp[r] = first;

                    int newInversions = countInversions(temp);
                    if (newInversions < minInversions) {
                        minInversions = newInversions;
                        bestL = l + 1; // Convert to 1-based index
                        bestR = r + 1; // Convert to 1-based index
                    }
                }
            }

            pw.println(bestL + " " + bestR);
        }

        pw.flush();
    }
}
