/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vod;

import vod.Uzytkownik;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import vod.Abonament;
import vod.Baza;
import vod.Film;
import vod.Odcinek;
import vod.Produkt;
import vod.Serial;
import static vod.Start.getStart_symulacji;
import static vod.Start.giveInfo;
/**
 *
 * @author Krystian
 */
public class Klient extends Uzytkownik implements Runnable,Serializable {
    private ArrayList<Produkt> produkty = new ArrayList();
    private Abonament abonament=null;
    private int liczba_urzadzeń;
    private Boolean przerwanie=false;

    /**
     *
     * @return
     * zwraca liczbę urządzeń
     */
    public int getLiczba_urzadzeń() {
        return liczba_urzadzeń;
    }

    /**
     *
     * @param liczba_urzadzeń
     * ustawia liczbe urządzeń
     */
    public void setLiczba_urzadzeń(int liczba_urzadzeń) {
        this.liczba_urzadzeń = liczba_urzadzeń;
    }

    /**
     *
     * @return
     * zwraca przerwanie
     */
    public Boolean getPrzerwanie() {
        return przerwanie;
    }

    /**
     *
     * @param przerwanie
     * ustawie przerwanie
     */
    public void setPrzerwanie(Boolean przerwanie) {
        this.przerwanie = przerwanie;
    }
    
    /**
     *
     * @param id
     * tworzy klienta
     */
    public Klient(int id){
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
     * zwraca produkty
     */
    public ArrayList<Produkt> getProdukty() {
        return produkty;
    }

    /**
     *
     * @param produkty
     * ustawia produkty
     */
    public void setProdukty(ArrayList<Produkt> produkty) {
        this.produkty = produkty;
    }

    /**
     *
     * @return
     * zwraca abonament
     */
    public Abonament getAbonament() {
        return abonament;
    }

    /**
     *
     */
    public void setNazwa(){
        this.nazwa="Klient "+id;
    }

    /**
     *
     * @param abonament
     * ustawia abonament
     */
    public void setAbonament(Abonament abonament) {
        this.abonament = abonament;
    }

    /**
     *
     */
    public synchronized void Oglądaj()
    {
        int ilosc_obejrzen=1;
        
        if (abonament!=null)
        {
            ilosc_obejrzen=abonament.getIlosc_urzadzen();
        }
        
        Random r = new Random();
        
        Produkt wybrany_do_ogladania = produkty.get(r.nextInt(produkty.size()));
        
        while (wybrany_do_ogladania instanceof Odcinek)
        {
            wybrany_do_ogladania = produkty.get(r.nextInt(produkty.size()));
        }
        
        if (wybrany_do_ogladania instanceof Serial)
        {
            wybrany_do_ogladania.obejrzyj(ilosc_obejrzen);
            
            Produkt temp = wybrany_do_ogladania.getOdcinki().get(r.nextInt(wybrany_do_ogladania.getOdcinki().size()));
            
            wybrany_do_ogladania = temp;
        }
        
        wybrany_do_ogladania.obejrzyj(ilosc_obejrzen);
    }

    /**
     *
     * @param c
     * zmniejsza stan konta o koszt produktu
     */
    public synchronized void Zaplac(Produkt c)
    {
        double temp = this.stan_konta - c.getCena();
        this.stan_konta = (long) temp;
    }

    /**
     *
     * @param czasy
     * klient kupuje produkt
     * 
     */
    public void Kup(ArrayList czasy)
    {
        Random r = new Random();
        
        Baza baza = giveInfo();
                
        int b = r.nextInt(baza.getProdukty().size());
                
        Produkt c = baza.getProdukty().get(b);
                
        while ((c instanceof Odcinek))
        {
            b = r.nextInt(baza.getProdukty().size());
                    
            c = baza.getProdukty().get(b);
                    
        }
        if (!produkty.contains(c)){
        if (c instanceof Film)
        {
            czasy.add(((Film)c).getCzas_po_zakupie());
        }
        produkty.add(c);
        
        c.kup();
        this.Zaplac(c);
        }
    }

    @Override
    public void run() {
        
        
        // System działania klienta nie powinien być zbytnio skomplikowany
        // Klient sprawdza czy ma abonament jeśli nie sprawdza swój stan konta 
        // Jeśli może decyduje się na kupno
        // Klient kupuje do czasu wejścia na minus, potem może jedynie oglądać
        // Jeśli klient kupi serial ogląda po kolei odcinki z listy
        
    while (przerwanie == false){
     
        Date dzisiaj = getStart_symulacji();
        
        ArrayList<Integer> czasy = new ArrayList<>();
        
        Random r = new Random();
        
        if (abonament == null)
        {
            if (this.stan_konta >= 40)
            {
                
                
                int a=r.nextInt(2);
                
                String[] tab = {"Basic","Family","Premium"};
                
                Abonament abonament_0 = new Abonament(tab[a]);
                
                int licznik =abonament_0.getOkres();
              
                //darmowy produkt z abonamentu dowolny
                
                Baza baza = giveInfo();
                
                int b = r.nextInt(baza.getProdukty().size());
                
                Produkt c = baza.getProdukty().get(b);
                
                while (c instanceof Odcinek)
                {
                    b = r.nextInt(baza.getProdukty().size());
                    
                    c = baza.getProdukty().get(b);
                    
                }
                
                if (c instanceof Film)
                {
                    czasy.add(((Film)c).getCzas_po_zakupie());
                }
                
                produkty.add(c);
            
        
                
                
                
                
                
            }
            
        }
        if ((this.stan_konta>=0) && (r.nextBoolean()))
        {
            this.Kup(czasy);
        }
        if (r.nextBoolean())
        {
            this.Oglądaj();
        }
        
        
        
        
        while(dzisiaj.equals(getStart_symulacji()))
        {
            
        }
        
        
        
        int dodatkowy_licznik = 0;
        
        ArrayList<Integer> alo = new ArrayList<>();
        
        for (int i=0; i < czasy.size();i++)
        {
            Integer x=czasy.get(i)-1;
            
            if (x==0)
            {
                //wyrzucamy nieużywalny film z produktów
                for (int j = 0; j<produkty.size();j++)
                {
                    if (produkty.get(j) instanceof Film)
                    {
                        if (i == dodatkowy_licznik)
                        {
                            produkty.remove(produkty.get(j));
                        }
                        dodatkowy_licznik++;
                    }
                    
                }
                czasy.remove(czasy.get(i));
            }
            else
            {
                alo.add(x);
            }
            
            
            
                
        }    
        alo = czasy;
        
        dodatkowy_licznik = 0;
        
    }

    }
}