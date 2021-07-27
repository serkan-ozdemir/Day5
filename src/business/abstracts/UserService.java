package business.abstracts;

import entities.concretes.User;

public interface UserService {
    void logIn(String mail,String password);
    void googleRegister(String mail);
    void register(User user);
}
