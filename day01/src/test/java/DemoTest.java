import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTest {
    @Test
    @DisplayName("สวัสดี junit 5")
    public void case01() {
        // Arrange, Given
        String expectedResult = "Hello, somkiat";
        Hello hello = new Hello();
        // Act, When
        String actualResult = hello.sayHi("somkiat");
        // Assert, Then
        assertEquals(expectedResult, actualResult);
    }
}
