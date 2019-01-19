/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import vod.Produkt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Krystian
 */
public class Promocja implements Serializable {
    private ArrayList<Produkt> objete_prom = new ArrayList();
    private float procent;
    private ArrayList<Float> stare_ceny = new ArrayList();

    /**
     *
     * @return
     * zwraca procent z umowy
     */
    public float getProcent() {
        return procent;
    }

    /**
     *
     * @param procent
     * ustawia procent w umowie
     */
    public void setProcent(float procent) {
        this.procent = procent;
    }
    private Date data_roz;
    private Date data_za;
    private float upust;
    
    /**
     *
     * @param data_rozpoczecia
     * xxx
     * @param produkty_bazowe
     * tworzy promocję modyfikuje ceny
     */
    public Promocja(Date data_rozpoczecia, ArrayList<Produkt> produkty_bazowe)
    {
        setData_roz(data_rozpoczecia);
               
        Random r = new Random();
        
        int liczba_prod_w_promocji =1+r.nextInt(2);
        
        float procent = (float) (0.05 + r.nextFloat()*0.45);
        
        int licznik=0;
        
        for (int i=0;i<produkty_bazowe.size();i++)
        {
            if ((produkty_bazowe.get(i) instanceof Film || produkty_bazowe.get(i) instanceof LiveStream) && r.nextBoolean())
            {
                objete_prom.add(produkty_bazowe.get(i));
                
                stare_ceny.add(new Float(produkty_bazowe.get(i).getCena()));
                
                produkty_bazowe.get(i).resetCena(produkty_bazowe.get(i).getCena()*(1-procent));
                
                licznik++;
            }
            if (licznik>=liczba_prod_w_promocji) break;
                
            
        }
        //ustalanie daty zakończenia
        
        int czas_trwania = 15+r.nextInt(15);
        
        Date data_zakonczenia = new Date(data_rozpoczecia.getTime()+(czas_trwania*24*60*60*1000));
        
        this.data_za=data_zakonczenia;
        
        
    }
    
    /**
     *
     */
    public void przywróćCeny()
    {
         for (int i=0;i<objete_prom.size();i++)
         {
             objete_prom.get(i).resetCena(stare_ceny.get(i));
         }
    }

    /**
     *
     * @return
     * zwraca produkty objęte promocją
     */
    public ArrayList<Produkt> getObjete_prom() {
        return objete_prom;
    }

    /**
     *
     * @param objete_prom
     * ustawia produkty objęte promocją
     */
    public void setObjete_prom(ArrayList<Produkt> objete_prom) {
        this.objete_prom = objete_prom;
    }

    /**
     *
     * @return
     * zwraca date rozpoczenia
     */
    public Date getData_roz() {
        return data_roz;
    }

    /**
     *
     * @param data_roz
     * ustawia datę rozpoczecia
     * 
     */
    public void setData_roz(Date data_roz) {
        this.data_roz = data_roz;
    }

    /**
     *
     * @return
     * data zakończenia
     */
    public Date getData_za() {
        return data_za;
    }

    /**
     *
     * @param data_za
     * data zakończenia
     */
    public void setData_za(Date data_za) {
        this.data_za = data_za;
    }

    /**
     *
     * @return
     * wartość upustu
     */
    public float getUpust() {
        return upust;
    }

    /**
     *
     * @param upust
     * ustawianie wartości upustu
     */
    public void setUpust(float upust) {
        this.upust = upust;
    }
    
    
}
