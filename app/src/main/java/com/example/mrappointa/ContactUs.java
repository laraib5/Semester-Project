package com.example.mrappointa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        TextView iiui= (TextView) findViewById(R.id.iiui);
        iiui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://iiu.edu.pk/default.htm"));
                startActivity(intent);

            }
        });

        TextView join= (TextView) findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100041489984169"));
                startActivity(intent);

            }
        });

        TextView join2= (TextView) findViewById(R.id.join2);
        join2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/laraibnaqvi17"));
                startActivity(intent);

            }
        });

        TextView join3= (TextView) findViewById(R.id.join3);
        join3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/Kazmeka1"));
                startActivity(intent);

            }
        });
    }
}