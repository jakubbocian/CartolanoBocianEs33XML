package org.example;

import java.sql.Timestamp;
import java.util.Date;

public class Misura {
    private float temperatura;
    private long data_ora;

    public Misura(float temperatura, long data_ora) {
        this.temperatura = temperatura;
        this.data_ora = data_ora;
    }

    @Override
    public String toString() {
        return "Misura{" +
                "temperatura=" + temperatura +
                ", data_ora=" + data_ora +
                '}';
    }

    public float getTemperatura() {
        return temperatura;
    }

    public long getData_ora() {
        return data_ora;
    }
}
