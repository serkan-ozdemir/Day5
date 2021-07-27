package core;

public interface EmailService {
    void sendMail(String mail,String message);
    boolean verificationMail();
}
