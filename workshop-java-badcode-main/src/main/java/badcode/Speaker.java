package badcode;

import java.util.List;

public class Speaker {
    private String firstName;
    private String lastName;
    private String email;
    private int exp;
    private int registrationFee;
    private boolean hasBlog;
    private String blogUrl;
    private List<String> certifications;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getRegistrationFee() {
        return getFee(this.getExp());
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

    public void setRegistrationFee(int registrationFee) {
        this.registrationFee = registrationFee;
    }

    public boolean isHasBlog() {
        return hasBlog;
    }

    public void setHasBlog(boolean hasBlog) {
        this.hasBlog = hasBlog;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }
}
