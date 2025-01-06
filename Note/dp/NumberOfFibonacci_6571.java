package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class NumberOfFibonacci_6571 {

    static BigInteger[] arr = new BigInteger[481];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        fib_dp();
        while (!a.equals("0") == true || !b.equals("0") == true) {

            BigInteger tmpA = new BigInteger(a);
            BigInteger tmpB = new BigInteger(b);
            int point_A = 0;
            int point_B = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].compareTo(tmpA) < 0) {
                    point_A = i;
                }
                if (arr[i].compareTo(tmpB) <= 0) {
                    point_B = i;
                }

            }

            st = new StringTokenizer(br.readLine());
            bw.write(point_B - point_A + "\n");
            a = st.nextToken();
            b = st.nextToken();
        }
        br.close();
        bw.flush();
        bw.close();

    }

    static void fib_dp() {
        arr[0] = new BigInteger("0");
        arr[1] = new BigInteger("1");
        arr[2] = new BigInteger("2");
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
    }
}