package com.example.icall;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

public class ContactActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ListView listView;
    CallNumberViewModel callNumberViewModel = CallNumberViewModel.getINSTANCE();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        listView = findViewById(R.id.listview);


        LoaderManager.getInstance(this).initLoader(1, null, this);

        listView.setOnItemClickListener((parent, view, position, id) -> {

           TextView number = view.findViewById(R.id.contactNumber);
            TextView name = view.findViewById(R.id.contactName);
           setName((String) name.getText());
           setNumber((String) number.getText());
            Intent intent = new Intent(ContactActivity.this,MainActivity.class);
            startActivity(intent);
        });

    }


    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return new CursorLoader(this, ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {


        TodoCursorAdapter todoCursorAdapter = new TodoCursorAdapter(this,data);
        listView.setAdapter(todoCursorAdapter);

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }

    public void setName(String name)
    {
        callNumberViewModel.setName(name);
    }
    public void setNumber(String number) {callNumberViewModel.setNumber(number);}


}
