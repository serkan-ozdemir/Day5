package dataAccess.abstracts;

import entities.concretes.User;

public interface UserDao {
    void add(User user);
    boolean logInCheck(String mail,String password);
    boolean existMailCheck(String mail);
}
