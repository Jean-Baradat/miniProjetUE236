package com.groupea.mini_projet_ue236;

// Import de diverses bibliothèques
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ListView;
import java.io.Serializable;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

// AppCompatActivity : supporte les màj de librairies || Sérialization : les objets deviennent un
// tableau d'octets
public class MainActivity extends AppCompatActivity implements Serializable {

    private ListView listView;
    private ArrayList<Contact> listeDesContacts;
    private ArrayList<Contact> listeDesContactsSelectionnes;

    // à la création de l'application (= à son ouverture), récupère les données initiales contenues
    // dans savedInstanceState
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // pour que notre code puisse être lu en addition du code existant déjà dans le onCreate()
        super.onCreate(savedInstanceState);
        // pose l'interface visuelle depuis les ressources (R) correspondant à activity_main.xml
        setContentView(R.layout.activity_main);

        // appel de la checkbox qui coche toutes les autres checkbox de la listView grâce à son ID
        // "checkBoxCheckAll"
        CheckBox checkBoxCheckAll = findViewById(R.id.checkBoxCheckAll);

        // appel de la listView depuis son ID listView
        this.listView = findViewById(R.id.listView);

        // défini le mode de choix des checkbox en MULTIPLE
        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


        // Ceci concerne le comportement des checkbox au sein de la listView.
        /* écoute du clic sur la listView, avec en paramètre l'adapter où a lieu le clic, la
        view dans l'adapterView qui a été cliquée (l'adapter s'en occupe), la position de la
        vue dans l'adapter, et l'id de l'item qui a été cliqué */
        this.listView.setOnItemClickListener((parent, view, position, id) -> {

            // ce qu'il se passe lorsque l'on a cliqué sur une checkbox de la listView
            CheckedTextView v = (CheckedTextView) view;
            // permettra de signifier si la vue correspondant à la checkbox de la listView est
            // cochée ou non grâce à true ou false
            boolean currentCheck = v.isChecked();
            // récupère la position de la ckeckbox qui vient d'être cochée au sein de la listView
            // qui contient les objets contacts
            Contact contact = (Contact) listView.getItemAtPosition(position);
            // permet de changer l'état de la checkbox lorsque l'on clique dessus en tenant compte
            // de son état précédent (true devient false, false devient true)
            contact.setActive(!currentCheck);

            //NE FONCTIONNE PAS : pour déselectionner la case checkbox all ; initialement testé avec
            //isChecked, mais rien n'y fait, donc nique
            /*if(contact.setActive(!currentCheck)){
                checkBoxCheckAll.setSelected(false);
            }*/
        });


