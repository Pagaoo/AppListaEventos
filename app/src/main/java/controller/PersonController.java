package controller;

import android.util.Log;

import model.Person;

public class PersonController {
    public void save(Person person) {
        Log.i("PersonController", "Salvo: " + person.toString());
    }
}
