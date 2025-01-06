import java.util.ArrayList;
import java.util.Arrays;

public class CharTest4 {

	public static void main(String[] args) {
		System.out.println(solution("1 2 3 4"));

	}

	public static String solution(String s) {
		String[] strArr = s.split("");
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] == "-") {
				arr.add("-" + strArr[i + 1]);
				i++;
			} else {
				arr.add(strArr[i]);
			}

		}
		while (arr.remove(String.valueOf(" -"))) {
		}
		while (arr.remove(String.valueOf(" "))) {
		}

		int[] numArr = new int[arr.size()];

		for (int i = 0; i < arr.size(); i++) {
			numArr[i] = Integer.parseInt(arr.get(i));
		}

		Arrays.sort(numArr);

		String answer = Integer.toString(numArr[0]) + " " + Integer.toString(numArr[numArr.length - 1]);

		return answer;
	}

}
