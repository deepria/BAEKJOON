package step01_inputOutputOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiplication_2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        int intb = Integer.parseInt(b);

        String[] arrb = b.split("");

        System.out.println(a * Integer.parseInt(arrb[2]));
        System.out.println(a * Integer.parseInt(arrb[1]));
        System.out.println(a * Integer.parseInt(arrb[0]));
        System.out.println(a * intb);
    }
}
