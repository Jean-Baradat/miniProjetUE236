package com.groupea.mini_projet_ue236;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import java.io.Serializable;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Serializable
{

    public static final String TAG = "ListViewExample";

    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView)findViewById(R.id.listView);
        this.button = (Button)findViewById(R.id.button);

        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.i(TAG, "onItemClick: " +position);
                CheckedTextView v = (CheckedTextView) view;
                boolean currentCheck = v.isChecked();
                Contact contact = (Contact) listView.getItemAtPosition(position);
                contact.setActive(!currentCheck);
            }
        });

        this.button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                printSelectedItems();
            }
        });

        this.initListViewData();
    }

    private void initListViewData()
    {
        Contact Jean = new Contact("Jean Baradat", "+33601030507", false);
        Contact Lucie = new Contact ("Lucie Dumas", "+33602040608", false);
        Contact Salome = new Contact ("Salomé Cliquennois", "+33601030507", false);
        Contact Henri = new Contact ("Henri Michaud", "+330601020304", false);
        Contact Valentine = new Contact ("Valentine Maillard", "+330601020304", false);
        Contact Adelaide = new Contact ("Adélaïde Machon", "+330601020304", false);
        Contact Mathilde = new Contact ("Mathilde Titi", "+330601020304", false);
        Contact Emma = new Contact ("Emma Amore", "+330601020304", false);
        Contact Dave = new Contact ("Dave Strider", "+330601020304", false);
        Contact Lou = new Contact ("Lou Pépèle", "+330601020304", false);
        Contact Yannis = new Contact ("Yannis Kuro", "+330601020304", false);
        Contact Achille = new Contact ("Achille Talon", "+330601020304", false);
        Contact Gregory = new Contact ("Grégory Flotti", "+330601020304", false);
        Contact Winnie = new Contact ("Winnie L'Ourson", "+33611223344", false);
        Contact Gerard = new Contact ("Gérard Menvussa", "+33611223344", false);
        Contact Jean_Marie = new Contact ("Jean-Marie Saint-Joseph", "+330601020304", false);
        Contact Zinedine = new Contact ("Zinedine Zidane", "+33611335577", false);
        Contact Germaine = new Contact ("Germaine Langlisse", "+330601020304", false);
        Contact Titouan = new Contact ("Titouan Gaming", "+330601020304", false);
        Contact Alexa = new Contact ("Alexa Amazon", "+33698765432", false);
        Contact Didier = new Contact ("Didier Deschamps", "+33622446688", false);


        Contact[] contacts = new Contact[]
        {
            Jean,
            Lucie,
            Salome,
            Henri,
            Valentine,
            Adelaide,
            Mathilde,
            Emma,
            Dave,
            Lou,
            Yannis,
            Achille,
            Gregory,
            Winnie,
            Gerard,
            Jean_Marie,
            Zinedine,
            Germaine,
            Titouan,
            Alexa,
            Didier
        };

        ArrayAdapter<Contact> arrayAdapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_multiple_choice , contacts);

        this.listView.setAdapter(arrayAdapter);

        for(int i = 0 ; i < contacts.length ; i++ )
        {
            this.listView.setItemChecked(i,contacts[i].isActive());
        }
    }

    public void printSelectedItems()
    {
        SparseBooleanArray sp = listView.getCheckedItemPositions();

        StringBuilder sb= new StringBuilder();

        for(int i = 0 ; i < sp.size() ; i++)
        {
            if(sp.valueAt(i)==true)
            {
                Contact contact= (Contact) listView.getItemAtPosition(i);
                String s= contact.getContactName();
                sb = sb.append(" "+s);
            }
        }
        //Toast.makeText(this, "Selected items are: "+sb.toString(), Toast.LENGTH_LONG).show();
    }
    public void boutonNextActiviteMainActivity(View view)
    {
        Intent intent = new Intent(this, ContactSelectionne.class);
        //intent.putExtra("CONTACT_NAMES", new String[] {contactName, phoneContact});
        startActivity(intent);
    }
}
