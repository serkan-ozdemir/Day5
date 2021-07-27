package core;

public class EmailManager implements EmailService{
    @Override
    public void sendMail(String mail,String message) {

        System.out.println(mail + " adresine gönderildi : " + message);
    }

    @Override
    public boolean verificationMail() {
        return true;
    }
}
