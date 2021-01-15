package com.example.mrappointa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    DatabaseHelper myDb;
Button get_appointment,my_profile,find_doctor,upcoming_appointments;
String em,ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        Intent intent = getIntent();
        em = intent.getStringExtra("email");
        ps = intent.getStringExtra("password");

        myDb =new DatabaseHelper(this);

        Boolean chkemailpass = myDb.emailpassword(em,ps);
        if(chkemailpass==true){
            Toast.makeText(getApplicationContext(),"Successfully login",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Incorrect email or password",Toast.LENGTH_SHORT).show();
        }

        get_appointment = (Button) findViewById(R.id.get_Apoointment);
        my_profile = (Button) findViewById(R.id.my_profile);
        find_doctor = (Button) findViewById(R.id.find_doctor);
        upcoming_appointments = (Button) findViewById(R.id.upcoming_Appointment);

        upcoming_appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent list = new Intent(HomePage.this,AppointmentList.class);
                startActivity(list);
            }
        });

        get_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent book = new Intent(HomePage.this,GetAppointment.class);
                startActivity(book);
            }
        });

        my_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(HomePage.this,MyProfile.class);
                startActivity(profile);
            }
        });

        find_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent find = new Intent(HomePage.this,FindDoctor.class);
                startActivity(find);
            }
        });




       Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_EditProfile:
                Intent intent2 = new Intent(this,EditProfile2.class);
                startActivity(intent2);
                break;
            case R.id.nav_AppointmentList:
                Intent list = new Intent(this,AppointmentList.class);
                startActivity(list);
                break;
            case R.id.nav_AboutUs:
                Intent about = new Intent(this,AboutUs.class);
                startActivity(about);
                break;
            case R.id.nav_ContactUs:
                Intent contact = new Intent(this,ContactUs.class);
                startActivity(contact);
                break;
            case R.id.nav_LogOut:
                Intent logout = new Intent(this,Login.class);
                startActivity(logout);
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }


    public void Book(View view) {
        Intent book = new Intent(HomePage.this,GetAppointment.class);
        startActivity(book);
    }
}