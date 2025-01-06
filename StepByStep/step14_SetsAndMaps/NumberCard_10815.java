package step14_SetsAndMaps;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard_10815 {

    static int[] nArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        nArr = new int[n];

        for (int i = 0; i < nArr.length; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {

            int num = Integer.parseInt(st.nextToken());

            bw.write(binarySearch(num, 0, n - 1) + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    static int binarySearch(int key, int low, int high) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (key == nArr[mid]) {
                return 1;
            } else if (key < nArr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 0; // 탐색 실패
    }

}
