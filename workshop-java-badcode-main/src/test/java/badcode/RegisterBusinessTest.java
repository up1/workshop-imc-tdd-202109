package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterBusinessTest {

    @Test
    @DisplayName("Throw exception with First name is required.")
    public void case01() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act and Assert
        Exception exception
                = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, new Speaker()));
        assertEquals("First name is required.", exception.getMessage());
    }

}