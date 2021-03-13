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

                String eingabe = EingabeMatrikelnummer.toString();
                String ausgabe = "Testausgabe";

                /*int Matrikelnummer = Integer.parseInt(EingabeMatrikelnummer.getText().toString());
                int result = Matrikelnummer + 1;*/
                Antwort.setText(ausgabe);

            }

            public String sort(String eingabe){
                String ausgabe = (String)eingabe;


                return ausgabe;
            }
        });

    }


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