import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci_10870 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] x = { 0, 1 };

        bw.write(Fibonacci(n, x) + "");

        bw.flush();
        bw.close();

    }

    public static int Fibonacci(int n, int[] x) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int temp = x[0];
        x[0] = x[1];
        x[1] = temp + x[1];

        n--;

        if (n != 2) {
            return Fibonacci(n, x);

        }

        return x[0] + x[1];
    }

}