        // Ceci concerne la checkbox qui coche toutes les autres présentes dans la listView /!\
        // N'est pas dans la listView !
        checkBoxCheckAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            // Appelé lorsque l'état coché d'un bouton composé a changé, ici donc sur notre checkbox
            // unique qui sélectionne toutes les autres.
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                // si elle est cochée
                if (checkBoxCheckAll.isChecked())
                {
                    // pour toutes les checkbox le long de la listView
                    for (int i = 0 ; i < listeDesContacts.size() ; i++)
                    {
                        // toutes les checkbox de la listView sont cochées ensemble
                        listView.setItemChecked(i, true);
                    }
                }
                // si on la décoche manuellement
                else
                {
                    // pour toutes les checkbox le long de la listView
                    for (int i = 0 ; i < listeDesContacts.size() ; i++)
                    {
                        // toutes les checkbox de la listView sont décochées ensemble (uniquement
                        // lorsque nous appuyons sur la checkbox qui les coche toutes)
                        listView.setItemChecked(i, false);
                        // TODO : ajouter le truc qui permet au checkBoxCheckAll d être décoché
                        //  quand un contact est désélectionné
                        // TODO BIS : tenter de faire comme le currentCheck
                    }
                }
            }
        });

        // Execution de la methode initListViewData : mise en place des elements de la liste
        // ListView
        this.initListViewData();
    }

    //Content Providers

    public void readContacts() {
        //On va chercher les contacts dans l'appli contact
        ContentResolver cr = getContentResolver();
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projection = null;
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;
        Cursor cur = cr.query(uri, projection, selection, selectionArgs, sortOrder);

        //On vérifie que l'app a bien récupéré au moins un contact
        if (cur.getCount() > 0) {

            //Passe à l'élément suivent
            while (cur.moveToNext()){
                //Pour avoir l'index de la colonne, on peut utiliser son nom et pour avoir ce dernier, on cherche son id dans l'app android
                @SuppressLint("Range") String nom = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                @SuppressLint("Range") String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));

                //Il n'existe pas de formule pour prendre le numéro de tel mais on peut contourner ça avec une formule
                //qui va nous dire 1 si le contact a un tel et 0 si il n'en a pas

                @SuppressLint("Range") int numero = cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                //Condition : si le nombre retourné est 1 on va chercher dans un autre provider le numéro

                if (numero==1){

                    Uri uri2 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                    String selection2 = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "= ?";
                    String[] selectionArgs2 = new String[]{id};
                    Cursor cur2 = cr.query(uri2, projection, selection2, selectionArgs2, sortOrder);

                    //On applique une boucle while pour récupérer les numéros de téléphone

                    while (cur2.moveToNext()){
                        @SuppressLint("Range") String phone = cur2.getString(cur2.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }
                }
            }
        }
    }

    // Créé les objets contacts, ajoutes dans un arrayList, gestion du coche solo, creation de
    // l'adapter
    private void initListViewData() {


        // Création des objets Contact
        Contact Jean = new Contact(
                "Jean Baradat", "0033601030507",false);
        Contact Lucie = new Contact (
                "Lucie Dumas", "0033600000000", false);
        Contact Salome = new Contact (
                "Salomé Cliquennois", "0033601030507", false);
        Contact Henri = new Contact (
                "Henri Michaud", "0033601020304", false);
        Contact Valentine = new Contact (
                "Valentine Maillard", "0033601020304", false);
        Contact Adelaide = new Contact (
                "Adélaïde Machon", "0033601020304", false);
        Contact Mathilde = new Contact (
                "Mathilde Titi", "0033601020304", false);
        Contact Emma = new Contact (
                "Emma Simpson", "0033601020304", false);
        Contact Dave = new Contact (
                "Dave Strider", "0033601020304", false);
        Contact Lou = new Contact (
                "Lou Pépèle", "0033601020304", false);
        Contact Yannis = new Contact (
                "Yannis Kuro", "0033601020304", false);
        Contact Achille = new Contact (
                "Achille Talon", "0033601020304", false);
        Contact Gregory = new Contact (
                "Grégory Flotti", "0033601020304", false);
        Contact Winnie = new Contact (
                "Winnie L'Ourson", "0033611223344", false);
        Contact Gerard = new Contact (
                "Gérard Menvussa", "0033611223344", false);
        Contact Jean_Marie = new Contact (
                "Jean-Marie Saint-Joseph", "0033601020304", false);
        Contact Zinedine = new Contact (
                "Zinedine Zidane", "003311335577", false);
        Contact Germaine = new Contact (
                "Germaine Langlisse", "0033601020304", false);
        Contact Titouan = new Contact (
                "Titouan Gaming", "0033601020304", false);
        Contact Denis = new Contact (
                "Denis Brogniart", "0033600000000", false);
        Contact Didier = new Contact (
                "Didier Deschamps", "0033600000001", false);

        // Ajout de ceux-ci dans un arrayList
        this.listeDesContacts = new ArrayList<Contact>();
        listeDesContacts.add(Jean);
        listeDesContacts.add(Lucie);
        listeDesContacts.add(Salome);
        listeDesContacts.add(Henri);
        listeDesContacts.add(Valentine);
        listeDesContacts.add(Adelaide);
        listeDesContacts.add(Mathilde);
        listeDesContacts.add(Emma);
        listeDesContacts.add(Dave);
        listeDesContacts.add(Lou);
        listeDesContacts.add(Yannis);
        listeDesContacts.add(Achille);
        listeDesContacts.add(Gregory);
        listeDesContacts.add(Winnie);
        listeDesContacts.add(Gerard);
        listeDesContacts.add(Jean_Marie);
        listeDesContacts.add(Zinedine);
        listeDesContacts.add(Germaine);
        listeDesContacts.add(Titouan);
        listeDesContacts.add(Denis);
        listeDesContacts.add(Didier);

        // ArrayAdapter qui permet d'utiliser le layout par défaut spécifiquement prévu pour les
        // sélections multiples et de l'appliquer aux checkbox de notre listView
        ArrayAdapter<Contact> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, getListeDesContacts());
        // Met en place l'arrayAdapter
        this.listView.setAdapter(arrayAdapter);

        // pour toutes les checkbox le long de la listView
        for(int i = 0 ; i < listeDesContacts.size() ; i++ ) {

            // lorsque la checkbox dans la listView est cochée, passe en true, et récupère son index
            // pour ne pas l'oublier au scroll
            this.listView.setItemChecked(i, listeDesContacts.get(i).isActive());
        }
    }

    // retourne la liste des contacts
    public ArrayList<Contact> getListeDesContacts() {
        return listeDesContacts;
    }

    // retourne la liste des contacts sélectionnés
    public ArrayList<Contact> getListeDesContactsSelectionnes() {
        return listeDesContactsSelectionnes;
    }

    // Créer une nouvelle arrayList contenant les contacts choisis précédemment (merci aux index)
    // afin de pouvoir les transporter plus facilement à la prochaine activité
    public void buttonNextActivityContactSelectionne(View v){

        // création de l'arrayList
        this.listeDesContactsSelectionnes = new ArrayList<Contact>();
        // récupère les positions des checkbox cochées au sein de la listView
        SparseBooleanArray sp = listView.getCheckedItemPositions();

        // pour toute la liste de contacts
        for(int i = 0 ; i < getListeDesContacts().size() ; i++) {

            // si une checkbox cochée est détectée peu importe où dans la listView
            if (sp.valueAt(i) == true) {

                // son index est ajouté dans le nouvel array qui sera transporté à l'activité 2
                this.listeDesContactsSelectionnes.add(listeDesContacts.get(i));
            }
        }

        // fait le lien entre cette activité et l'activité ContactSelectionne
        Intent intent = new Intent(this, ContactSelectionne.class);
        // récupère la liste des contacts sélectionnés, avec ce qui servira de clé sur l'autre
        // activité : "listSelectedContacts"
        intent.putExtra("listSelectedContacts", listeDesContactsSelectionnes);
        // lance l'intent décrit
        startActivity(intent);
    }
}
