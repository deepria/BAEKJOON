package step04_OneDimensionalArray;
import java.io.*;
import java.util.*;

public class ChangeBall_10813 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int temp = 0;

        for (int x = 0; x < m; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        br.close();

        for (int a : arr) {
            bw.write(a + " ");
        }

        bw.flush();
        bw.close();

    }

}