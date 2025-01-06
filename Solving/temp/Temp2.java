package temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split("");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        String temp = "";
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            if (sb.charAt(sb.length() - 1) == (temp.charAt(0))) {
                cnt++;
            } else {
                sb.append(cnt);
                cnt = 1;
                sb.append(temp);
            }
        }
        if (cnt != 1)
            sb.append(cnt);

        System.out.println(sb);
    }

}
