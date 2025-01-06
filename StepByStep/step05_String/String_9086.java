package step05_String;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class String_9086 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = "";

        for (int i = 0; i < n; i++) {

            str = br.readLine();

            bw.write(str.charAt(0) + "" + str.charAt((str.length() - 1)) + "\n");

        }
        br.close();
        bw.flush();
        bw.close();

    }

}