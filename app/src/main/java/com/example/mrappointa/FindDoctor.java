package com.example.mrappointa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FindDoctor extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    private  RecyclerAdapter.RecyclerViewClickListener listener;

    List<String> doctorsList;
    List<String> description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        doctorsList=new ArrayList<>();
        doctorsList.add("Dr. Abu Saifudin");
        doctorsList.add("Dr. Jamshed Ali");
        doctorsList.add("Dr. Nasim Ashraf");
        doctorsList.add("Dr. Shazia Khalid");

        description=new ArrayList<>();
        description.add("Assistant Processor"+"\n"+"Neuromedicine"+"\n"+"MD, MPhil, PhD");
        description.add("Assistant Processor"+"\n"+"Gynae and Obs"+"\n"+"MBBS, BCS, MD, FCPS");
        description.add("EX.Processor"+"\n"+"Brain tumer"+"\n"+"MBBS, FCPS, MD, BCS");
        description.add("Doctor"+"\n"+"Trauma"+"\n"+"MBBS, FRCS");

        setOnClickListener();
        recyclerView=findViewById(R.id.recyclerView);
        recyclerAdapter=new RecyclerAdapter(doctorsList,description, listener);
        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void setOnClickListener() {
        listener=new RecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public  void onClick(View v, int position){
                String i= doctorsList.get(position).toString();
                if(i.equals("Dr. Abu Saifudin")){
                    Intent in= new Intent(getApplicationContext(), abuSaifudin.class);
                    startActivity(in);
                }
                if(i.equals("Dr. Jamshed Ali")){
                    Intent in= new Intent(getApplicationContext(), jamshedAli.class);
                    startActivity(in);
                }
                if(i.equals("Dr. Nasim Ashraf")){
                    Intent in= new Intent(getApplicationContext(), nasimAshraf.class);
                    startActivity(in);
                }
                if(i.equals("Dr. Shazia Khalid")){
                    Intent in= new Intent(getApplicationContext(), shaziaKhalid.class);
                    startActivity(in);
                }
            }
        };
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return  super.onCreateOptionsMenu(menu);
    }
}