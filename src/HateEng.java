import java.util.ArrayList;

public class HateEng {

	public static void main(String[] args) {
		System.out.println(solution("onetwothreefourfivesixseveneightnine"));

	}

	public static long solution(String numbers) {
		long answer = 0;

		String[] number = numbers.split("");

		ArrayList<String> List = new ArrayList<>();

		String[] str = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		long[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		String string = "";
		for (int i = 0; i < number.length; i++) {
			string += number[i];
			System.out.println(string);
			for (int j = 0; j < str.length; j++) {
				if (string.equals(str[j])) {
					List.add(Long.toString(num[j]));
					string = "";
					System.out.println(string);

				}
			}
		}

		for (int i = 0; i < List.size(); i++) {
			string += List.get(i);
		}

		answer = Long.parseLong(string);

		return answer;
	}

}
