package step07_TwoDimensionalArray;
import java.io.*;
import java.util.StringTokenizer;

public class ArrPlus_2738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());

            }

        }
        br.close();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                System.out.print((a[i][j] + b[i][j]));
                if (j != m - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
