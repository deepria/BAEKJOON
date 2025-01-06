package step07_TwoDimensionalArray;

import java.io.*;
import java.util.StringTokenizer;

public class MaximumValue_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int[][] arr = new int[9][9];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        int max = 0, a = 0, b = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {
                if (max <= arr[i][j]) {
                    max = arr[i][j];
                    a = i + 1;
                    b = j + 1;
                }

            }

        }

        System.out.println(max);
        System.out.print(a + " " + b);

    }
}
