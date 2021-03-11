package com.example.se2_einzelphase_rehsmann_kristijan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button abschickenButton = (Button) findViewById(R.id.abschickenButton);
        abschickenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EingabeMatrikelnummer = (EditText) findViewById(R.id.EingabeMatrikelnummerEditTextNumber);
                TextView Antwort = (TextView) findViewById(R.id.AntwortTextView);

                int Matrikelnummer = Integer.parseInt(EingabeMatrikelnummer.getText().toString());
                int result = Matrikelnummer + 1;
                Antwort.setText(result + "");

            }
        });
    }
}