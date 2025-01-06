package fs.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AddingJarNum_2667 {

    static int[] dr = new int[] { -1, 0, 1, 0 };
    static int[] dc = new int[] { 0, 1, 0, -1 };
    static int[][] arr;
    static int n;
    static int cnt;

    static void dfs(int i, int j) {
        arr[i][j] = 2;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int temp_i = i + dr[d];
            int temp_j = j + dc[d];
            if (temp_i >= 0 && temp_i < n && temp_j >= 0 && temp_j < n && arr[temp_i][temp_j] == 1) {
                dfs(temp_i, temp_j);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(in[j]);
            }
        }

        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    answer += 1;
                    if (cnt != 0) {
                        list.add(cnt);
                    }
                }

            }
        }
        Collections.sort(list);
        sb.append(answer).append("\n");
        for (int n : list) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }
}