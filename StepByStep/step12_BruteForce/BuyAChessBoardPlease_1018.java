package step12_BruteForce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BuyAChessBoardPlease_1018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][m];

        for (int i = 0; i < n; i++) {

            String[] temp = br.readLine().split("");

            for (int j = 0; j < m; j++) {

                arr[i][j] = temp[j];

            }
        }

        String color = "B";
        int bool = 0;
        int cnt = 0;
        int answer = 0;
        int answer2 = Integer.MAX_VALUE;

        for (int i = 0; i <= n - 8; i++) {

            for (int j = 0; j <= m - 8; j++) {

                for (int i2 = i; i2 < i + 8; i2++) {

                    for (int j2 = j; j2 < j + 8; j2++) {

                        if (bool == 0 && arr[i2][j2].equals(color)) {
                            bool = 1;

                        } else if (bool == 1 && arr[i2][j2].equals(color)) {
                            cnt++;
                            bool = 0;

                        } else if (bool == 1 && !arr[i2][j2].equals(color)) {
                            bool = 0;

                        } else if (bool == 0 && !arr[i2][j2].equals(color)) {
                            cnt++;
                            bool = 1;

                        } else if (bool == 2 && arr[i2][j2].equals(color)) {
                            cnt++;
                            bool = 3;

                        } else if (bool == 3 && arr[i2][j2].equals(color)) {
                            bool = 2;

                        } else if (bool == 3 && !arr[i2][j2].equals(color)) {
                            cnt++;
                            bool = 2;

                        } else if (bool == 2 && !arr[i2][j2].equals(color)) {
                            bool = 3;
                        }

                    }

                    if (bool == 0 || bool == 1) {
                        bool = 2;
                    } else {
                        bool = 0;
                    }

                    answer += cnt;
                    cnt = 0;

                }

                if (answer2 > answer) {
                    answer2 = answer;
                }

                answer = 0;
            }
        }

        color = "W";

        for (int i = 0; i <= n - 8; i++) {

            for (int j = 0; j <= m - 8; j++) {

                for (int i2 = i; i2 < i + 8; i2++) {

                    for (int j2 = j; j2 < j + 8; j2++) {

                        if (bool == 0 && arr[i2][j2].equals(color)) {
                            bool = 1;

                        } else if (bool == 1 && arr[i2][j2].equals(color)) {
                            cnt++;
                            bool = 0;

                        } else if (bool == 1 && !arr[i2][j2].equals(color)) {
                            bool = 0;

                        } else if (bool == 0 && !arr[i2][j2].equals(color)) {
                            cnt++;
                            bool = 1;

                        } else if (bool == 2 && arr[i2][j2].equals(color)) {
                            cnt++;
                            bool = 3;

                        } else if (bool == 3 && arr[i2][j2].equals(color)) {
                            bool = 2;

                        } else if (bool == 3 && !arr[i2][j2].equals(color)) {
                            cnt++;
                            bool = 2;

                        } else if (bool == 2 && !arr[i2][j2].equals(color)) {
                            bool = 3;
                        }

                    }

                    if (bool == 0 || bool == 1) {
                        bool = 2;
                    } else {
                        bool = 0;
                    }

                    answer += cnt;
                    cnt = 0;

                }

                if (answer2 > answer) {
                    answer2 = answer;
                }

                answer = 0;
            }
        }

        bw.write(answer2 + "");
        bw.flush();
        bw.close();
    }

}
