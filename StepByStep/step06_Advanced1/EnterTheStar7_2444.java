package step06_Advanced1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterTheStar7_2444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = "";
            for (int j = 0; j < n + i; j++) {
                arr[i] += j >= n - i - 1 ? "*" : " ";
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + "\n");
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            sb.append(arr[i] + "\n");
        }

        System.out.println(sb);
    }
}
