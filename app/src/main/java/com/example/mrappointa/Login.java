package com.example.mrappointa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText Email,Password;
    Button login;
   // DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // myDb =new DatabaseHelper(this);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.login_btn);
        TextView register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this, SignUp.class);
                startActivity(in);
            }

        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String email = Email.getText().toString();
               String password = Password.getText().toString();
               Intent P = new Intent(Login.this,HomePage.class);
               P.putExtra("email",email);
               P.putExtra("password",password);
               startActivity(P);
              /* Boolean chkemailpass = myDb.emailpassword(email,password);
               if(chkemailpass==true){
                   Toast.makeText(getApplicationContext(),"Successfully login",Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(),"Incorrect email or password",Toast.LENGTH_SHORT).show();
               }*/
            }
        });
    }
}