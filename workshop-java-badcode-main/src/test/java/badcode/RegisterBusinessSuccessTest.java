package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessSuccessTest {
    @Test
    @DisplayName("Save success")
    public void case01() {
        // Arrange
        RegisterBusiness registerBusiness = new RegisterBusiness();
        // Act
        Speaker speaker = new Speaker();
        speaker.setFirstName("Somkiat");
        speaker.setLastName("Pui");
        speaker.setEmail("somkiat@gmail.com");
        int actualId = registerBusiness.register(new MockSpeakerRepository(), speaker);
        // Assert
        assertEquals(500, actualId);
    }
}

class MockSpeakerRepository implements SpeakerRepository {
    @Override
    public Integer saveSpeaker(Speaker speaker) {
        return 500;
    }
}