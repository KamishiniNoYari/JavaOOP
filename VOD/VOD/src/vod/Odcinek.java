/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import vod.Serial;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Krystian
 */
public class Odcinek extends Serial implements Serializable {
    private int sezon;
    private Date data_premiery;
    private String nazwa_serialu;
    
    /**
     *
     * @param wlasciciel
     * xxx
     * @param nr_sezonu
     * xxx
     * @param data_premiery
     * xxx
     * @param nazwa_serialu
     * xxx
     * @param id
     * xxx
     * @param cena
     * xxx
     * @throws FileNotFoundException
     * xxx
     */
    public Odcinek(String wlasciciel,int nr_sezonu,Date data_premiery,String nazwa_serialu,int id, float cena) throws FileNotFoundException {
        
        super(wlasciciel,data_premiery,id);
        setSezon(nr_sezonu);
        setData_premiery(data_premiery);
        setNazwa_serialu(nazwa_serialu);
        setNazwa();
        setCena(cena);
        
    }

    /**
     *
     * @return
     * zwraca numer sezonu
     */
    public int getSezon() {
        return sezon;
    }

    /**
     *
     * @param sezon
     * ustawia numer sezonu
     */
    public void setSezon(int sezon) {
        this.sezon = sezon;
    }
    
    /**
     *
     */
    public void setNazwa()
    {
        this.nazwa=nazwa_serialu+" "+sezon+" "+id;    
    }

    /**
     *
     * @param cena
     * ustawia cenę
     */
    public void setCena(float cena)
    {
        this.cena=cena/5;
    }

    /**
     *
     * @return
     * zwraca nazwę
     */
    public String getNazwa()
    {
        return this.nazwa;
    }

    /**
     *
     * @return
     * zwraca datę premiery
     */
    public Date getData_premiery() {
        return data_premiery;
    }

    /**
     *
     * @param data_premiery
     * ustawienie daty premiery
     */
    public void setData_premiery(Date data_premiery) {
        this.data_premiery = data_premiery;
    }
    
    /**
     *
     * @return
     * zwraca nazwę serialu
     */
    public String getNazwa_serialu(){
        return nazwa_serialu;
    }

    /**
     *
     * @param nazwa_serialu
     * ustawia nazwę serialu
     */
    public void setNazwa_serialu(String nazwa_serialu){
        this.nazwa_serialu=nazwa_serialu;
    }
}
