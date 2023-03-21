package com.example.arkhamarchives;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


import java.util.Locale;

public class StartPage extends AppCompatActivity {

    Spinner spinner;
    public static final String[] languages={"Select Language","English","Hindi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        spinner =findViewById(R.id.spinner);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang=parent.getItemAtPosition(position).toString();
                if(selectedLang.equals("English")){
                    setLocal(StartPage.this,"en");
                    finish();
                    startActivity(getIntent());
                }else if(selectedLang.equals("Hindi")){
                    setLocal(StartPage.this,"hi");
                    finish();
                    startActivity(getIntent());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void setLocal(Activity activity,String langCode){
        Locale locale=new Locale(langCode);
        locale.setDefault(locale);
        Resources resources =activity.getResources();
        Configuration config =resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config,resources.getDisplayMetrics());
    }
}