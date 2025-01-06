package step10_GeometryRectanglesAndTriangles;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TheEarth_9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int wl = 10000;
        int wh = -10000;
        int hl = 10000;
        int hh = -10000;

        int inputw;
        int inputh;

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            inputw = Integer.parseInt(st.nextToken());
            inputh = Integer.parseInt(st.nextToken());

            wl = inputw < wl ? inputw : wl;
            wh = inputw > wh ? inputw : wh;
            hl = inputh < hl ? inputh : hl;
            hh = inputh > hh ? inputh : hh;

        }

        bw.write((wh - wl) * (hh - hl) + "");
        bw.flush();
        bw.close();

    }
}
