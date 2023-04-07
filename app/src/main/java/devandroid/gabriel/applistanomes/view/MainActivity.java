package devandroid.gabriel.applistanomes.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.gabriel.applistanomes.R;
import model.Person;

public class MainActivity extends AppCompatActivity {
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person = new Person();

    }
}