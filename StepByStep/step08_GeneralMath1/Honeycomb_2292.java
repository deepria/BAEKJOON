package step08_GeneralMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Honeycomb_2292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int min = 1;
        int max = 1;
        int val = 1;

        for (int i = 1; max <= 2000000000; i++) {
            if (min <= a && a <= max) {
                System.out.println(val);
                break;
            }
            min = max + 1;
            max = max + i * 6;
            val++;
        }
    }
}

