import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class RecursivePattern_2447 {
    static boolean[][] test;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        br.close();

        test = new boolean[n][n];

        star(n, 0, 0);

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test.length; j++) {

                bw.write(test[i][j] ? "*" : " ");
            }
            if (i != test.length - 1) {
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();

    }

    public static void star(int n, int x, int y) {
        if (n == 1) {
            test[x][y] = true;
            return;
        }

        int value = n / 3;
        int num = 0;

        for (int i = x; i < x + n; i += value) {
            for (int j = y; j < y + n; j += value) {
                num++;

                if (num == 5) {
                    test[i][j] = false;
                } else {
                    star(value, i, j);
                }
            }
        }
    }
}