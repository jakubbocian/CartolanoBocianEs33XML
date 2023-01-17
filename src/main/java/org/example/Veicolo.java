package org.example;

public class Veicolo {
    private String id;

    private Misura[] misure;

    public Veicolo(String id) {
        this.id = id;
        misure = new Misura[2];
    }

    public void setMisura(Misura misura, int index) {
        this.misure[index] = misura;
    }

    public Misura getMisura(int index) {
        return misure[index];
    }

    public Misura[] getMisure() {
        return misure;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return "Veicolo: " + id + " - " + misure[0] + " - " + misure[1];
    }
}
