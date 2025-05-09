/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author zoran
 */
public class Proizvod extends AbstractDomainObject{
    private Long sifProizvoda;
    private String nazivProizvoda;
    private String dodatniNaziv;
    private String oznaka;
    private JedinicaMere jedinicaMere;
    private Float dostupnaKolicina;

    public Proizvod() {
    }

    public Proizvod(Long sifProizvoda, String nazivProizvoda, String dodatniNaziv, String oznaka, JedinicaMere sifJM, Float dostupnaKolicina) {
        this.sifProizvoda = sifProizvoda;
        this.nazivProizvoda = nazivProizvoda;
        this.dodatniNaziv = dodatniNaziv;
        this.oznaka = oznaka;
        this.jedinicaMere = sifJM;
        this.dostupnaKolicina = dostupnaKolicina;
    }
    
    

    @Override
    public String nazivTabele() {
        return "Proizvod";
    }

    @Override
    public String alijas() {
        return "P";
    }

    @Override
    public String join() {
        return "JOIN JEDINICAMERE JM ON(P.SIFJM = JM.SIFJM)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
       ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            JedinicaMere jm = new JedinicaMere(rs.getLong("sifJM"), rs.getString("nazivJM"),rs.getString("oznakaJM") );
            Proizvod p = new Proizvod(rs.getLong("sifProizvoda"), rs.getString("nazivProizvoda"), rs.getString("dodatniNaziv"),
                    rs.getString("oznaka"), jm, rs.getFloat("dostupnaKolicina"));
            lista.add(p);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " ( nazivProizvoda, dodatniNaziv, oznaka, sifJM ) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "sifProizvoda = " + sifProizvoda;
    }

    @Override
    public String vrednostiZaInsert() {
            return " '" + nazivProizvoda + "', '" + dodatniNaziv + "', "
                + "'" + oznaka + "', '" + jedinicaMere.getSifJM() + "'";
        
    }

    @Override
    public String vrednostiZaUpdate() {
        if(this.dostupnaKolicina!= null)
            return "nazivProizvoda = '" + nazivProizvoda + "', dodatniNaziv = '" + dodatniNaziv + "', oznaka = '" + oznaka + "', sifJM = " + jedinicaMere.getSifJM() + ", dostupnaKolicina = " + dostupnaKolicina + " ";
        else
            return "nazivProizvoda = '" + nazivProizvoda + "', dodatniNaziv = '" + dodatniNaziv + "', oznaka = '" + oznaka + "', sifJM = " + jedinicaMere.getSifJM() + " ";
        
        
        
       
        /*return "nazivProizvoda = '" + nazivProizvoda + "', dodatniNaziv = '" + dodatniNaziv + "', oznaka = '" + oznaka + "', sifJM = '" + jedinicaMere.getSifJM() + "'";*/
        
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getSifProizvoda() {
        return sifProizvoda;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public String getDodatniNaziv() {
        return dodatniNaziv;
    }

    public String getOznaka() {
        return oznaka;
    }

    public JedinicaMere getJM() {
        return jedinicaMere;
    }

    public Float getDostupnaKolicina() {
        return dostupnaKolicina;
    }

    public void setSifProizvoda(Long sifProizvoda) {
        this.sifProizvoda = sifProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public void setDodatniNaziv(String dodatniNaziv) {
        this.dodatniNaziv = dodatniNaziv;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public void setJM(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public void setDostupnaKolicina(Float dostupnaKolicina) {
        this.dostupnaKolicina = dostupnaKolicina;
    }

    @Override
    public String toString() {
        return sifProizvoda + " - " +  nazivProizvoda;
    }
    
     public String order(){
         return " ORDER BY SIFPROIZVODA";
     }
     
    public String koloneZaSelect() {
        return "";
    }
    
}
