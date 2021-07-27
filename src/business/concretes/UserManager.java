package business.concretes;

import business.abstracts.UserService;
import business.abstracts.VerificationService;
import core.EmailService;
import core.RegisterService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {
    private UserDao userDao;
    private RegisterService registerService;
    private VerificationService verificationService;
    private EmailService emailService;

    public UserManager(UserDao userDao, RegisterService registerService, VerificationService verificationService, EmailService emailService) {
        this.userDao = userDao;
        this.registerService = registerService;
        this.verificationService = verificationService;
        this.emailService = emailService;
    }

    @Override
    public void logIn(String mail, String password) {
        if(userDao.logInCheck(mail,password)){
            System.out.println("Giriş yapildi.");
        }else {
            System.out.println("Giriş basarisiz.");
        }
    }

    @Override
    public void googleRegister(String mail) {
        if(registerService.signUp(mail)){
            System.out.println("Google ile giriş yapildi.");
        }else {
            System.out.println("Google ile giris basarisiz.");
        }
    }

    @Override
    public void register(User user) {
        if(!userDao.existMailCheck(user.getEmail())){
            if(verificationService.checkAll(user)){
                emailService.sendMail(user.getEmail(),"Uyeligin tamamlanmasi icin linke tiklayiniz");
                if(emailService.verificationMail()){
                    userDao.add(user);
                    System.out.println("Uyelik olusturma basarili");
                }else
                System.out.println("Uyelik oluşturma basarisiz");
            }
        }else{
            System.out.println("Bu mail adresi kullaniliyor");
        }

    }
}
