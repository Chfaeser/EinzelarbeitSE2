package com.example.einzelarbeitse2;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;


public class Verbindung extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... Nr) {
        String answer ="";
        try {
            String matNr;

            InputStream inputs = new ByteArrayInputStream(Nr[0].getBytes(Charset.forName("UTF-8")));

            //TCP Client basierend auf Tutoriums Folien

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(inputs));

            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            matNr = inFromUser.readLine();
            outToServer.writeBytes("0" + matNr + '\n'); //"0" weil Matrikelnummern mit 7 Stellen fehlerhaft waren
            answer = inFromServer.readLine();

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Error ", "Verbindungsfehler");
        }

        return answer;

    }

    //Aufwändigere Implmenetierung von onPreExecute/onPostExecute hier nicht notwendig
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String nr){
        super.onPostExecute(nr);
    }
}

