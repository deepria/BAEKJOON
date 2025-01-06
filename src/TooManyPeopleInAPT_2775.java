import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TooManyPeopleInAPT_2775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {

			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			int howManyPeople = 0;

			int[][] apt = new int[15][15];

			for (int j = 0; j <= 14; j++) {

				for (int j2 = 1; j2 <= 14; j2++) {

					if (j == 0) {
						apt[j][j2] = j2;
					} else {
						for (int l = 1; l <= j2; l++) {
							howManyPeople += apt[j - 1][l];
						}
						apt[j][j2] = howManyPeople;
						howManyPeople = 0;
					}

				}
			}

			sb.append(apt[k][n]).append("\n");

			for (int x = 0; x < apt.length; x++) {
				System.out.println(x + "층");
				for (int y = 0; y < apt.length; y++) {
					System.out.println(x + "층" + y + "호 : " + apt[x][y] + " 명");
				}
				System.out.println("\n");
			}

		}

		System.out.println(sb);

		br.close();

	}
}