package step12_BruteForce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MathIsNonFaceToFaceLecture_19532 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;
        boolean isEnd = false;

        for (int i = -999; i <= 999; i++) {
            x = i;
            for (int j = -999; j <= 999; j++) {
                y = j;
                if ((a * x + b * y == c) && (d * x + e * y == f)) {
                    isEnd = true;
                    break;
                }
            }
            if (isEnd) {
                break;
            }

        }
        bw.write(x + " " + y);
        bw.flush();
        bw.close();
    }

}
