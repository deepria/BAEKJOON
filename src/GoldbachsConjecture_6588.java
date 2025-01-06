import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GoldbachsConjecture_6588 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[1000001];

        for (int i = 2; i * i <= arr.length - 1; i++) {
            if (!arr[i]) {
                for (int j = i + i; j <= arr.length - 1; j += i) {
                    arr[j] = true;
                }
            }
        }

        arr[0] = true;
        arr[1] = true;
        arr[2] = true;

        int n = Integer.parseInt(br.readLine());

        while (n != 0) {

            int a = 0;
            int b = 0;

            for (int i = 0; i < arr.length; i++) {

                if (!arr[i]) {

                    a = i;

                    if (!arr[n - a]) {

                        b = n - a;
                        bw.write(n + " = " + a + " + " + b + "\n");

                        break;

                    }

                }

            }

            n = Integer.parseInt(br.readLine());

        }
        br.close();

        bw.flush();
        bw.close();

    }
}