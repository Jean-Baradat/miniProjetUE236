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

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ListViewExample";

    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView)findViewById(R.id.listView);
        this.button = (Button)findViewById(R.id.button);

        // CHOICE_MODE_NONE: (Default)
        // (listView.setItemChecked(..) doest not work with CHOICE_MODE_NONE).
        // CHOICE_MODE_SINGLE:
        // CHOICE_MODE_MULTIPLE:
        // CHOICE_MODE_MULTIPLE_MODAL:
        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick: " +position);
                CheckedTextView v = (CheckedTextView) view;
                boolean currentCheck = v.isChecked();
                Contact contact = (Contact) listView.getItemAtPosition(position);
                contact.setActive(!currentCheck);
            }
        });
        //

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printSelectedItems();
            }
        });

        this.initListViewData();
    }

    private void initListViewData()  {
        Contact Jean = new Contact("Jean", "+330601020304", false);
        Contact Lucie = new Contact ("Lucie", "+330601020304", false);
        Contact Salome = new Contact ("Salomé", "+330601020304", false);
        Contact Henri = new Contact ("Henri", "+330601020304", false);
        Contact Valentine = new Contact ("Valentine", "+330601020304", false);
        Contact Adelaide = new Contact ("Adélaïde", "+330601020304", false);
        Contact Mathilde = new Contact ("Mathilde", "+330601020304", false);
        Contact Emma = new Contact ("Emma", "+330601020304", false);
        Contact Dave = new Contact ("Dave", "+330601020304", false);
        Contact Lou = new Contact ("Lou", "+330601020304", false);
        Contact Yannis = new Contact ("Yannis", "+330601020304", false);
        Contact Achille = new Contact ("Achille", "+330601020304", false);
        Contact Gregory = new Contact ("Grégory", "+330601020304", false);
        Contact Anthony = new Contact ("Anthony", "+330601020304", false);
        Contact Océane = new Contact ("Océane", "+330601020304", false);
        Contact Jean_Marie = new Contact ("Jean-Marie", "+330601020304", false);
        Contact Alexandre = new Contact ("Alexandre", "+330601020304", false);
        Contact Germaine = new Contact ("Germaine", "+330601020304", false);
        Contact Titouan = new Contact ("Titouan", "+330601020304", false);
        Contact Lucas = new Contact ("Lucas", "+330601020304", false);
        Contact Melodie = new Contact ("Mélodie", "+330601020304", false);

        Contact[] contacts = new Contact[]
                {Jean,
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
                        Anthony,
                        Océane,
                        Jean_Marie,
                        Alexandre,
                        Germaine,
                        Titouan,
                        Lucas,
                        Melodie};

        // android.R.layout.simple_list_item_checked:
        // ListItem is very simple (Only one CheckedTextView).
        ArrayAdapter<Contact> arrayAdapter
                = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_multiple_choice , contacts);

        this.listView.setAdapter(arrayAdapter);

        for(int i=0;i< contacts.length; i++ )  {
            this.listView.setItemChecked(i,contacts[i].isActive());
        }
    }

    // When user click "Print Selected Items".
    public void printSelectedItems()  {

        SparseBooleanArray sp = listView.getCheckedItemPositions();

        StringBuilder sb= new StringBuilder();

        for(int i=0;i<sp.size();i++){
            if(sp.valueAt(i)==true){
                Contact contact= (Contact) listView.getItemAtPosition(i);
                // Or:
                // String s = ((CheckedTextView) listView.getChildAt(i)).getText().toString();
                //
                String s= contact.getContactName();
                sb = sb.append(" "+s);
            }
        }
        Toast.makeText(this, "Selected items are: "+sb.toString(), Toast.LENGTH_LONG).show();
    }

}
