package controller;

import java.util.ArrayList;
import java.util.List;

import model.Event;

public class EventController {

    private List eventList;

    public List getListEvents() {
        eventList = new ArrayList<Event>();
        eventList.add(new Event("Futebol de cria"));
        eventList.add(new Event("Show do Busco Esposa"));
        eventList.add(new Event("Festa Junina"));
        eventList.add(new Event("Igreja"));
        eventList.add(new Event("Filme da Barbie"));

        return eventList;
    }

    public ArrayList<String> spinnerData() {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < getListEvents().size(); i++) {
            Event obj = (Event) getListEvents().get(i);
            data.add(obj.getEventName());
        }
        return data;
    }

}
