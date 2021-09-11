package com.example.icall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    ImageButton call,contacts;
    TextView name;
    CallNumberViewModel callNumberViewModel = CallNumberViewModel.getINSTANCE();
    String callnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        contacts = findViewById(R.id.contactsButton);
        name = findViewById(R.id.numberView);
        call = findViewById(R.id.callButton);

        observe();
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              openNewActivity();
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+callnumber));
                startActivity(i);
            }
        });
    }
        public void openNewActivity(){
            Intent intent = new Intent(this,ContactActivity.class);
            startActivity(intent);
        }
    public void observe()
    {
        callNumberViewModel.namemutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                name.setText(s);
            }
        });
        callNumberViewModel.numberMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
              callnumber = s;
            }
        });
    }

}