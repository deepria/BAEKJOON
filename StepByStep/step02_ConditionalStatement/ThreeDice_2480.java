package step02_ConditionalStatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThreeDice_2480 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int win = 0;

        if (a == b && a == c) {
            win = a * 1000 + 10000;

        } else if (a != b && a != c && b != c) {
            win = Math.max(Math.max(a, b), c) * 100;
        } else if (a == b && a != c) {
            win = a * 100 + 1000;

        } else if (a == c && a != b) {
            win = a * 100 + 1000;
        } else if (b == c && a != b) {
            win = b * 100 + 1000;
        }

        System.out.println(win);

    }
}
