import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MelonField_2477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int melon = Integer.parseInt(br.readLine());

        int[][] arr = new int[7][2];

        StringTokenizer st;

        int maxX = 0;
        int maxY = 0;

        int x = 0;
        int y = 0;

        for (int i = 1; i < 7; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if ((arr[i][0] == 1 || arr[i][0] == 2) && arr[i][1] > maxX) {
                maxX = arr[i][1];
                x = i;
            } else if ((arr[i][0] == 3 || arr[i][0] == 4) && arr[i][1] > maxY) {
                maxY = arr[i][1];
                y = i;
            }

        }

        int answer = maxX * maxY;

        if (x > 3) {
            x -= 3;
        } else {
            x += 3;
        }
        if (y > 3) {
            y -= 3;
        } else {
            y += 3;
        }

        answer = answer - arr[x][1] * arr[y][1];

        bw.write(answer * melon + "");

        bw.flush();
        bw.close();
    }
}
