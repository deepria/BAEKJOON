package step07_TwoDimensionalArray;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;

public class ColorPaper_2563 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] area = new boolean[100][100];
        int cnt = 0;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (n > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = y; i < y + 10; i++) {

                for (int j = x; j < x + 10; j++) {
                    if (!area[i][j]) {
                        cnt++;
                        area[i][j] = true;
                    }
                }

            }
            n--;

        }
        br.close();

        bw.write(cnt + "");

        bw.flush();
        bw.close();

    }
}
