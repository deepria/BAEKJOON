package step13_Sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AgeSort_10814 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][2];

        StringTokenizer st;

        for (int i = 0; i < arr.length; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
        });

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < 2; j++) {
                bw.write(arr[i][j] + " ");
            }

            bw.write("\n");

        }

        bw.flush();
        bw.close();

    }

}