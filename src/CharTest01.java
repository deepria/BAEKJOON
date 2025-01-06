
public class CharTest01 {

	public static void main(String[] args) {

	}

	boolean solution(String s) {
		boolean answer = true;

		String[] strArray = s.split("");
		int y = 0;
		int p = 0;

		for (String str : strArray) {
			if (str.equalsIgnoreCase("Y")) {
				y++;
			} else if (str.equalsIgnoreCase("P")) {
				p++;
			}
		}
		if (y != p) {
			answer = false;
		} else if (y == 0 && p == 0) {
			answer = true;
		}
		return answer;
	}

}
