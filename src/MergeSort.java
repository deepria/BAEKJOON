import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MergeSort {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr);

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + " ");

        }

        br.close();

        bw.flush();
        bw.close();

    }

    public static void merge_sort(int[] arr) {

        sort(arr, 0, arr.length);

    }

    public static void sort(int[] arr, int left, int right) {

        if (right - left < 2) {
            return;

        }

        int mid = (left + right) / 2;
        sort(arr, 0, mid);
        sort(arr, mid, right);

        merge(arr, left, mid, right);

    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left];
        int t = 0;
        int l = left;
        int m = mid;

        while (l < mid && m < right) {
            if (arr[l] < arr[m]) {
                temp[t++] = arr[l++];

            } else
                temp[t++] = arr[m++];

        }

        while (l < mid) {
            temp[t++] = arr[l++];
        }

        while (m < right) {
            temp[t++] = arr[m++];
        }

        for (int i = left; i < right; i++) {
            arr[i] = temp[i - left];
        }

    }

}
