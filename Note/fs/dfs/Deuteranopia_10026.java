package fs.dfs;

import util.Reader;

public class Deuteranopia_10026 {

    static int[] dr = new int[] { -1, 0, 1, 0 };
    static int[] dc = new int[] { 0, 1, 0, -1 };
    static int[][] arr;
    static int[][] arr2;
    static int n;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        n = in.nextInt();
        arr = new int[n][n];
        arr2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char input = in.nextChar();
                arr[i][j] = input == 'R' ? 0 : input == 'G' ? 1 : 2;
                arr2[i][j] = arr[i][j] == 0 ? 1 : arr[i][j];
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < 3; x++) {
                    if (arr[i][j] == x) {
                        dfs(i, j, x);
                        answer += 1;
                    }
                }

            }
        }
        int answer2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 1; x < 3; x++) {
                    if (arr2[i][j] == x) {
                        dfs2(i, j, x);
                        answer2 += 1;
                    }
                }

            }
        }
        System.out.println(answer + " " + answer2);
    }

    static void dfs(int i, int j, int color) {
        arr[i][j] = 3;
        for (int d = 0; d < 4; d++) {
            int temp_i = i + dr[d];
            int temp_j = j + dc[d];
            if (temp_i >= 0 && temp_i < n && temp_j >= 0 && temp_j < n && arr[temp_i][temp_j] == color) {
                dfs(temp_i, temp_j, color);
            }
        }
    }

    static void dfs2(int i, int j, int color) {
        arr2[i][j] = 3;
        for (int d = 0; d < 4; d++) {
            int temp_i = i + dr[d];
            int temp_j = j + dc[d];
            if (temp_i >= 0 && temp_i < n && temp_j >= 0 && temp_j < n && arr2[temp_i][temp_j] == color) {
                dfs2(temp_i, temp_j, color);
            }
        }
    }
}
