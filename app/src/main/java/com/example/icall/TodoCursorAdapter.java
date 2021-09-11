package com.example.icall;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TodoCursorAdapter extends CursorAdapter {
    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public TodoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.my_row, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView contactsName = (TextView) view.findViewById(R.id.contactName);
        TextView contactsNumber = (TextView) view.findViewById(R.id.contactNumber);
        // Extract properties from cursor
         name = cursor.getString(cursor.getColumnIndexOrThrow("display_name"));
         number = cursor.getString(cursor.getColumnIndexOrThrow("data1"));
        // Populate fields with extracted properties
        contactsName.setText(name);
        contactsNumber.setText(number);
    }
}