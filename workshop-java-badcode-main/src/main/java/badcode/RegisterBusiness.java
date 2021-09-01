package badcode;

import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;
        validateInput(speaker);
        speaker.setRegistrationFee(getFee(speaker.getExp()));
        try {
            speakerId = repository.saveSpeaker(speaker);
        } catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }
        return speakerId;
    }

    private boolean checkDomainOfEmail(String email) {
        String[] domains = {"gmail.com", "live.com"};
        String emailDomain = getEmailDomain(email);
        return Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() == 1;
    }

    private void validateInput(Speaker speaker) {
        if (isNullOrEmpty(speaker.getFirstName())) {
            throw new ArgumentNullException("First name is required.");
        }
        if (isNullOrEmpty(speaker.getLastName())) {
            throw new ArgumentNullException("Last name is required.");
        }
        if (isNullOrEmpty(speaker.getEmail())) {
            throw new ArgumentNullException("Email is required.");
        }
        if (!checkDomainOfEmail(speaker.getEmail())) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }
    }

    private boolean isNullOrEmpty(String firstName) {
        return firstName == null || firstName.trim().equals("");
    }

    int getFee(int experienceYear) {
        int fee = 0;
        if (experienceYear <= 1) {
            fee = 500;
        } else if (experienceYear <= 3) {
            fee = 250;
        } else if (experienceYear <= 5) {
            fee = 100;
        } else if (experienceYear <= 9) {
            fee = 50;
        }
        return fee;
    }

    public String getEmailDomain(String email) {
        String[] inputs = email.trim().split("@");
        if (inputs.length == 2)
            return inputs[1];
        throw new DomainEmailInvalidException();
    }

}
