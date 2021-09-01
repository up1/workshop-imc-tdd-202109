import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Start with exclude(()")
    public void case02() {
        // Arrange
        MyRange myRange = new MyRange("(1,5]");
        // Act
        boolean expectedResult = myRange.startWithInclude();
        // Assert
        assertFalse(expectedResult);
    }

    @Test
    @DisplayName("Start number with include [1,5] => 1")
    public void case03() {
        // Arrange
        MyRange myRange = new MyRange("[1,5]");
        // Act
        int actualResult = myRange.getStartNumber();
        // Assert
        assertEquals(1, actualResult);
    }

    @Test
    @DisplayName("Start number with exclude (1,5] => 2")
    public void case04() {
        // Arrange
        MyRange myRange = new MyRange("(1,5]");
        // Act
        int actualResult = myRange.getStartNumber();
        // Assert
        assertEquals(2, actualResult);
    }
}
