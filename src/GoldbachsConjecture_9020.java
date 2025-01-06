import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachsConjecture_9020 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < t; x++) {

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n + 1];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            arr[0] = 0;
            if (arr.length > 1) {
                arr[1] = 0;
            }
            if (arr.length > 4) {
                arr[4] = 0;
            }

            for (int i = 2; i * i < n; i++) {

                if (arr[i] != 0) {

                    for (int j = i * i; j <= n; j += i) {
                        arr[j] = 0;
                    }
                }
            }
            int a = 0;
            int b = 0;

            for (int i = arr.length / 2; i < arr.length; i++) {

                if (arr[i] != 0) {

                    a = arr[i];

                    for (int j = (arr.length - 1) / 2; j > 0; j--) {

                        if (arr[j] != 0) {

                            if (arr[j] + a == n) {

                                b = arr[j];
                                sb.append(b + " " + a + "\n");
                                break;
                            }
                        }
                    }
                    if (b != 0) {
                        break;
                    }
                }

            }

        }

        System.out.println(sb);
        br.close();

    }
}