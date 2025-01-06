package step03_Loop;
import java.io.*;
import java.util.*;

public class CodingIsSport_25314 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();
        
        String answer = "";
        for (int i = 0; i < n/4; i++) {
            answer += "long ";            
        }        
        answer += "int";
        bw.write(answer);
        bw.flush();
        bw.close();

    }

}