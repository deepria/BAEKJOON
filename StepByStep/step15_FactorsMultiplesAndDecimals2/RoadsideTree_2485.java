package step15_FactorsMultiplesAndDecimals2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RoadsideTree_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp = Integer.parseInt(br.readLine());
            map.put(temp - num, map.get(temp - num) == null ? 1 : map.get(temp - num) + 1);
            num = temp;
        }
        br.close();
        if (map.keySet().size() == 1) {
            bw.write(0 + "");
        } else {
            Integer gcd = Collections.min(map.keySet());
            for (Integer i : map.keySet()) {
                gcd = GCD(gcd, i);
            }
            int answer = 0;
            if (gcd == 1) {
                for (Integer i : map.keySet()) {
                    answer += (i - 1) * map.get(i);
                }
                bw.write(answer + "");
            } else {
                for (Integer i : map.keySet()) {
                    if (i == gcd) {
                        continue;
                    } else {
                        answer += (i - gcd) / gcd * map.get(i);
                    }
                }
                bw.write(answer + "");
            }
        }
        bw.flush();
        bw.close();

    }

    static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

}
