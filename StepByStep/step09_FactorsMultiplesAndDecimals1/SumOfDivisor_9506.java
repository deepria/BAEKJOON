package step09_FactorsMultiplesAndDecimals1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SumOfDivisor_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        int n = Integer.parseInt(br.readLine());
        int sum;

        while (n != -1) {
            sum = 0;
            sb = new StringBuilder();
            sb.append(n + " = ");

            for (int i = 1; i <= n/2; i++) {
                
                if (n % i == 0 && sum < n / 2) {
                    sum += i;
                    sb.append(i + " + ");
                } else if (n % i == 0 && sum >= n / 2) {
                    sum += i;
                    sb.append(i + "\n");
                    
                }
            }
            if (sum == n) {
                bw.write(sb + "");
            } else {
                bw.write(n+" is NOT perfect.\n");
            }
          
            n = Integer.parseInt(br.readLine());

        }
        br.close();
        bw.flush();
        bw.close();

    }
}
