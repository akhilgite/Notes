package com.akhil.notes;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginPresenterImpl implements ILoginPresenter{

    public View view;
    ArrayList<User> users;

    public LoginPresenterImpl(View view) {
        this.view = view;
        users = new ArrayList<>();
    }

    @Override
    public void downloadData() {
        view.showLoading();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users.clear();
                for (DataSnapshot tmp: dataSnapshot.getChildren()){
                    users.add(tmp.getValue(User.class));
                }
                view.updateAdapter(users);
                view.hideLoading();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                view.showMessage("Failed to download data");
                view.hideLoading();
            }
        });

    }
}
