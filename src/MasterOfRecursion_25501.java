import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MasterOfRecursion_25501 {

    public static void main(String[] args) throws IOException { 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {

            int[] is = isPalindrome(br.readLine());

            sb.append(is[0]).append(" ").append(is[1]).append("\n");

        }
        br.close();
        bw.write(sb + "");
        bw.flush();

    }

    public static int[] recursion(String s, int l, int r, int cnt) {
        int[] answer = new int[2];

        if (l >= r) {
            answer[0] = 1;
            answer[1] = cnt;
            return answer;
        } else if (s.charAt(l) != s.charAt(r)) {
            answer[0] = 0;
            answer[1] = cnt;
            return answer;
        } else {
            cnt++;
            return recursion(s, l + 1, r - 1, cnt);
        }
    }

    public static int[] isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1, 1);
    }
}