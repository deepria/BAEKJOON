package step06_Advanced1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class YourRatingIs_25206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double hsum = 0.0;
        double psum = 0.0;
        double h = 0.0;
        double p = 0.0;

        StringTokenizer st;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String g = st.nextToken();
            h = Double.parseDouble(st.nextToken());

            switch (st.nextToken()) {
                case "A+":
                    p = 4.5;
                    hsum += h;
                    psum += (h * p);
                    break;
                case "A0":
                    p = 4.0;
                    hsum += h;
                    psum += (h * p);
                    break;
                case "B+":
                    p = 3.5;
                    hsum += h;
                    psum += (h * p);
                    break;
                case "B0":
                    p = 3.0;
                    hsum += h;
                    psum += (h * p);
                    break;
                case "C+":
                    p = 2.5;
                    hsum += h;
                    psum += (h * p);
                    break;
                case "C0":
                    p = 2.0;
                    hsum += h;
                    psum += (h * p);
                    break;
                case "D+":
                    p = 1.5;
                    hsum += h;
                    psum += (h * p);
                    break;
                case "D0":
                    p = 1.0;
                    hsum += h;
                    psum += (h * p);
                    break;
                case "F":
                    p = 0.0;
                    hsum += h;
                    psum += (h * p);
                    break;
                case "P":
                    break;
            }
        }
        System.out.println(psum / hsum);
    }
}
