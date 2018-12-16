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
public class Simulaatio {
    private double nopeus;
    private double aika;
    private double paikka;
    private static final double kokonaisetaisyys = 384400;
    private static final double maaSade = 6371;
    private static final double kuuSade = 1738.2;
    private static final double kokonaismatka = kokonaisetaisyys-kuuSade-maaSade; 
        //matka maan pinnasta kuun pintaan;
    private Voima kuu;
    private Voima maa;
    private double aikaAskel;
    private boolean paaseeKuuhun = false;
    
    public Simulaatio(double alkunopeus, double askel) {
        this.nopeus = alkunopeus;
        this.aikaAskel = askel;
        this.aika = 0;
        this.paikka = 100;
        ///simulaatio alkaa ilmakehän ulkopuolelta, 100 km maanpinnasta
        this.kuu = new Voima(7.348*Math.pow(10,22));
        this.maa = new Voima(5.974*Math.pow(10,24));
        ///argumentteina maan ja kuun massat
         
   // }
     
   // public void aloita() {
        ///int testiluku = 1; ///käytössä vain ohjelmaa testatessa
        while(true) {
            double nopeus0 = this.nopeus;
            ///uusi nopeus saadaan v_1 = v_0 + I/m (p_1 = p_0 + I). 
            ///Impulssi-metodi antaa arvon I/m.
            this.nopeus = nopeus0 + kuu.impulssi(kokonaisetaisyys-maaSade-paikka, aikaAskel)
                    - maa.impulssi(maaSade+paikka, aikaAskel);
            //maan gravitaation luoma impulssi vaikuttaa negatiiviseen suuntaan koordinaatistossa
            double keskinopeus = (nopeus0 + nopeus)/2;
            this.paikka = paikka + keskinopeus*aikaAskel;
            this.aika = aika + aikaAskel;
            
            if(this.nopeus<=0) {
                break;
            }
            if(paikka>=kokonaismatka-100) {
                paaseeKuuhun = true;
                break;
            }
            
            /*System.out.println(aika + ", " + nopeus + ", " + paikka);
            testiluku = testiluku+1;
            if(testiluku > 2) {
                break;
            }*/ ///testi
        }
        
    }
    
    public boolean paaseeKuuhun() {
        return paaseeKuuhun;
    }
    
    public double matkaAika() {
        return aika;
    }
    
    public void raportti() {
        if(nopeus<=0) {
                System.out.println("Vauhti loppui hetkellä " + (aika/3600) 
                + "h etäisyydellä " + (kokonaismatka-paikka) + "km kuusta");
        }
        if(paikka>=kokonaismatka-100) {
            System.out.println((kokonaismatka-paikka) 
            + " km etäisyydelle kuun pinnasta päästiin hetkellä " 
            + (aika/3600) + "h nopeudella " + nopeus);
        }
    }
}
