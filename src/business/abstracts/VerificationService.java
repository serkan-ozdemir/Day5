package business.abstracts;

import entities.concretes.User;

public interface VerificationService {
    boolean checkAll(User user);
    boolean checkFirsName(String firstName);
    boolean checkLastName(String lastName);
    boolean checkPassword(String password);
    boolean checkEmail(String email);
}
