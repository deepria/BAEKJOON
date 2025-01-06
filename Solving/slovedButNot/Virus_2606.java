package slovedButNot;

import util.Reader;

public class Virus_2606 {

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int n = in.nextInt();
        int t = in.nextInt();
        boolean[] arr = new boolean[n + 1];
        int[][] cases = new int[t][2];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 2; j++) {
                cases[i][j] = in.nextInt();
            }
            arr[cases[i][1]] = cases[i][0] == 1 ? true : arr[cases[i][1]];
        }
        for (int x = 0; x < n; x++) {
            for (int i = 0; i < t; i++) {
                arr[cases[i][1]] = arr[cases[i][0]] ? true : arr[cases[i][1]];
                arr[cases[i][0]] = arr[cases[i][1]] ? true : arr[cases[i][0]];
            }
        }

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            cnt += arr[i] ? 1 : 0;
        }
        System.out.println(cnt);

    }

}