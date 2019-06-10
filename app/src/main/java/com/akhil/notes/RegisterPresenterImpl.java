package com.akhil.notes;

import android.text.TextUtils;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPresenterImpl implements IRegisterPresenter {

    private View view;

    public RegisterPresenterImpl(View view){
        this.view = view;
    }

    @Override
    public boolean registerUser(User user) {
        if (validateUser(user)){
            //register user

            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference();
            databaseReference.child("users").child(user.getUsername()).setValue(user);

            view.showMessage("User registered successfully");
            view.navigateToLoginScreen();
            return true;
        }
        //else do nothing
        return false;
    }

    @Override
    public boolean validateUser(User user) {

        if (TextUtils.isEmpty(user.username)){
            view.showMessage("Enter valid username");
            return false;
        }
        return true;
    }
}
