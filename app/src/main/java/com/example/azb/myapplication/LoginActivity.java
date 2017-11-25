package com.example.azb.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private static final String CORRECT_EMAIL = "abc@gmail.com";
    private static final String CORRECT_PASSWORD = "123123";

    private Button login;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView tvForgetPassword;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Boilder Plate
        etEmailOrPhone = findViewById(R.id.et_email_or_phone);
        etPassword = findViewById(R.id.et_password);
        tvForgetPassword = findViewById(R.id.tv_forget_password);
        tvRegister = findViewById(R.id.tv_register);

        // Login Click Handler
        login =  findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailOrPhone = etEmailOrPhone.getText().toString();
                String password = etPassword.getText().toString();
                if(TextUtils.isEmpty(emailOrPhone)){
                    etEmailOrPhone.setError("Email or Phone can not be empty");
                    return;
                }else if (TextUtils.isEmpty(password)){
                    etPassword.setError("Password can not be empty");
                    return;
                }else if(TextUtils.equals(emailOrPhone, CORRECT_EMAIL) && TextUtils.equals(password, CORRECT_PASSWORD)){
                    Intent intent = PADCActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                }else{
                    Snackbar.make(v, "Incorrect email or password", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Action",null).show();
                }

            }
        });

        // Forget Password
        tvForgetPassword = findViewById(R.id.tv_forget_password);
        tvForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "\"Forget Password\" is coming soon", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action",null).show();
            }
        });


        tvRegister = findViewById(R.id.tv_register);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = RegistrationActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }
}
