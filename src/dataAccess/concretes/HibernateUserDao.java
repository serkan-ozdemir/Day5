package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements UserDao {
    List<User> users = new ArrayList<User>();
    @Override
    public void add(User user) {
            users.add(user);
    }

    @Override
    public boolean logInCheck(String mail, String password) {
        for (User user:users) {
            if(user.getEmail() == mail && user.getPassword() == password){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existMailCheck(String mail) {
        for (User user:users) {
            if (user.getEmail()==mail)
                return true;
        }
        return false;
    }

}
