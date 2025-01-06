package bruteForce;

import util.Reader;

public class Minecraft_18111 {
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        int h = in.nextInt();
        int w = in.nextInt();
        int b = in.nextInt();
        int[] arr = new int[h * w];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int put, rm, floor = 0;
        int min = Integer.MAX_VALUE;
        for (int height = 0; height <= 256; height++) {
            put = 0;
            rm = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > height) {
                    rm += arr[i] - height;
                } else if (arr[i] < height) {
                    put += height - arr[i];
                }
            }
            if (put <= b + rm) {
                if (put + 2 * rm <= min) {
                    min = put + 2 * rm;
                    floor = height;
                }
            }
        }

        System.out.println(min + " " + floor);

    }

}
