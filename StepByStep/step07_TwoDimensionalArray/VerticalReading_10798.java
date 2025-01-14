package step07_TwoDimensionalArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VerticalReading_10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] arr = new String[5][15];

        for (int i = 0; i < 5; i++) {

            String[] temp = br.readLine().split("");

            for (int j = 0; j < 15; j++) {

                arr[i][j] = j > temp.length - 1 ? "#" : temp[j];

            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                sb.append(arr[j][i] == "#" ? "" : arr[j][i]);
            }
        }

        System.out.println(sb);

    }
}
