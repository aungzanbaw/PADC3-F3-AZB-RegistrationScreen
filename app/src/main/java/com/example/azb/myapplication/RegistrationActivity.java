package com.example.azb.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    private Button register;
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etAddress;
    private TextView tvLogin;


    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, RegistrationActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName= findViewById(R.id.et_name);
        etPhone= findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etAddress = findViewById(R.id.et_address);

        register = findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String address = etAddress.getText().toString();

                if(name.isEmpty()){
                    etName.setError("Name can not be empty");
                    return;
                }
                if(phone.isEmpty()){
                    etPhone.setError("Phone can not be empty");
                    return;
                }

                if (email.isEmpty()){
                    etEmail.setError("Email can not be empty");
                    return;
                }

                if (password.isEmpty()){
                    etPassword.setError("Password can not be empty");
                    return;
                }

                if (address.isEmpty()){
                    etAddress.setError("Address can not be empty");
                    return;
                }


            }
        });

        tvLogin = findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LoginActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });

    }



}
