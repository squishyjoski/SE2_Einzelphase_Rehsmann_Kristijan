package com.example.se2_einzelphase_rehsmann_kristijan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button für Serverberechnung

        Button abschickenButton = (Button) findViewById(R.id.abschickenButton);
        abschickenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EingabeMatrikelnummer = (EditText) findViewById(R.id.EingabeMatrikelnummerEditTextNumber);
                TextView Antwort = (TextView) findViewById(R.id.AntwortTextView);

                String eingabe = EingabeMatrikelnummer.getText().toString();
                String ausgabe = "Testausgabe server";

                /*int Matrikelnummer = Integer.parseInt(EingabeMatrikelnummer.getText().toString());
                int result = Matrikelnummer + 1;*/
                Antwort.setText(ausgabe);

            }

            public String sort(String eingabe){
                String ausgabe = (String)eingabe;


                return ausgabe;
            }
        });


        // Button für lokale Berechnung inklusive Implementierung

        Button berechnenButton = (Button) findViewById(R.id.berechnenButton);
        berechnenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText EingabeMatrikelnummer = (EditText) findViewById(R.id.EingabeMatrikelnummerEditTextNumber);
                TextView Antwort = (TextView) findViewById(R.id.AntwortTextView);

                String eingabe = EingabeMatrikelnummer.getText().toString();


                //Implementierung der Aufgabe 0

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

                Antwort.setText(ausgabe);

            }
        });

    }



    //Implementierung von client


    public static void client(String argv[]) throws Exception{
        String sentence;
        String modifiedSentence;

        BufferedReader inFromuser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence = inFromuser.readLine();

        outToServer.writeBytes(sentence + '\n');

        modifiedSentence = inFromServer.readLine();

        clientSocket.close();

    }


}