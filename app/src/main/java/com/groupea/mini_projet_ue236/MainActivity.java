package com.groupea.mini_projet_ue236;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.listContacts);
        ArrayAdapter<String> tab = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice);
        tab.add("jeanne  06 00 00 00 00");
        tab.add("oskour  06 00 00 00 00");
        tab.add("goulag  06 00 00 00 00");
        tab.add("Hortense  06 00 00 00 00");
        tab.add("tubercule  06 00 00 00 00");
        tab.add("jeanluc  06 00 00 00 00");
        tab.add("Philippe  06 00 00 00 00");
        tab.add("Poutou  06 00 00 00 00");
        tab.add("eric  06 00 00 00 00");
        tab.add("antoine  06 00 00 00 00");
        tab.add("franssoua  06 00 00 00 00");
        tab.add("hollande  06 00 00 00 00");
        tab.add("Jean  06 00 00 00 00");
        tab.add("Marie  06 00 00 00 00");
        tab.add("Le Pen  06 00 00 00 00");
        tab.add("Joseph  06 00 00 00 00");
        tab.add("Staline  06 00 00 00 00");
        tab.add("jeanne  06 00 00 00 00");
        tab.add("oskour  06 00 00 00 00");
        tab.add("goulag  06 00 00 00 00");
        tab.add("Hortense  06 00 00 00 00");
        tab.add("tubercule  06 00 00 00 00");
        tab.add("jeanluc  06 00 00 00 00");
        tab.add("Philippe  06 00 00 00 00");
        tab.add("Poutou  06 00 00 00 00");
        tab.add("eric  06 00 00 00 00");
        tab.add("antoine  06 00 00 00 00");
        tab.add("franssoua  06 00 00 00 00");
        tab.add("hollande  06 00 00 00 00");
        tab.add("Jean  06 00 00 00 00");
        tab.add("Marie  06 00 00 00 00");
        tab.add("Le Pen  06 00 00 00 00");
        tab.add("Joseph  06 00 00 00 00");
        tab.add("Staline  06 00 00 00 00");


        list.setAdapter(tab);
    }

    public void boutonNextActiviteContactSelectionne(View v){
        Intent intent = new Intent(this, ContactSelectionne.class);
        startActivity(intent);
    }
}