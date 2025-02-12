package com.adiron.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    CheckBox checkBox;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        initViews();
    }

    private void initViews() {
        checkBox = findViewById(R.id.checkBox);
        confirmButton = findViewById(R.id.button7);

        confirmButton.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            if (checkBox.isChecked()) {
                // שלח תוצאה של TRUE אם הצ'קבוקס נבחר
                resultIntent.putExtra("confirmationStatus", true);
                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(ButtonActivity.this, "Please select the checkbox before confirming.", Toast.LENGTH_SHORT).show();
                resultIntent.putExtra("confirmationStatus", false);
                setResult(RESULT_CANCELED, resultIntent);
            }
        });
    }
}
