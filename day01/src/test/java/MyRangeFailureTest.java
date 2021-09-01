import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyRangeFailureTest {

    @Test
    @DisplayName("Invalid input :: not start with [, (")
    public void case01() {
        MyRange myRange = new MyRange("{1,5]");
        Exception exception = assertThrows(
                RuntimeException.class, () -> myRange.validateInput());
        assertEquals("Invalid input",exception.getMessage());
    }
}