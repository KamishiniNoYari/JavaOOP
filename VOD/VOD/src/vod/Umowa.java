/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import vod.Produkt;
import com.sun.org.apache.xpath.internal.operations.Bool;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Krystian
 */
public final class Umowa implements Serializable {

    private String typ;
    private int czas_trwania;
    private ArrayList<Produkt> produkty_w_umowie;
    private Date data_podpisania;
    private float procent=0;
    private double kasa=0;
    private double oplata_miesieczna=0;
    private boolean oplacona = false;

    /**
     *
     * @param oplacona
     * ustawia to czy umowa jest opłacona
     */
    public void setOplacona(boolean oplacona) {
        this.oplacona = oplacona;
    }

    /**
     *
     * @return
     * zwraca procent umowy
     */
    public float getProcent() {
        return procent;
    }

    /**
     *
     * @return
     * kwota do zaplacenia jeśli umowa jest stala-
     */
    public double getKasa() {
        return kasa;
    }

    /**
     *
     * @return
     * zwraca opłatę miesięczną
     */
    public double getOplata_miesieczna() {
        return oplata_miesieczna;
    }

    /**
     *
     * @return
     * zwraca czy jest opłacona
     */
    public boolean isOplacona() {
        return oplacona;
    }

    /**
     *
     * @param czas_trwania
     * ustawia czas trwania
     */
    public void setCzas_trwania(int czas_trwania) {
        this.czas_trwania = czas_trwania;
    }

    /**
     *
     * @param procent
     * ustawia procent
     */
    public void setProcent(float procent) {
        this.procent = procent;
    }

    /**
     *
     * @param kasa
     * ustawia kwotę umowy
     */
    public void setKasa(double kasa) {
        this.kasa = kasa;
    }

    /**
     *
     * @param oplata_miesieczna
     * ustawia opłatę miesięczną
     */
    public void setOplata_miesieczna(double oplata_miesieczna) {
        this.oplata_miesieczna = oplata_miesieczna;
    }
    
    /**
     *
     * @return
     * zwraca datę podpisania
     */
    public Date getData_podpisania() {
        return data_podpisania;
    }

    /**
     *
     * @param data_podpisania
     * ustawia datę podpisania
     */
    public void setData_podpisania(Date data_podpisania) {
        this.data_podpisania = data_podpisania;
    }
    
    /**
     *
     * @param typ
     * xxx
     * @param produkty
     * tworzy nową umowę
     */
    public Umowa(String typ,ArrayList<Produkt> produkty)
    {
        this.typ=typ;
        this.produkty_w_umowie=produkty;
        this.setCzas_trwania();
        
        Random r = new Random();
        
        if (typ.equals("Stała"))
        {
            //koszt nie większy niż 20000
            kasa=20000 + r.nextInt(900);
        }
        if (typ.equals("Procent"))
        {
            //procent nie większy niż polowa zyskow
            float b = (1-r.nextFloat())/2;
            
            for (int i = 0;i < produkty.size();i++)
            {
                produkty.get(i).setProcent(b);
            }
            
        }    
        if (typ.equals("Miesieczna"))
        {
            //oplata miesięczna będzie od 100 do 500
            oplata_miesieczna=10000+r.nextInt(500);
        }
        
              
    }

    /**
     *
     * @return
     * zwraca typ
     */
    public String getTyp() {
        return typ;
    }

    /**
     *
     * @param typ
     * ustawia typ
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     *@return 
     * zwraca czas trwania
     */
    public int getCzas_trwania() {
        return czas_trwania;
    }
    
    /**
     *
     */
    public void setCzas_trwania() {
        
        Random r = new Random();
        
        int i = 90 + r.nextInt(180);
                 
        this.czas_trwania = i;
    }

    /**
     *
     * @return
     * zwraca produkty w umowie
     *
     */
    public ArrayList<Produkt> getProdukty_w_umowie() {
        return produkty_w_umowie;
    }

    /**
     *
     * @param produkty_w_umowie
     * ustawia produkty w umowie
     */
    public void setProdukty_w_umowie(ArrayList<Produkt> produkty_w_umowie) {
        this.produkty_w_umowie = produkty_w_umowie;
    }
    
    /**
     *
     */
    public void negocjuj()
    {
        
    }
}
