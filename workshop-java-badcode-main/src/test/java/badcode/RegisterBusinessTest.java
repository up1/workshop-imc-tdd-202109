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

    @Test
    @DisplayName("Throw exception with First name is required.")
    public void case02() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act and Assert
        Exception exception
                = assertThrows(ArgumentNullException.class, () ->
        {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Somkiat");
            registerBusiness.register(null, speaker);
        });
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception with Email is required..")
    public void case03() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act and Assert
        Exception exception
                = assertThrows(ArgumentNullException.class, () ->
        {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Somkiat");
            speaker.setLastName("Pui");
            registerBusiness.register(null, speaker);
        });
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception with DomainEmailInvalidException.")
    public void case04() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act and Assert
        Exception exception
                = assertThrows(DomainEmailInvalidException.class, () ->
        {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Somkiat");
            speaker.setLastName("Pui");
            speaker.setEmail("somkiat");
            registerBusiness.register(null, speaker);
        });
    }

    @Test
    @DisplayName("Throw exception with Speaker doesn't meet our standard rules.")
    public void case05() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act and Assert
        Exception exception
                = assertThrows(SpeakerDoesntMeetRequirementsException.class, () ->
        {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Somkiat");
            speaker.setLastName("Pui");
            speaker.setEmail("somkiat@xxx.com");
            registerBusiness.register(null, speaker);
        });

        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    @DisplayName("Throw exception with Can't save a speaker.")
    public void case06() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act and Assert
        Exception exception
                = assertThrows(SaveSpeakerException.class, () ->
        {
            Speaker speaker = new Speaker();
            speaker.setFirstName("Somkiat");
            speaker.setLastName("Pui");
            speaker.setEmail("somkiat@gmail.com");
            registerBusiness.register(null, speaker);
        });

        assertEquals("Can't save a speaker.", exception.getMessage());
    }
}