package step05_String;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class LengthOfStr_2743 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        br.close();

        bw.write(str.length() + "");

        bw.flush();
        bw.close();

    }

}