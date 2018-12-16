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
public class Mittauspiste {
    private double alkunopeus;
    private double matkaAika;
    
    public Mittauspiste(double alkunopeus) {
        this.alkunopeus = alkunopeus;
        Simulaatio simulaatio = new Simulaatio(alkunopeus, 0.01);
        if(simulaatio.paaseeKuuhun()) {
            matkaAika = simulaatio.matkaAika();
        } else {
            this.alkunopeus = 0;
            this.matkaAika = 0;
            System.out.println("nopeus, jotka eivät riitä kuuhun "
                    + "(muutettu 0,0 -arvoiksi)");
        }
    }
    
    public String toString() {
        return alkunopeus + ", " + (matkaAika/3600);
    }
}
