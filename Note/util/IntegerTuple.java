package util;

public class IntegerTuple {

    private final int a;
    private final int b;

    public IntegerTuple(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static IntegerTuple of(final int a, final int b) {
        return new IntegerTuple(a, b);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

}
