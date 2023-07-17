package controller;

import java.util.ArrayList;
import java.util.List;

import model.Event;

public class EventController {

    private List eventList;

    public List getListaEvents() {
        eventList = new ArrayList<Event>();
        eventList.add(new Event("Futebol de cria"));
        eventList.add(new Event("Show do Busco Esposa"));
        eventList.add(new Event("Festa Junina"));
        eventList.add(new Event("Igreja"));
        eventList.add(new Event("Filme da Barbie"));

        return eventList;
    }

}
