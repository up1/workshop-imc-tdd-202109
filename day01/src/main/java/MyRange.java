public class MyRange {
    public static final int ASCII_CODE_OF_ONE = 48;
    private final String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean startWithInclude() {
        return this.input.startsWith("[");
    }

    public int getStartNumber() {
        return Integer.parseInt(this.input.charAt(1) + "");
//        return this.input.charAt(1) - ASCII_CODE_OF_ONE;
    }
}
