package dp;

import java.io.InputStreamReader;
import java.util.Scanner;

public class MakeItOne_1463 {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int n = in.nextInt();

        int[] dy = new int[n + 1];
        dy[0] = 0;
        dy[1] = 0;
        for (int i = 2; i < dy.length; i++) {
            if (i % 6 == 0) {
                dy[i] = Math.min(dy[i / 3] + 1, dy[i / 2] + 1);
            } else if (i % 3 == 0) {
                dy[i] = Math.min(dy[i / 3] + 1, dy[i - 1] + 1);
            } else if (i % 2 == 0) {
                dy[i] = Math.min(dy[i / 2] + 1, dy[i - 1] + 1);
            } else
                dy[i] = dy[i - 1] + 1;
        }
        System.out.println(dy[n]);
    }
}
