import java.util.Arrays;

public class OrderByTest01 {

	public static void main(String[] args) {
		System.out.println(solution(123));

	}

	public static long solution(long n) {

		String[] strArr = String.valueOf(n).split("");

		long[] arr = new long[strArr.length];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = Long.parseLong(strArr[i]);
		}

		Arrays.sort(arr);

		String str = "";

		for (int i = (arr.length - 1); i >= 0; i--) {

			str += Long.toString(arr[i]);
		}

		return Long.parseLong(str);

	}

}
