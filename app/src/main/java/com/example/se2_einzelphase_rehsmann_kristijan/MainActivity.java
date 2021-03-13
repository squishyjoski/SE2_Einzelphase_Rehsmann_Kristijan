package com.example.se2_einzelphase_rehsmann_kristijan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aufgabe 1: Button für Serverberechnung

        Button abschickenButton = (Button) findViewById(R.id.abschickenButton);
        abschickenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EingabeMatrikelnummer = (EditText) findViewById(R.id.EingabeMatrikelnummerEditTextNumber);
                TextView Antwort = (TextView) findViewById(R.id.AntwortTextView);

                String eingabe = EingabeMatrikelnummer.getText().toString();

                Client client = new Client(eingabe);
                client.start();
                try {
                    client.join();
                }
                catch (Exception e){
                }
                Antwort.setText(client.ausgabe);
            }
        });


        // Aufgabe 2: Button für lokale Berechnung, ruft Methode sort auf, die die Berechnung durchführt

        Button berechnenButton = (Button) findViewById(R.id.berechnenButton);
        berechnenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText EingabeMatrikelnummer = (EditText) findViewById(R.id.EingabeMatrikelnummerEditTextNumber);
                TextView Antwort = (TextView) findViewById(R.id.AntwortTextView);

                String eingabe = EingabeMatrikelnummer.getText().toString();
                Antwort.setText(sort(eingabe));
            }
        });

    }





    //Implementierung der Berechnung von Aufgabe 2.0 -> sortiert erst die geraden, dann alle ungeraden Ziffern aufsteigend

    public String sort (String eingabe){



        char [] StringToArray = eingabe.toCharArray();
        Arrays.sort(StringToArray);

        String odd="";
        String even ="";


        for (int i=0; i<StringToArray.length-1;i++ ){
            if(StringToArray[i]%2==0){
                even=even+StringToArray[i];
            }
            else{
                odd=odd+StringToArray[i];
            }


        };
        String ausgabe = even+odd;

        return ausgabe;

    }

}