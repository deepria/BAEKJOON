import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TheLittlePrince_1004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int c = 0; c < t; c++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            int cX = 0;
            int cY = 0;
            int r = 0;

            int cnt = 0;

            for (int i = 0; i < n; i++) {

                st = new StringTokenizer(br.readLine(), " ");

                cX = Integer.parseInt(st.nextToken());
                cY = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());

                if ((Math.pow(Math.abs(cX - x1), 2) + Math.pow(Math.abs(cY - y1), 2) < Math.pow(r, 2))
                        && (Math.pow(Math.abs(cX - x2), 2) + Math.pow(Math.abs(cY - y2), 2) > Math.pow(r, 2))) {
                    cnt++;
                }

                if ((Math.pow(Math.abs(cX - x2), 2) + Math.pow(Math.abs(cY - y2), 2) < Math.pow(r, 2))
                        && (Math.pow(Math.abs(cX - x1), 2) + Math.pow(Math.abs(cY - y1), 2) > Math.pow(r, 2))) {
                    cnt++;
                }
            }

            bw.write(cnt + "\n");

        }

        br.close();

        bw.flush();
        bw.close();
    }
}
