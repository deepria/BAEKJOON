package step13_Sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BubbleSort_2750 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        br.close();

        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {

                    swap(arr, j, j + 1);

                }
            }

        }

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + "");
        }

        bw.flush();
        bw.close();

    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}