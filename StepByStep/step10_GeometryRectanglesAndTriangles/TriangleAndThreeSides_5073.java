package step10_GeometryRectanglesAndTriangles;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TriangleAndThreeSides_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String answer = "";

        while (a != 0 && b != 0 && c != 0) {

            answer = (a == b || a == c || b == c) ? "Isosceles" : answer;
            answer = (a != b && a != c && c != b) ? "Scalene" : answer;
            answer = (a == b && a == c) ? "Equilateral" : answer;
            answer = (a + b <= c || a + c <= b || b + c <= a) ? "Invalid" : answer;

            bw.write(answer + "\n");

            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

        }
        br.close();
        bw.flush();
        bw.close();

    }
}
