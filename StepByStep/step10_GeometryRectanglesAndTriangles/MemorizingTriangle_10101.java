package step10_GeometryRectanglesAndTriangles;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MemorizingTriangle_10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        br.close();

        String answer = "";

        answer = (a == b || a == c || b == c) ? "Isosceles" : answer;
        answer = (a != b && a != c && c != b) ? "Scalene" : answer;
        answer = (a == b && a == c) ? "Equilateral" : answer;
        answer = (a + b + c != 180) ? "Error" : answer;

        bw.write(answer + "");
        bw.flush();
        bw.close();

    }
}
