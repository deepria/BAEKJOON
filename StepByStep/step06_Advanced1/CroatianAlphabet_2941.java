package step06_Advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CroatianAlphabet_2941 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
        String st = br.readLine();

        int cnt = 0;

        for (int j = 0; j < 100; j++) {

            for (int i = 0; i < arr.length; i++) {
                if (st.contains(arr[i])) {
                    cnt++;
                    st = st.replaceFirst(arr[i], " ");
                    break;

                }
            }

        }

        st = st.replaceAll(" ", "");

        cnt += st.length();

        System.out.println(cnt);
    }

}
