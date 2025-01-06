package step04_OneDimensionalArray;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class TurningOverBasket_10811 {

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

        for (int x = 0; x < m; x++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            int[] temp = new int[j - i + 1];

            for (int k = 0; k < temp.length; k++) {
                temp[k] = arr[i + k];
            }

            int o = (temp.length < 1) ? 0 : (temp.length - 1);

            for (int y = i; y <= j; y++) {

                arr[y] = temp[o];
                o--;
            }
        }

        br.close();

        for (int a : arr) {
            bw.write(a + " ");
        }

        bw.flush();
        bw.close();

    }

}