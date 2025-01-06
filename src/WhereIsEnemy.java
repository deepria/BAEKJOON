import java.util.ArrayList;

public class WhereIsEnemy {

	public static void main(String[] args) {

		System.out.println(solution("3\r\n" + "0 0 13 40 0 37\r\n" + "0 0 3 0 7 4\r\n" + "1 1 1 1 1 5"));

	}

	public static String solution(String testCase) {

		String[] strList = testCase.split("\r\n");

		for (String string : strList) {
			System.out.println("temp : " + string);
		}

		int testCaseSize = Integer.parseInt(strList[0]);

		ArrayList<Integer>[] list = new ArrayList[testCaseSize];

		for (int i = 0; i < testCaseSize; i++) {
			list[i] = new ArrayList<>();

			String[] caseList = strList[i + 1].split(" ");
			for (int j = 0; j < 6; j++) {
				list[i].add(Integer.parseInt(caseList[j]));
			}
		}

		for (ArrayList<Integer> arrayList : list) {
			System.out.println("\n");
			for (int n : arrayList) {
				System.out.println("n: " + n);
			}

		}

		String answer = "";
		for (ArrayList<Integer> arrayList : list) {

			double x = Math.pow(Math.abs(
					Math.max(arrayList.get(3), arrayList.get(0)) - Math.min(arrayList.get(3), arrayList.get(0))), 2);
			double y = Math.pow(Math.abs(
					Math.max(arrayList.get(4), arrayList.get(1)) - Math.min(arrayList.get(4), arrayList.get(1))), 2);
			double r = Math.pow((arrayList.get(2) + arrayList.get(5)), 2);

			if (arrayList.get(0) == arrayList.get(1) && arrayList.get(0) == arrayList.get(2)
					&& arrayList.get(0) == arrayList.get(3) && arrayList.get(0) == arrayList.get(4)
					&& arrayList.get(0) == arrayList.get(5)) {
				answer += "-1\r\n";
				continue;
			}

			if (x == 0 && y == 0) {
				answer += "0\r\n";
				continue;
			}
			if (x + y + Math.pow(Math.min(arrayList.get(2), arrayList.get(5)), 2) < Math
					.pow(Math.max(arrayList.get(2), arrayList.get(5)), 2)) {
				answer += "0\r\n";
				continue;
			}

			if (x + y == r) {
				answer += "1\r\n";
			} else if (x + y < r) {
				answer += "2\r\n";
			} else if (x + y > r) {
				answer += "0\r\n";
			} else {
				answer += "-1\r\n";
			}
		}

		return answer;
	}

}
