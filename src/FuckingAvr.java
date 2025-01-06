import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FuckingAvr {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double n = Double.parseDouble(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {

			double sum = 0;

			String[] strArr = br.readLine().split(" ");

			for (int j = 1; j < strArr.length; j++) {

				sum += Double.parseDouble(strArr[j]);

			}

			double avr = sum / Double.parseDouble(strArr[0]);

			double cnt = 0;

			for (int j = 1; j < strArr.length; j++) {
				if (Double.parseDouble(strArr[j]) > avr) {
					cnt++;
				}
			}

			double answer = cnt / Double.parseDouble(strArr[0]) * 100.0;

			String strAnswer = String.format("%.3f", answer);

			sb.append(strAnswer).append("%").append("\n");

		}

		System.out.println(sb);

	}
}
