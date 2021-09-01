import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyRangeTest {

    @Test
    @DisplayName("Start with include([)")
    public void case01() {
        // Arrange
        MyRange myRange = new MyRange("[1,5]");
        // Act
        boolean expectedResult = myRange.startWithInclude();
        // Assert
        assertTrue(expectedResult);
    }

}
