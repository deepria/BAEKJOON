package step06_Advanced1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Palindrome_10988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] arr = str.split("");
        String[] temp = arr.clone();

        List<String> list = Arrays.asList(temp);
        Collections.reverse(list);

        int answer = 1;

        for (int i = 0; i < arr.length; i++) {
            if (!(arr[i].equals(temp[i]))) {
                answer = 0;
                break;
            }
        }

        System.out.println(answer);
    }
}
