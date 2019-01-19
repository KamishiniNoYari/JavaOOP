/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import java.io.Serializable;
import java.util.ArrayList;
import vod.Umowa;

/**
 *
 * @author Krystian
 */
public class Wlasciciel extends Uzytkownik implements Serializable {
    private double zysk;
    private double zarobki;
    private double straty;
    private ArrayList<Umowa>umowy;
    
    /**
     *
     * @param id
     * tworzy wlasicciela
     */
    public Wlasciciel(int id){
        setId(id);
        setNazwa();
        setData_urodzenia();
        setE_mail();
        setNumer_karty();     
        setStan_konta();
    }

    /**
     *
     * @return
     * zwraca zyski
     */
    public double getZysk() {
        return zysk;
    }

    /**
     *
     * @param zysk
     * ustawia zysk
     */
    public void setZysk(double zysk) {
        this.zysk = zysk;
    }

    /**
     *
     * @return
     * zwraca zarobki
     */
    public double getZarobki() {
        return zarobki;
    }

    /**
     *
     * @param zarobki
     * ustawia zarobki
     */
    public void setZarobki(double zarobki) {
        this.zarobki = zarobki;
    }

    /**
     *
     * @return
     * zwraca straty
     */
    public double getStraty() {
        return straty;
    }

    /**
     *
     * @param straty
     * ustawia straty
     */
    public void setStraty(double straty) {
        this.straty = straty;
    }

    /**
     *
     * @return
     * zwraca umowy
     */
    public ArrayList<Umowa> getUmowy() {
        return umowy;
    }
    
    /**
     *
     */
    public void setNazwa()
    {
        this.nazwa="Wlasciciel"+id;
    }

    /**
     *
     * @param umowy
     * ustawia umowy
     */
    public void setUmowy(ArrayList<Umowa> umowy) {
        this.umowy = umowy;
    }

    /**
     *
     * @param oplata
     * aktualizuje stan konta
     */
    public void ustalStanKonta(double oplata)
    {
        stan_konta+=oplata;
    }
    
    
    
}
