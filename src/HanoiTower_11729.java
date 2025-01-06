import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HanoiTower_11729 {
    private static final StringBuilder sb = new StringBuilder();

    public static void printTop(int n, int a, int b, int c) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
        } else {
            printTop(n - 1, a, c, b);
            sb.append(a).append(" ").append(b).append("\n");
            printTop(n - 1, c, b, a);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        sb.append((int) (Math.pow(2, n) - 1)).append("\n");
        printTop(n, 1, 3, 2);

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }
}