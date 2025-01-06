package step05_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dial_5622 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split("");

        int t = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("A") || arr[i].equals("B") || arr[i].equals("C")) {
                t += 3;
            } else if (arr[i].equals("D") || arr[i].equals("E") || arr[i].equals("F")) {
                t += 4;
            } else if (arr[i].equals("G") || arr[i].equals("H") || arr[i].equals("I")) {
                t += 5;
            } else if (arr[i].equals("J") || arr[i].equals("K") || arr[i].equals("L")) {
                t += 6;
            } else if (arr[i].equals("M") || arr[i].equals("N") || arr[i].equals("O")) {
                t += 7;
            } else if (arr[i].equals("P") || arr[i].equals("Q") || arr[i].equals("R") || arr[i].equals("S")) {
                t += 8;
            } else if (arr[i].equals("T") || arr[i].equals("U") || arr[i].equals("V")) {
                t += 9;
            } else if (arr[i].equals("W") || arr[i].equals("X") || arr[i].equals("Y") || arr[i].equals("Z")) {
                t += 10;
            }
        }

        System.out.println(t);
    }

}
