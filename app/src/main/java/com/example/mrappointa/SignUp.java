package com.example.mrappointa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText fname,lname,email ,mobile,password,cpassword;
    Button btnAddData;
    TextView Signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myDb = new DatabaseHelper(this);


        fname = (EditText)findViewById(R.id.first_name);
        lname = (EditText)findViewById(R.id.last_name);
        mobile = (EditText)findViewById(R.id.mobile);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.pass);
        cpassword = (EditText)findViewById(R.id.conf_pass);
        btnAddData = (Button)findViewById(R.id.signup_btn);
        Signin = (TextView) findViewById(R.id.signin);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SignUp.this,Login.class);
                startActivity(in);
            }
        });

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Fname = fname.getText().toString();
                String Lname = lname.getText().toString();
                String Mobile = mobile.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String CPassword = cpassword.getText().toString();
                if (Fname.equals("") ||
                        Lname.equals("") ||
                        Mobile.equals("") ||
                        Email.equals("") ||
                        Password.equals("") ||
                        CPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (Password.equals(CPassword)) {
                        Boolean chkmail = myDb.chkmail(Email);
                        if (chkmail == true) {
                            Boolean insert = myDb.insert(Fname, Lname, Email, Mobile, Password, CPassword);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "password do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
       // AddData();
    }
   /* public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(fname.getText().toString(),
                                lname.getText().toString(),
                                email.getText().toString(),
                                mobile.getText().toString(),
                                password.getText().toString(),
                                cpassword.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(SignUp.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SignUp.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }*/
}