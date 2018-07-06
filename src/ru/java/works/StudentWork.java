package ru.java.works;


public class StudentWork {
    private Type type;
    private String discipline;
    private Integer number;
    private String theme;
    private GregorianCalendar deliveryDate;
    private Status status;

    public StudentWork(){}

    public StudentWork(Type type, String discipline, Integer number, String theme, GregorianCalendar deliveryDate, Status status) {
        this.type = type;
        this.discipline = discipline;
        this.number = number;
        this.theme = theme;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public GregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(GregorianCalendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
