import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hulking_7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        StringBuilder sb = new StringBuilder();

        int[] temp = new int[2];
        int grade = 1;

        for (int i = 0; i < n; i++) {

            temp[0] = arr[i][0];
            temp[1] = arr[i][1];

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (temp[0] < arr[j][0] && temp[1] < arr[j][1]) {
                        grade++;
                    }
                }

            }
            sb.append(grade + " ");
            grade = 1;

        }

        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

}
