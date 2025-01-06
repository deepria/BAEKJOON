import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BubbleSortAndMergeSort_1517 {
    static long cnt = 0;
    static int[] temp = new int[500001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        merge_sort(arr, 0, n - 1);

        /*
         * for (int i = 0; i < arr.length; i++) {
         * bw.write(arr[i] + " ");
         * }
         */

        bw.write(cnt + "");

        bw.flush();
        bw.close();

    }

    public static void merge_sort(int[] arr, int left, int right) {

        if (right - left == 0) {
            return;
        }

        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);

        merge(arr, left, right, mid);
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

    }

    public static void merge(int[] arr, int left, int right, int mid) {

        int t = left;
        int l = left;
        int m = mid + 1;

        while (l <= mid && m <= right) {
            if (arr[l] <= arr[m]) {
                temp[t++] = arr[l++];

            } else {
                cnt += m - t;
                temp[t++] = arr[m++];
            }

        }

        while (l <= mid) {
            temp[t++] = arr[l++];
        }

        while (m <= right) {
            temp[t++] = arr[m++];
        }

    }

}
