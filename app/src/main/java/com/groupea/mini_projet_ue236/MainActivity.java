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
import android.widget.Toast;
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
                Contacts user = (Contacts) listView.getItemAtPosition(position);
                user.setActive(!currentCheck);
            }
        });

        this.button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                printSelectedItems();
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
    }
}