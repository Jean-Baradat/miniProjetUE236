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
        ArrayAdapter<String> tab =
                new ArrayAdapter<String>(this, R.layout.checkbox);
        tab.add("Jean  06 00 00 00 00");
        tab.add("pierre  06 00 00 00 00");
        tab.add("thomas  06 00 00 00 00");
        tab.add("Jean  06 00 00 00 00");
        tab.add("pierre  06 00 00 00 00");
        tab.add("thomas  06 00 00 00 00");
        tab.add("Jean  06 00 00 00 00");
        tab.add("pierre  06 00 00 00 00");
        tab.add("thomas  06 00 00 00 00");
        tab.add("Jean  06 00 00 00 00");
        tab.add("pierre  06 00 00 00 00");
        tab.add("thomas  06 00 00 00 00");
        tab.add("Jean  06 00 00 00 00");
        tab.add("pierre  06 00 00 00 00");
        tab.add("thomas  06 00 00 00 00");
        tab.add("Jean  06 00 00 00 00");
        tab.add("pierre  06 00 00 00 00");

        list.setAdapter(tab);
    }

    public void boutonNextActiviteContactSelectionne(View v){
        Intent intent = new Intent(this, ContactSelectionne.class);
        startActivity(intent);
    }
}