package com.example.icall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ImageButton call,contacts;
    TextView name;
    CallNumberViewModel callNumberViewModel = CallNumberViewModel.getINSTANCE();
    String callNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        contacts = findViewById(R.id.contactsButton);
        name = findViewById(R.id.numberView);
        call = findViewById(R.id.callButton);

        observe();
        contacts.setOnClickListener(v -> openNewActivity());

        call.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:"+ callNumber));
            startActivity(i);
        });
    }
        public void openNewActivity(){
            Intent intent = new Intent(this,ContactActivity.class);
            startActivity(intent);
        }
    public void observe()
    {
        callNumberViewModel.namemutableLiveData.observe(this, s -> name.setText(s));
        callNumberViewModel.numberMutableLiveData.observe(this, s -> callNumber = s);
    }

}