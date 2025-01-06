import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FindSavedNumOfMergeSortByCount_24060 {
    static long cnt = 0;
    static int[] temp = new int[500001];
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        merge_sort(arr, 0, n - 1, k);

        if (cnt >= k) {
            bw.write(answer + "");

        } else {
            bw.write(-1 + "");
        }

        bw.flush();
        bw.close();

    }

    public static void merge_sort(int[] arr, int left, int right, int k) {

        if (right - left == 0) {
            return;
        }

        int mid = (left + right) / 2;
        merge_sort(arr, left, mid, k);
        merge_sort(arr, mid + 1, right, k);

        merge(arr, left, right, mid, k);
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

    }

    public static void merge(int[] arr, int left, int right, int mid, int k) {

        int t = left;
        int l = left;
        int m = mid + 1;

        while (l <= mid && m <= right) {
            if (arr[l] <= arr[m]) {
                cnt++;
                temp[t++] = arr[l++];
                if (cnt == k) {
                    answer = temp[t - 1];
                }

            } else {
                cnt++;
                temp[t++] = arr[m++];
                if (cnt == k) {
                    answer = temp[t - 1];
                }

            }

        }

        while (l <= mid) {
            cnt++;
            temp[t++] = arr[l++];
            if (cnt == k) {
                answer = temp[t - 1];
            }

        }

        while (m <= right) {
            cnt++;
            temp[t++] = arr[m++];
            if (cnt == k) {
                answer = temp[t - 1];
            }

        }

    }

}
