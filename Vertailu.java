/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuumatka;

/**
 *
 * @author Veera
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Vertailu {
    
    public Vertailu(){
    }
    
    //seuraavalla matodilla vertailin mekaanisesti eri aika-askeleita löytääkseni sopivan)
    public void vertaa() {
        
        Simulaatio matka1 = new Simulaatio(alkunopeus(), aikaAskel());
        Simulaatio matka2 = new Simulaatio(alkunopeus(), aikaAskel());
        
        matka1.raportti();
        matka2.raportti();
    }
    
    public double minNopeus(double aikaAskel,double nopeusAskel) {
        double nopeus = 11;
        while(true) {
            Simulaatio matka = new Simulaatio(nopeus-nopeusAskel,aikaAskel);
            if(!matka.paaseeKuuhun()) {
                break;
            }
            nopeus = nopeus - nopeusAskel;
        }
        return nopeus;
    }
    
    public ArrayList<Mittauspiste> nopeusvertailu(double nopeus0, double nopeusEro, int nopeus1) {
        double nopeus = nopeus0;
        ArrayList<Mittauspiste> tulokset = new ArrayList<>();
        while(nopeus<=nopeus1) {
            Mittauspiste piste = new Mittauspiste(nopeus);
            tulokset.add(piste);
            nopeus += nopeusEro;
        }
        return tulokset;
    }
    
    public double alkunopeus() {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Alkunopeus (km/s): ");
        Double alkunopeus = Double.parseDouble(lukija.nextLine());
        return alkunopeus;
    }
    
    public double aikaAskel() {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Aika-askel (s): ");
        Double aikaAskel = Double.parseDouble(lukija.nextLine());
        return aikaAskel;
    }
}
