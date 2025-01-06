import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PlusCycle {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String[] strArr = str.split("");

		String newNum = "";
		int cnt = 0;

		while (!str.equals(newNum)) {

			int a = Integer.parseInt(strArr[strArr.length - 1]) * 10;
			int b = (Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[strArr.length - 1])) % 10;

			if (strArr.length == 1) {
				b = Integer.parseInt(strArr[0]);
			}

			newNum = Integer.toString(a + b);

			strArr = newNum.split("");

			cnt++;

		}

		System.out.println(cnt);

	}
}
