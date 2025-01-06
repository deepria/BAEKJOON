package step12_BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FilmDirectorShom_1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int num = 666;
        boolean bool = true;

        for (int i = 0; i < n; i++) {

            String numStr = Integer.toString(num);
            int numLength = numStr.length();
            int lastIndex = numStr.lastIndexOf("666");
            int firstIndex = numStr.indexOf("666");

            if (lastIndex + 3 == numLength && firstIndex + 3 == numLength && bool == true && i != 0
                    && Integer.toString(num + 1000).indexOf("666") + 3 < numLength
                    && Integer.toString(num + 1000).indexOf("666") != -1) {
                num += 994;
                bool = false;
                if (Integer.toString(num + 10).indexOf("666") + 3 < numLength
                        && Integer.toString(num + 10).indexOf("666") != -1) {

                    for (int j = 1; j < numLength - (Integer.toString(num).indexOf("666") + 3); j++) {
                        num = num - 6 * (int) (Math.pow(10, j));
                    }
                }
            }

            if (lastIndex + 3 == numLength && firstIndex + 3 == numLength && bool == true && i != 0) {
                num += 1000;

            }
            if (firstIndex + 3 < numLength && bool == false) {
                num += 1;

                if (Integer.toString(num).indexOf("666") == -1) {
                    if (Integer.toString(num - 1).lastIndexOf("9") + 1 == numLength) {

                        for (int j = 1; j < numLength - (firstIndex + 3); j++) {
                            num = num - 3 * (int) (Math.pow(10, j));
                        }
                    }
                    num -= 4;
                    num += 1000;
                    bool = true;

                }

            }

            System.out.println("i: " + i + "  num: " + num + "  bool: " + bool);

        }

        bw.write(num + "");
        bw.flush();
        bw.close();
    }

}
