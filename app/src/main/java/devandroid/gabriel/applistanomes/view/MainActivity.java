package devandroid.gabriel.applistanomes.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import controller.EventController;
import controller.PersonController;
import devandroid.gabriel.applistanomes.R;
import model.Event;
import model.Person;

public class MainActivity extends AppCompatActivity {

    PersonController personController;
    EventController eventController;
    Person person;
    List<Event> eventList;
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

        personController = new PersonController(MainActivity.this);
        person = new Person();
        personController.find(person);

        eventController = new EventController();
        eventList = eventController.getListEvents();

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

            personController.clear();
        });

        btnSave.setOnClickListener(view -> {
            person.setFirstName(editFirstName.getText().toString());
            person.setSurname(editSurname.getText().toString());
            person.setListEvent(editEvent.getText().toString());
            person.setTelephone(editTelephone.getText().toString());

            Toast.makeText(MainActivity.this, "Salvando " + person.toString(), Toast.LENGTH_LONG).show();
            personController.save(person);
        });

        btnDone.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Saindo do aplicativo...", Toast.LENGTH_LONG).show();
            finish();
        });

        Log.i("PersonInfo", person.toString());
    }
}