package com.android.climatechange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    EditText et_username, et_password;
    TextView tv_forgotpassword,tv_signup,upass;
    Button btn_login;
    CheckBox showpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        et_username = findViewById(R.id.username);
        et_password = findViewById(R.id.password);
        btn_login=findViewById(R.id.login);
        tv_forgotpassword = findViewById(R.id.forgot);
        tv_signup = findViewById(R.id.account);

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(LoginActivity.this,Registration_Form.class));
                startActivity(intent);
            }
        });





        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =(new Intent(LoginActivity.this,MainActivity.class));
                startActivity(intent);

            }
        });
    }
}