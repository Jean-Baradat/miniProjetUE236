package com.groupea.mini_projet_ue236;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.listContacts);
        ArrayAdapter<String> tab = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice);
        /*tab.add("jeanne  06 00 00 00 00");
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
        tab.add("Staline  06 00 00 00 00");*/


        this.initListViewData();
    }

    private void initListViewData()
    {
        Contacts Lucie = new Contacts("Dumas", "Lucie", "+33601020304");
        Contacts Adélaïde = new Contacts("Machon", "Adélaïde", "+33602040608");
        Contacts Jean = new Contacts("Baradat", "Jean", "+33601030507");
        Contacts Salomé = new Contact("Cliquennois", "Salomé", "+33605060708");
        Contacts Gérard = new Contact("Menvussa", "Gérard", "+33611223344");
        Contacts Winnie = new Contact("L'ourson", "Winnie", "+33655667788");
        Contacts Zinédine = new Contact("Zidane", "Zinedine", "+33611335577");
        Contacts Didier = new Contact("Deschamps", "Didier", "+33622446688");
        Contacts Alexa = new Contact("Amazon", "Alexa", "+33698765432");
        Contacts Lucas = new Contacts("Dupont", "Lucas", "+33601020304");
        Contacts Julie = new Contacts("Uni", "Julie", "+33602040608");
        Contacts Hortense = new Contacts("Priviate", "Hortense", "+33601030507");
        Contacts Jerry = new Contact("Duoup", "Jerry", "+33605060708");
        Contacts Jeanne = new Contact("Ossecourre", "Jeanne", "+33611223344");
        Contacts Germaine = new Contact("Langlisse", "Germaine", "+33655667788");
        Contacts Gertrude = new Contact("Labiche", "Gertrude", "+33611335577");
        Contacts Alexandre = new Contact("Dufour", "Alexandre", "+33622446688");
        Contacts Grégory = new Contact("Flotti", "Grégory", "+33698765432");

        Contacts[] contacts = new Contacts[]
        {
            Lucie, Adélaïde, Jean, Salomé, Gérard, Winnie, Zinédine, Didier, Alexa, Lucas, Julie, Hortense, Jerry, Jeanne, Germaine, Gertrude, Alexandre, Grégory
        };
    }

    public void boutonNextActiviteContactSelectionne(View v)
    {
        Intent intent = new Intent(this, ContactSelectionne.class);
        startActivity(intent);
    }
}

/*tab.add(new Contact("Dumas", "Lucie", "+33601020304"));
        tab.add(new Contact("Machon", "Adélaïde", "+33602040608"));
        tab.add(new Contact("Baradat", "Jean", "+33601030507"));
        tab.add(new Contact("Cliquennois", "Salomé", "+33605060708"));
        tab.add(new Contact("Menvussa", "Gérard", "+33611223344"));
        tab.add(new Contact("L'ourson", "Winnie", "+33655667788"));
        tab.add(new Contact("Zidane", "Zinedine", "+33611335577"));
        tab.add(new Contact("Deschamps", "Didier", "+33622446688"));
        tab.add(new Contact("Amazon", "Alexa", "+33698765432"));
        tab.add(new Contact("Contact", "Jean-Jacques", "+33697531864"));
        tab.add(new Contact("Dumas", "Lucie", "+33601020304"));
        tab.add(new Contact("Machon", "Adélaïde", "+33602040608"));
        tab.add(new Contact("Baradat", "Jean", "+33601030507"));
        tab.add(new Contact("Cliquennois", "Salomé", "+33605060708"));
        tab.add(new Contact("Menvussa", "Gérard", "+33611223344"));
        tab.add(new Contact("L'ourson", "Winnie", "+33655667788"));
        tab.add(new Contact("Zidane", "Zinedine", "+33611335577"));
        tab.add(new Contact("Deschamps", "Didier", "+33622446688"));
        tab.add(new Contact("Amazon", "Alexa", "+33698765432"));
        tab.add(new Contact("Contact", "Jean-Jacques", "+33697531864"));*/