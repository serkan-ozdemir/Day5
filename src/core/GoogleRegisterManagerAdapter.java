package core;

import google.GoogleRegisterManager;

public class GoogleRegisterManagerAdapter implements RegisterService{
    @Override
    public boolean signUp(String mail) {
        GoogleRegisterManager googleRegisterManager = new GoogleRegisterManager();
        return googleRegisterManager.signUp(mail);
    }
}
