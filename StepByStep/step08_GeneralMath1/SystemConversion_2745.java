package step08_GeneralMath1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SystemConversion_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String num = st.nextToken();
        int jin = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i < num.length(); i++) {
            if (jin > 10) {
                answer += (int) ((num.charAt(i) > 57) ? ((num.charAt(i) - 55) * Math.pow(jin, num.length() - 1 - i))
                        : ((num.charAt(i) - 48) * Math.pow(jin, num.length() - 1 - i)));
            } else {
                answer += (int) ((num.charAt(i) - 48) * Math.pow(jin, num.length() - 1 - i));
            }
        }
        System.out.println(answer);
    }
}
