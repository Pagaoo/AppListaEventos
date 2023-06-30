package controller;

import android.content.SharedPreferences;
import android.util.Log;

import devandroid.gabriel.applistanomes.view.MainActivity;
import model.Person;

public class PersonController {

    SharedPreferences preferences;
    SharedPreferences.Editor events;
    public static final String NOME_PREFERENCES = "pref_event";


    public PersonController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        events = preferences.edit();
    }

    public void save(Person person) {
        events.putString("firstName", person.getFirstName());
        events.putString("surname", person.getSurname());
        events.putString("event", person.getListEvent());
        events.putString("telephone", person.getTelephone());
        events.apply();
    }

    public Person find(Person person) {
        person.setFirstName(preferences.getString("firstName", ""));
        person.setSurname(preferences.getString("surname", ""));
        person.setTelephone(preferences.getString("telephone",""));
        person.setListEvent(preferences.getString("event", ""));
        return person;
    }

    public void clear() {
        events.clear();
        events.apply();
    }
}
