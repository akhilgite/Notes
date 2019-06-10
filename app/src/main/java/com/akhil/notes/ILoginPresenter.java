package com.akhil.notes;

import java.util.ArrayList;

public interface ILoginPresenter {

    public interface View{
        void showLoading();
        void hideLoading();
        void updateAdapter(ArrayList<User> users);
        void showMessage(String msg);
    }

    void downloadData();
}
