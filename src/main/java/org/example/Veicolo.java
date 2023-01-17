package org.example;

import java.util.ArrayList;

public class Veicolo {
    private String id;

    private ArrayList<Misura> misure;

    public Veicolo(String id) {
        this.id = id;
        misure = new ArrayList<Misura>();
    }

    public void setMisura(Misura misura, int index) {
        misure.add(index, misura);
    }

    public Misura getMisura(int index) {
        return misure.get(index);
    }

    public ArrayList<Misura> getMisure() {
        return misure;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "id='" + id + '\'' +
                ", misure=" + misure +
                '}';
    }
}
