package com.adiron.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    int result = 0;
    int guessCount = 0;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    Button button1;


    public void makeToast(String str) {
        Toast.makeText(GameActivity.this, str, Toast.LENGTH_SHORT).show();
    }


    public void clickFunction(View view) {
        EditText variable = findViewById(R.id.editId);
        String guessStr = variable.getText().toString();


        if (guessStr.isEmpty()) {
            makeToast("Please enter a guess😎!");
            return;
        }

        int userGuessing = Integer.parseInt(guessStr);
            guessCount++;


        if ((radio1.isChecked() && (userGuessing < 1 || userGuessing > 100)) ||
                (radio2.isChecked() && (userGuessing < 101 || userGuessing > 200)) ||
                (radio3.isChecked() && (userGuessing < 201 || userGuessing > 300))) {
            makeToast("Guess is out of range. Please try again.💩");
            return;
        }


        if (userGuessing < result) {
            makeToast("Think of a Higher Number, Try Again😢💩");
        } else if (userGuessing > result) {
            makeToast("Think of a Lower Number, Try Again😢💩");
        } else {
            makeToast("Congratulations🎉🎊🎉, You Got the Number! The guess count is " + guessCount);
            
            guessCount = 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio1 = findViewById(R.id.radio1);
                radio2 = findViewById(R.id.radio2);
                radio3 = findViewById(R.id.radio3);

                guessCount = 0;

                if (radio1.isChecked()) {
                    result = (int) ((Math.random() * 100 + 1));
                    makeToast("Game Started🤩! Try guessing the number between 1 and 100.");
                } else if (radio2.isChecked()) {
                    result = (int) ((Math.random() * 100 + 101));
                    makeToast("Game Started🤩! Try guessing the number between 101 and 200.");
                } else if (radio3.isChecked()) {
                    result = (int) ((Math.random() * 100 + 201));
                    makeToast("Game Started🤩! Try guessing the number between 201 and 300.");
                } else {
                    makeToast("Please select a difficulty level😵");
                }
            }
        });
    }
            @Override
            protected void onStart() {
                super.onStart();
                Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onDestroy() {
                super.onDestroy();
                Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onStop() {
                super.onStop();
                Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onPause() {
                super.onPause();
                Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onResume() {
                super.onResume();
                Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
            }

}
