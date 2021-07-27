package business.concretes;

import business.abstracts.VerificationService;
import entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificationManager implements VerificationService {
    @Override
    public boolean checkAll(User user) {
        if(checkEmail(user.getEmail())&&checkFirsName(user.getFirstName())&&checkLastName(user.getLastName())&&checkPassword(user.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkFirsName(String firstName) {
        if(firstName.length()<2){
            System.out.println("Isim en az 2 karakterden olusmalidir");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkLastName(String lastName) {
        if(lastName.length()<2){
            System.out.println("Soyisim en az 2 karakterden olusmalidir");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkPassword(String password) {
        if(password.length()<6){
            System.out.println("Parola en az 6 karakterden olusmalidir");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkEmail(String email) {
        Pattern regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(email);
        if (matcher.find()){
            return true;
        }else{
            System.out.println("mail adresi uygun degil!");
            return false;
        }

    }
}
