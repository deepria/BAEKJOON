import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class IHatePaper {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(br.readLine());

        int[][] arr = new int[p][2];

        StringTokenizer st;

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < p; i++) {

            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j]);
                if (j != 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }

        int x = arr[0][0];
        int y = arr[0][1];
        int minH = arr[0][1];
        int maxH = 0;
        int area = 100;

        for (int i = 1; i < p; i++) {

            if (arr[i][0] == x && arr[i][1] == y) {

            } else if (arr[i][0] == x) {

                area += (arr[i][1] - y) * 10;
                y = arr[i][1];
                maxH = arr[i][1] + 10;

            } else if (arr[i][0] > x && arr[i][0] < x + 10) {

                if (arr[i][1] >= maxH) {

                    area += ((x + 10 - arr[i][0]) * (arr[i][1] - maxH));

                } else if (minH >= arr[i][1]) {

                    area += ((x + 10 - arr[i][0]) * (minH - arr[i][1]));

                }
            }

        }

        System.out.println(area);

    }
}
