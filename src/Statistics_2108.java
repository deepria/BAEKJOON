import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Statistics_2108 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        br.close();

        int[] countArr = new int[8001];

        for (int i = 0; i < n; i++) {
            countArr[arr[i] + 4000]++;
        }

        int cnt = 0;
        int max = 0;
        boolean flag = false;

        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 0) {

                if (countArr[i] > cnt) {
                    cnt = countArr[i];
                    max = i;
                    flag = true;
                } else if (countArr[i] == cnt && flag == true) {

                    max = i;
                    flag = false;

                }
            }

        }

        for (int i = 1; i < countArr.length; i++) {

            countArr[i] += countArr[i - 1];
        }

        int[] answer = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int var = arr[i] + 4000;
            countArr[var]--;
            answer[countArr[var]] = var;

        }

        bw.write(Math.round((double) sum / (double) n) + "\n");
        bw.write(answer[n / 2] - 4000 + "\n");
        bw.write(max - 4000 + "\n");
        bw.write(answer[answer.length - 1] - answer[0] + "\n");

        bw.flush();
        bw.close();

    }

}