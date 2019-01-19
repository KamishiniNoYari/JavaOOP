/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import vod.Produkt;
import vod.Dystrybutor;
import vod.Klient;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 *Baza to konterner na Produkty,Klientów i Dystrybutorów
 * @author Krystian
 */
public class Baza implements Serializable {
    private ArrayList<Produkt>produkty = new ArrayList();
    private ArrayList<Klient>klienci = new ArrayList();
    private ArrayList<Dystrybutor>dystrybutorzy = new ArrayList();
/**
 * Zwraca ArrayList produktów w systemie
 * @return 
 * Zwraca ArrayList produktów w systemie
 */
    public ArrayList<Produkt> getProdukty() {
        return produkty;
    }
/**
 * ustawia ArrayList produktów w systemie
 * @param produkty 
 * ustawia ArrayList produktów w systemie

 */
    public void setProdukty(ArrayList<Produkt> produkty) {
        this.produkty = produkty;
    }
/**
 * @return 
  * zwraca ArrayListę klientów w systemie

 */
    public ArrayList<Klient> getKlienci() {
        return klienci;
    }
/**
 * 
 * @param klienci 
 * ustawia klientów
 */
    public void setKlienci(ArrayList<Klient> klienci) {
        this.klienci = klienci;
    }

    /**
     *
     * @return
     * zwraca liste dystrybutorów
     */
    public ArrayList<Dystrybutor> getDystrybutorzy() {
        return dystrybutorzy;
    }

    /**
     *
     * @param dystrybutorzy
     * ustawia dystrybutorow
     */
    public void setDystrybutorzy(ArrayList<Dystrybutor> dystrybutorzy) {
        this.dystrybutorzy = dystrybutorzy;
    }

    /**
     *
     * @param x
     * dodaje produkt do listy
     */
    public void dodajProdukt(Produkt x)
    {
        produkty.add(x);
    }

    /**
     *
     * @param x
     * dodaje klienta do listy
     */
    public void dodajKlienta(Klient x)
    {
        klienci.add(x);
    }

    /**
     *
     * @param x
     * dodaje dystrybutora do bazy
     */
    public void dodajDystrybutora(Dystrybutor x)
    {
        dystrybutorzy.add(x);
    }
    


    /**
     *
     * @param data
     * używa daty
     * @return
     * zwraca koszty
     * @throws ParseException
     * wylicza koszty, ustanawia daty podpisania umów
     */
    public double wyliczKoszty(Date data) throws ParseException
    {
        double koszt = 0;
        
        Iterator i = dystrybutorzy.iterator();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        Date standard_date = sdf.parse("00-00-0000");
        
        while (i.hasNext())
        {
            
            Dystrybutor element = (Dystrybutor) i.next();
            
            Iterator j = element.getUmowa().iterator();
            while(j.hasNext())
            {
                Umowa element2 = (Umowa) j.next();
                
                String typ = element2.getTyp();
                
                if (element2.getData_podpisania().equals(standard_date))
                    {
                        ArrayList<Produkt> x = element2.getProdukty_w_umowie();
                        
                        
                        
                        for(int k = 0; k < x.size() ; k++)
                        {
                            if (!(x.get(k) instanceof Film))
                            {
                                x.get(k).setDataProdukcji(data);
                            }
                            produkty.add(x.get(k));
                        }
                        
                            
                          
                    }
                                        
                switch(typ)
                {
                    //umowa stała jest opłacana ponownie po czasie nieużycia
                    case "Stała":
                        if ((!element2.isOplacona()) || (data.getTime()- element2.getData_podpisania().getTime()%element2.getCzas_trwania()==0))
                        {
                            koszt+=element2.getKasa();
                            
                            element.otrzymajZaplate(element2.getKasa());
                            
                            element2.setOplacona(true);
                        }
                        break;
                    case "Procent":
                        ArrayList<Produkt> x = element2.getProdukty_w_umowie();
                        
                        
                        for(int k = 0;k < x.size() ; k++)
                        {
                            if (x.get(k).getDataProdukcji().equals(standard_date)) 
                            {
                                x.get(k).setDataProdukcji(data);
                            }
                            koszt+=x.get(k).getCena()*x.get(k).getProcent()*x.get(k).getIlosc_kupionych();
                            
                            element.otrzymajZaplate(x.get(k).getCena()*x.get(k).getProcent()*x.get(k).getIlosc_kupionych());
                            
                            x.get(k).setIlosc_kupionych(0);
                            
                            
                                                       
                            
                                                  
                        }
                        break;
                    case "Miesięczna":
                        if((Math.round(data.getTime()- element2.getData_podpisania().getTime()))% 30 == 0);
                        {
                            koszt+=element2.getOplata_miesieczna();
                            element.otrzymajZaplate(element2.getOplata_miesieczna());
                        }
                        
                    
                        
                        
                }
                     
                    
                
            }
            
            
        }
        return koszt;
    }

    /**
     *
     * @return
     * wylicza zarobki dnia
     */
    public double wyliczZyski()
    {
        double zysk = 0;
        
        Iterator a = produkty.iterator();
        
        while (a.hasNext())
        {
            Produkt element = (Produkt)a.next();
            
            zysk+=element.getCena()*element.getIlosc_kupionych();
            
            element.setIlosc_kupionych(0);
        }
        
        return zysk;
    }

    /**
     *
     * @param data
     * dodaje obejrzenia do danych listy wykresu
     * 
     */
    public void aktualizacja_obejrzen(Date data)
    {
        produkty.forEach((Produkt produkt)->{
            produkt.dodajObejrzenie();
            produkt.dodajData(data);
            produkt.setIlosc_obejrzen(0);
            
        });
    }
}
