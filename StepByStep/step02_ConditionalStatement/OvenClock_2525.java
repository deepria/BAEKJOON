package step02_ConditionalStatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OvenClock_2525 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        int afterH = 0;
        int afterM = 0;

        if (m + time < 60) {
            afterH = h;
            afterM = m + time;

        } else {
            afterH = h + (int) ((double) ((m + time) / 60));
            afterM = (m + time) % 60;
        }

        if (afterH >= 24) {
            afterH = afterH % 24;
        }

        System.out.println(afterH + " " + afterM);

    }
}
