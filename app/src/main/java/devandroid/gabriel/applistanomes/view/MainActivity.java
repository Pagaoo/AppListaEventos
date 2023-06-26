package devandroid.gabriel.applistanomes.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import controller.PersonController;
import devandroid.gabriel.applistanomes.R;
import model.Person;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor events;
    public static final String NOME_PREFERENCES = "pref_event";
    PersonController personController;
    Person person;
    EditText editFirstName;
    EditText editSurname;
    EditText editEvent;
    EditText editTelephone;
    Button btnClear;
    Button btnSave;
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        events = preferences.edit();
        personController = new PersonController();
        person = new Person();

        person.setFirstName(preferences.getString("firstName", ""));
        person.setSurname(preferences.getString("surname", ""));
        person.setTelephone(preferences.getString("telephone",""));
        person.setListEvent(preferences.getString("event", ""));

        editFirstName = findViewById(R.id.editFirstName);
        editSurname = findViewById(R.id.editSurname);
        editTelephone = findViewById(R.id.editTelephone);
        editEvent = findViewById(R.id.editEvent);

        editFirstName.setText(person.getFirstName());
        editSurname.setText(person.getSurname());
        editTelephone.setText(person.getTelephone());
        editEvent.setText(person.getListEvent());

        btnClear = findViewById(R.id.btnClear);
        btnSave = findViewById(R.id.btnSave);
        btnDone = findViewById(R.id.btnDone);

        btnClear.setOnClickListener(view -> {
            editFirstName.setText("");
            editSurname.setText("");
            editEvent.setText("");
            editTelephone.setText("");

            events.clear();
            events.apply();
        });

        btnSave.setOnClickListener(view -> {
            person.setFirstName(editFirstName.getText().toString());
            person.setSurname(editSurname.getText().toString());
            person.setListEvent(editEvent.getText().toString());
            person.setTelephone(editTelephone.getText().toString());

            Toast.makeText(MainActivity.this, "Salvando " + person.toString(), Toast.LENGTH_LONG).show();
            events.putString("firstName", person.getFirstName());
            events.putString("surname", person.getSurname());
            events.putString("event", person.getListEvent());
            events.putString("telephone", person.getTelephone());
            events.apply();
            personController.save(person);
        });

        btnDone.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Saindo do aplicativo...", Toast.LENGTH_LONG).show();
            finish();
        });

        Log.i("PersonInfo", person.toString());
    }
}