package devandroid.gabriel.applistanomes.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.gabriel.applistanomes.R;
import model.Person;

public class MainActivity extends AppCompatActivity {
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

        person = new Person();

        person.setFirstName("Gabriel");
        person.setSurname("Paganini");
        person.setListEvent("Futzinho");
        person.setTelephone("27 9 99610118");

        editFirstName = findViewById(R.id.editFirstName);
        editSurname = findViewById(R.id.editSurname);
        editEvent = findViewById(R.id.editEvent);
        editTelephone = findViewById(R.id.editTelephone);

        btnClear = findViewById(R.id.btnClear);
        btnSave = findViewById(R.id.btnSave);
        btnDone = findViewById(R.id.btnDone);

        editFirstName.setText(person.getFirstName());
        editSurname.setText(person.getSurname());
        editEvent.setText(person.getListEvent());
        editTelephone.setText(person.getTelephone());

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFirstName.setText("");
                editSurname.setText("");
                editEvent.setText("");
                editTelephone.setText("");
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setFirstName(editFirstName.getText().toString());
                person.setSurname(editSurname.getText().toString());
                person.setListEvent(editEvent.getText().toString());
                person.setTelephone(editTelephone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvando " + person.toString(), Toast.LENGTH_LONG).show();
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Saindo do aplicativo...", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        Log.i("PersonInfo", person.toString());
    }
}