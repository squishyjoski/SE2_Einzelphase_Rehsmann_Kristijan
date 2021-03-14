//Kristijan Rehsmann, 1060157


package com.example.se2_einzelphase_rehsmann_kristijan;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client extends Thread {

    String eingabe;
    String ausgabe;

    public Client(String eingabe) {
        this.eingabe = eingabe;
        this.ausgabe = "";
    }


    // Methode für die Kommunikation mit Server - wurde aus den Angaben aus dem Tutorium übernommen und adaptiert
    @Override
    public void run() {
            String sentence;
            try {
                Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                sentence = eingabe;
                outToServer.writeBytes(sentence + '\n');
                ausgabe = inFromServer.readLine();
                clientSocket.close();
            }

             catch (Exception e) {
                e.printStackTrace();
            }
    }
}
