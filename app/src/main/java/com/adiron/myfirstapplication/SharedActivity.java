package com.adiron.myfirstapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SharedActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    EditText name, email;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        // חיבור ה-EditText לקובץ ה-XML
        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);

        // יצירת SharedPreferences
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        // בדיקה אם יש נתונים שמורים והצגת הנתונים ב-EditText
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));
        }
    }

    // פונקציה לשמירת הנתונים
    public void Save(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.apply(); // שמירה אסינכרונית
    }

    // פונקציה לניקוי השדות
    public void clear(View view) {
        name.setText("");
        email.setText("");
    }

    // פונקציה לשליפת הנתונים השמורים
    public void Get(View view) {
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));
        }
    }
}