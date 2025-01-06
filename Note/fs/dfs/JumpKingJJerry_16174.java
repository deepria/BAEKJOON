package fs.dfs;

import java.io.InputStreamReader;
import java.util.Scanner;

public class JumpKingJJerry_16174 {

    static int[][] arr;
    static int n;
    static boolean is = false;

    static void dfs(int i, int j) {
        if (i < n && j < n && !is) {
            if (i == n - 1 && j == n - 1) {
                is = true;
            }
            if (arr[i][j] != 0 && arr[i][j] < n) {
                if (arr[i][j] + j < n && !is && arr[i][j + arr[i][j]] != 0) {
                    dfs(i, j + arr[i][j]);
                }
                if (arr[i][j] + i < n && !is && arr[i + arr[i][j]][j] != 0) {
                    dfs(i + arr[i][j], j);
                } else {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        n = in.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        dfs(0, 0);

        System.out.println(is ? "HaruHaru" : "Hing");
    }
}

/*
 * C++20 iktk님 코드 (튜플덱과 비트셋을 이용한 재귀없는 풀이)
 * 
 * #include <bits/stdc++.h>
 * using namespace std;
 * #define int long long
 * 
 * int v[64][64];
 * bitset<64>bs[64];
 * signed main(){
 * //---------------
 * #ifdef ONLINE_JUDGE
 * ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
 * #endif
 * //---------------
 * int n; cin >> n;
 * for(int i=0;i<n;++i){
 * for(int j=0;j<n;++j){
 * cin>>v[i][j];
 * }
 * }
 * 
 * deque<pair<int,int>>dq;
 * dq.push_back({0,0});
 * bs[0][0]=1;
 * while (!dq.empty()){
 * int x=dq.front().first, y=dq.front().second;
 * dq.pop_front();
 * if (x+v[x][y]<n && !bs[x+v[x][y]][y]) {
 * bs[x+v[x][y]][y]=1;
 * dq.push_back({x+v[x][y],y});
 * }
 * if (y+v[x][y]<n && !bs[x][y+v[x][y]]) {
 * bs[x][y+v[x][y]]=1;
 * dq.push_back({x,y+v[x][y]});
 * }
 * if (bs[n-1][n-1]) break;
 * }
 * cout << ( bs[n-1][n-1] ? "HaruHaru":"Hing");
 * }
 * 
 */
