package step10_GeometryRectanglesAndTriangles;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FourthPoint_3009 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int[] arrX = new int[3];
        int[] arrY = new int[3];

        for (int i = 0; i < 3; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            arrX[i] = Integer.parseInt(st.nextToken());
            arrY[i] = Integer.parseInt(st.nextToken());
        }

        int singleone = 0;

        for (int i = 0; i < 3; i++) {

            singleone = singleone ^ arrX[i];
        }

        bw.write(singleone + " ");

        singleone = 0;

        for (int i = 0; i < 3; i++) {

            singleone = singleone ^ arrY[i];

        }

        bw.write(singleone + " ");

        bw.flush();
        bw.close();
    }
}
