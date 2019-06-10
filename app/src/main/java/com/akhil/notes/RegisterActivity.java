package com.akhil.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements IRegisterPresenter.View, View.OnClickListener {


    @BindView(R.id.edit_username)
    EditText editUsername;
    @BindView(R.id.btn_register)
    Button btnRegister;

    RegisterPresenterImpl registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        ButterKnife.bind(this);
        registerPresenter = new RegisterPresenterImpl(this);

    }

    @Override
    public void navigateToLoginScreen() {
        //navigate to login screen
        Toast.makeText(this, "navigated to login screen", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btn_register)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                String strUsername = editUsername.getText().toString();
                User user = new User();
                user.setUsername(strUsername);
                if (registerPresenter.registerUser(user)){
                    editUsername.setText("");
                    finish();
                }

                break;
        }
    }
}
