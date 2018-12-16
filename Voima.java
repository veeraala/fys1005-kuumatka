/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kuumatka;

import java.lang.Math;
/**
 *
 * @author Veera
 */
public class Voima {
    private final static double G = 6.67259*Math.pow(10,-11)/Math.pow(1000, 3);
    //private double etaisyys;
    private double massa;
    
    public Voima(double massa) {
        this.massa = massa;
    }
    
    //gravitaatio antaa gravitaatiovoiman jaettuna avaruusaluksen massalla
    public double gravitaatio(double etaisyys) {
        //this.etaisyys = etaisyys;
        double gravitaatio = G*massa/Math.pow(etaisyys,2);
        return gravitaatio;
    }
    
    //myös impulssi annetaan jaettuna avaruusaluksen massalla 
    //ohjelman yksinkertaistamiseksi
    public double impulssi(double etaisyys, double aikaAskel) {
        double voima = gravitaatio(etaisyys);
        double impulssi = voima*aikaAskel;
        return impulssi;
    }
}
