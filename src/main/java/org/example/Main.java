package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parser dom = new Parser();
        ArrayList<Veicolo> veicoli = new ArrayList<Veicolo>();
        boolean checkSoglia = true;
        ArrayList<Long> timestampList = new ArrayList<Long>();

        try{
            veicoli = dom.parseDocument("src/main/resources/veicoli.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il valore di soglia: ");
        float soglia = scanner.nextFloat();

        for(Veicolo veicolo : veicoli){

            for(Misura misura : veicolo.getMisure()){
                if(misura.getTemperatura() > soglia){
                    checkSoglia = false;
                    timestampList.add(misura.getData_ora());
                }
            }
            System.out.println("Veicolo: " + veicolo.getId() + " - " + checkSoglia + "\n");
            System.out.println("Timestamp: " + timestampList + "\n\n");
        }
    }
}