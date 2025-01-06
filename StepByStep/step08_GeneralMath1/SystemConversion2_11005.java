package step08_GeneralMath1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SystemConversion2_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int jin = Integer.parseInt(st.nextToken());
        String str = Integer.toString(num, jin);

        System.out.println(str.toUpperCase());
    }
}
