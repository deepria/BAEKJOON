import java.io.*;
import java.util.*;

public class sequence_2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int sum = 0;
        int temp = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i <= k) {
                sum += arr[i];
            }

        }

        br.close();

        max = sum;

        for (int i = 1 + k; i < arr.length; i++) {
            temp = sum + arr[i] - arr[i - k];
            if (temp > max) {
                max = temp;
            }
            sum = temp;
            temp = 0;
        }

        bw.write(max + "");

        bw.flush();
        bw.close();
    }
}