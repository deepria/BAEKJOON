import java.io.*;
import java.util.StringTokenizer;

class WhereIsEnemy2 {

	 
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();

			int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

			for (int i = 0; i < T; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int r1 = Integer.parseInt(st.nextToken());

				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());

				double powD = (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
				double powRadiusMinus = Math.pow(r2 - r1, 2);
				double powRadiusPlus = Math.pow(r2 + r1, 2);

				// Case 1 : 중점 및 반지름 모두 동일한 경우 => 접점의 개수 무한개
				if (x1 == x2 && y1 == y2 && r1 == r2) {
					sb.append(-1).append("\n");
				}

				// Case 2-1 : 두 원의 반지름 합보다 중점간 거리가 더 긴 경우
				else if (powD > powRadiusPlus) {
					sb.append(0).append("\n");
				}

				// Case 2-2 : 원 안에 원이 있으나 내접하지 않은 경우
				else if (powD < powRadiusMinus) {
					sb.append(0).append("\n");
				}

				// Case 3-1 : 내접한 경우
				else if (powD == powRadiusMinus) {
					sb.append(1).append("\n");
				}

				// Case 3-2 : 외접한 경우
				else if (powD == powRadiusPlus) {
					sb.append(1).append("\n");
				}

				// Case 4 : 교점이 2개인 경우
				else {
					sb.append(2).append("\n");
				}
			}

			System.out.print(sb);
		}
	}


