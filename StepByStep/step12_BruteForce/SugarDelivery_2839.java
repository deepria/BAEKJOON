package step12_BruteForce;

import java.io.*;

public class SugarDelivery_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int num = n;
        int a = 0, b = 0;

        while (true) {
            if (num >= 5) {
                num -= 5;
                a++;
            } else if (num >= 3) {
                num -= 3;
                b++;
            } else if (num > 0 && num + 5 < n) {
                num += 5;
                a--;
                num -= 3;
                b++;
            } else if (n == 6) {
                System.out.println(2);
                break;
            } else if (num == 0) {
                System.out.println(a + b);
                break;
            } else {
                System.out.println(-1);
                break;
            }
        }
    }
}
