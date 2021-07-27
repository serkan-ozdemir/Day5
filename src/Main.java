import business.concretes.UserManager;
import business.concretes.VerificationManager;
import core.EmailManager;
import core.GoogleRegisterManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        UserManager userManager=new UserManager(new HibernateUserDao(),new GoogleRegisterManagerAdapter(),new VerificationManager(),new EmailManager());
        User user1 = new User(1,"Serkan","Özdemir" , "serkanozdmr7@gmail.com","1234567");
        User user2 = new User(2,"S","Ö" , "serkanozdmr7@gmail.com","1234");
        User user3 = new User(3,"S","Ö" , "serkanozdmr8@gmail.com","1234");

        userManager.register(user1);    //Basarili
        userManager.register(user2);    //Mail adresi kullaniliyor
        userManager.register(user3);    //Hatalı deneme
        userManager.googleRegister("serkanozdmr@gmail.com");    //Google Kayıt

        userManager.logIn(user1.getEmail(),user1.getPassword());


    }
}
