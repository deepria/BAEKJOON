package fs.dfs;

import util.Reader;

public class OrganicCabbage_1012 {

    static int[] dr = new int[] { -1, 0, 1, 0 };
    static int[] dc = new int[] { 0, 1, 0, -1 };
    static int[][] arr;
    static int w;
    static int h;

    static void dfs(int i, int j) {
        arr[i][j] = 2;

        for (int d = 0; d < 4; d++) {
            int temp_i = i + dr[d];
            int temp_j = j + dc[d];
            if (temp_i >= 0 && temp_i < h && temp_j >= 0 && temp_j < w && arr[temp_i][temp_j] == 1) {
                dfs(temp_i, temp_j);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();
        int t = in.nextInt();
        for (int cases = 0; cases < t; cases++) {
            w = in.nextInt();
            h = in.nextInt();
            arr = new int[h][w];
            int k = in.nextInt();
            for (int i = 0; i < k; i++) {
                int temp = in.nextInt();
                arr[in.nextInt()][temp] = 1;
            }
            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1) {
                        dfs(i, j);
                        answer += 1;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
