package step05_String;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class CharAndStr_27866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());
        br.close();

        bw.write(str.charAt(m - 1));

        bw.flush();
        bw.close();

    }

}