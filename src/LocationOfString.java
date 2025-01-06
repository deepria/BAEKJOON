import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LocationOfString {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();

		char[] aToz = new char[26];

		for (int i = 0; i < aToz.length; i++) {

			aToz[i] = (char) (97 + i);
		}

		int[] answer = new int[26];

		for (int i = 0; i < aToz.length; i++) {

			int a = -1;

			for (int j = arr.length - 1; j >= 0; j--) {
				if (arr[j] == aToz[i]) {
					a = j;

				}

				answer[i] = a;

			}
		}

		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}

	}

}
