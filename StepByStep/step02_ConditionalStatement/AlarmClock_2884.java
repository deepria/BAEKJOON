package step02_ConditionalStatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlarmClock_2884 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int changyoungH = 0;
        int changyoungM = 0;

        if (m < 45) {
            changyoungH = h - 1;
            changyoungM = m + 15;
            if (h == 0) {
                changyoungH = 23;
            }

        } else {
            changyoungH = h;
            changyoungM = m - 45;
        }

        System.out.print(changyoungH + " " + changyoungM);

    }
}
