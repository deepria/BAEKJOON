import java.io.*;
import java.util.*;

public class FindingTheSumOfIntervals5_11660 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] sumArr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= n; j++) {

                sumArr[i][j] = (j == 1) ? Integer.parseInt(st.nextToken())
                        : sumArr[i][j - 1] + Integer.parseInt(st.nextToken());
            }

        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int answer = 0;

            for (int j = y1; j <= y2; j++) {

                answer += sumArr[j][x2] - sumArr[j][x1 - 1];

            }

            bw.write(answer + "\n");

        }

        br.close();

        bw.flush();
        bw.close();

    }

}