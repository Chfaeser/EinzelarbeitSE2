package com.example.einzelarbeitse2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Methode für Aufgabe 2.2

    public void sortieren (View view) {

        EditText number = findViewById(R.id.editNumber);

        String text = number.getText().toString();

        //Input in ein Array verwandeln
        int[]array = new int [text.length()];
        for (int i = 0; i < text.length(); i++) {
            array[i] = Character.getNumericValue(text.charAt(i));
        }

        List<Integer> gerade = new ArrayList<>();
        List<Integer> ungerade = new ArrayList<>();

        //Aufteilen in gerade/ungerade
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                gerade.add(array[i]);
            else
                ungerade.add(array[i]);

        }

        //Sortieren und zusammenfügen der Arraylists
        Collections.sort(gerade);
        Collections.sort(ungerade);
        gerade.addAll(ungerade);

        //Stringbuilder zum umwandeln der Arraylist
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < gerade.size(); i++) {
            int a = gerade.get(i);
            stringbuilder.append(a);
        }

        String sortiert = stringbuilder.toString();

        TextView ausgabe = findViewById(R.id.textViewResponse);
        ausgabe.setText(sortiert);



    }
}
