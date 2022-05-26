package com.android.climatechange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration_Form extends AppCompatActivity {
    EditText et_firstname,et_lastname,et_password,et_confirmpassword,et_emailaddress;
    Button btn_register;
    TextView tv_registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        et_firstname = findViewById(R.id.firstname);
        et_lastname = findViewById(R.id.lastname);
        et_password = findViewById(R.id.password);
        et_confirmpassword = findViewById(R.id.confirmpassword);
        et_emailaddress = findViewById(R.id.emailaddress);
        btn_register = findViewById(R.id.register);
        tv_registration = findViewById(R.id.resgistration);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Registration_Form.this,MainActivity.class));
                startActivity(intent);
            }
        });

    }
}