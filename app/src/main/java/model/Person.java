package model;

public class Person {

    private String firstName;
    private String surname;
    private String listEvent;
    private Double telephone;

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getListEvent() {
        return listEvent;
    }

    public void setListEvent(String listEvent) {
        this.listEvent = listEvent;
    }

    public Double getTelephone() {
        return telephone;
    }

    public void setTelephone(Double telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", listEvent='" + listEvent + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
