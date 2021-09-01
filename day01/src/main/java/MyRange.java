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
        if(startWithInclude())
            return Integer.parseInt(this.input.charAt(1) + "");
        return Integer.parseInt(this.input.charAt(1) + "") + 1;
//        return this.input.charAt(1) - ASCII_CODE_OF_ONE;
    }

    public String getResult() {
        int startNumber = getStartNumber();
        int endNumber = 5; // TODO
        StringBuilder result = new StringBuilder();
        for (int i = startNumber; i <= endNumber ; i++) {
            result.append(i);
        }
        return result.toString();
    }

    public void validateInput() {
        // TODO
        throw new RuntimeException("Invalid input");
    }
}
