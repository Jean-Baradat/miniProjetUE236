package com.groupea.mini_projet_ue236;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = "ListViewExample";
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById (R.id.list_view);
        this.button = (Button) findViewById (R.id.button_next);

        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        this.listView.setOnClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.i(TAG, "onItemClick" + position);
                CheckedTextView v = (CheckTextView) view;
                boolean currentCheck = v.isChecked;
                Contacts contact = (Contacts) listView.getItemAtPosition(position);
                contact.setActive(!currentCheck);
            }
        });

        this.button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                validate_Next();
            }
        });

        this.initListViewData();
    }

    //Reprendre la liste de Salomé
    private void initListViewData
    {
        Contacts Jean = new Contacts("Jean");
        Contacts Lucie = new Contacts ("Lucie");
        Contacts Salomé = new Contacts ("Salomé");
        Contacts Henri = new Contacts ("Henri");
        Contacts Valentine = new Contacts ("Valentine");
        Contacts Adélaïde = new Contacts ("Adélaïde");
        Contacts Mathilde = new Contacts ("Mathilde");
        Contacts Emma = new Contacts ("Emma");
        Contacts Dave = new Contacts ("Dave");
        Contacts Lou = new Contacts ("Lou");
        Contacts Yannis = new Contacts ("Yannis");
        Contacts Achille = new Contacts ("Achille");
        Contacts Grégory = new Contacts ("Grégory");
        Contacts Anthony = new Contacts ("Anthony");
        Contacts Océane = new Contacts ("Océane");
        Contacts Jean_Marie = new Contacts ("Jean-Marie");
        Contacts Alexandre = new Contacts ("Alexandre");
        Contacts Germaine = new Contacts ("Germaine");
        Contacts Titouan = new Contacts ("Titouan");
        Contacts Lucas = new Contacts ("Lucas");
        Contacts Mélodie = new Contacts ("Mélodie");

        Contacts[] contacts = new Contacts[]
        {
            jean,
            lucie,
            salomé,
            henri,
            valentine,
            adélaïde,
            mathilde,
            emma,
            dave,
            lou,
            yannis,
            achille,
            grégory,
            anthony,
            océane,
            jean-marie,
            alexandre,
            germaine,
            titouan,
            lucas,
            mélodie
        };

        ArrayAdapter<Contacts> arrayAdapter = new ArrayAdapter<Contacts>(this, android.R.layout.simple_list_item_checked, contacts);

        this.listView.setAdapter(arrayAdapter);

        for (int i = 0 ; i < contacts.length ; i++)
        {
            this.listView.setItemChecked(i, contacts[i].isActive());
        }
    }

    public void validateNext()
    {
        SparseBooleanArray sp = listView.getCheckedItemPositions();

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < sp.size() ; i++)
        {
            if (sp.valueAt(i) == true)
            {
                Contacts contact = (Contacts) listView.getItemAtPosition(i);
                String s = contact.getContactName();
                sb = sb.append("" + s);
            }
        }
    }
}