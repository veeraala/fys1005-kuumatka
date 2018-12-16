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
//import java.util.Scanner;
import java.util.ArrayList;

public class Kuumatka {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Vertailu vertailu = new Vertailu();
        /*tässä verrataan kahta eri alkunopeus-aika-askel -yhdistelmää; metodi kysyy arvot
        vertailu.vertaa();
        */ 
        vertailu.vertaa();
        
        /*Tässä etsitään pienin mahdollinen nopeus; tarkkuus muokattavissa metodissa*
        System.out.println(vertailu.minNopeus(0.01,0.001));
        */
        
        /*tässä luodaan lista alkunopeuksista ja niitä vastaavista matka-ajoista kuvaajaa varten
        tarkkuus muutettavissa Mittauspiste -luokassa*
        ArrayList<Mittauspiste> tulokset = vertailu.nopeusvertailu(10.985, 0.1, 14);
        for(Mittauspiste piste: tulokset) {
            System.out.println(piste);
        }
        
        **/
    }
    
}
