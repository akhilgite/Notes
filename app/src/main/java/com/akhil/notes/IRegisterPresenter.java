package com.akhil.notes;

public interface IRegisterPresenter {
    interface View{
        void navigateToLoginScreen();
        void showMessage(String msg);
    }

    boolean registerUser(User user);
    boolean validateUser(User user);
}
