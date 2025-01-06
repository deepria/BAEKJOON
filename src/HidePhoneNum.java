
public class HidePhoneNum {

	public static void main(String[] args) {
		System.out.println(solution("12345678912345678912"));

	}

	public static String solution(String phone_number) {
		String answer = "";

		String[] strArray = phone_number.split("");

		for (int i = 0; i < strArray.length; i++) {
			if (i < strArray.length - 4) {
				answer += "*";
			} else {
				answer += strArray[i];
			}

		}

		return answer;
	}

}
