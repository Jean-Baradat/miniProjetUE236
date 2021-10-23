package com.groupea.mini_projet_ue236;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContactSelectionne extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_selectionne);
    }

    public void boutonNextActiviteMainActivity(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void boutonValider(View view)
    {
        Toast.makeText(this, "Vous avez validé, merci !", Toast.LENGTH_SHORT).show();
    }
}