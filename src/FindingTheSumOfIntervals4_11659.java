import java.io.*;
import java.util.*;

public class FindingTheSumOfIntervals4_11659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] sumArr = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = (i == 1) ? arr[i] : sumArr[i - 1] + arr[i];

        }

        for (int x = 0; x < m; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            bw.write(sumArr[j] - sumArr[i - 1] + "\n");
        }

        br.close();

        bw.flush();
        bw.close();

    }

}