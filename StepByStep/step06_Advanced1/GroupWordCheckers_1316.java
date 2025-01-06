package step06_Advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupWordCheckers_1316 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int cnt = t;

        for (int i = 0; i < t; i++) {

            boolean is = true;

            String[] arr = br.readLine().split("");

            for (int j = 0; j < arr.length; j++) {

                for (int j2 = 1; j2 < arr.length; j2++) {
                    if (arr[j].equals(arr[j2]) && j < j2) {
                        if (!arr[j2].equals(arr[j2 - 1])) {
                            is = false;
                        }
                    }

                }

            }

            if (is == false) {
                cnt--;
            }

        }

        System.out.println(cnt);
    }

}
