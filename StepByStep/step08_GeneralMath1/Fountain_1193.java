package step08_GeneralMath1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fountain_1193 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int a = 1;
		int b = 1;

		String trg = "-";

		for (int i = 1; i < n; i++) {

			if (a == 1 && b == 1) {
				b++;
			} else if ((a == 1 && b != 1 && trg == "-") || (a != 1 && b != 1 && trg == "-")) {
				a++;
				b--;
			} else if (a != 1 && b == 1 && trg == "-") {
				a++;
				trg = "+";
			} else if ((a != 1 && b == 1 && trg == "+") || (a != 1 && b != 1 && trg == "+")) {
				a--;
				b++;
			} else if (a == 1 && b != 1 && trg == "+") {
				b++;
				trg = "-";
			}

		}

		System.out.println(a + "/" + b);

	}
}
