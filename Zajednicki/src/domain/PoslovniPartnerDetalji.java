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
public class PoslovniPartnerDetalji extends AbstractDomainObject {

    private Long sifPartnera;
    private Long maticniBroj;
    private Long PIB;
    private String adresa;
    private Long tekuciRacun;
    private Mesto mesto;

    public PoslovniPartnerDetalji() {
    }

    public PoslovniPartnerDetalji(Long sifPartnera, Long maticniBroj, Long PIB, String adresa, Long tekuciRacun, Mesto mesto) {
        this.sifPartnera = sifPartnera;
        this.maticniBroj = maticniBroj;
        this.PIB = PIB;
        this.adresa = adresa;
        this.tekuciRacun = tekuciRacun;
        this.mesto = mesto;
    }
    
    
    
    @Override
    public String nazivTabele() {
        return "poslovniPartnerDetalji";
    }

    @Override
    public String alijas() {
       return "p";
    }

    @Override
    public String join() {
       return "JOIN MESTO M ON(P.SIFMESTA = M.SIFMESTA)";
    }

    @Override
    public String order() {
        return " ORDER BY SIFPARTNERA ";
    }
    
    public String koloneZaSelect() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            Mesto m = new Mesto(rs.getLong("sifMesta"), rs.getString("naziv"), rs.getLong("postanskiBroj"));
            PoslovniPartnerDetalji p = new PoslovniPartnerDetalji(rs.getLong("sifPartnera"),  rs.getLong("maticniBroj"), rs.getLong("PIB"), rs.getString("adresa"), rs.getLong("tekuciRacun"), m);
            lista.add(p);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
         return " sifPartnera = " + sifPartnera;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public void setSifPartnera(Long sifPartnera) {
        this.sifPartnera = sifPartnera;
    }

    public void setMaticniBroj(Long maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public void setPIB(Long PIB) {
        this.PIB = PIB;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setTekuciRacun(Long tekuciRacun) {
        this.tekuciRacun = tekuciRacun;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Long getSifPartnera() {
        return sifPartnera;
    }

    public Long getMaticniBroj() {
        return maticniBroj;
    }

    public Long getPIB() {
        return PIB;
    }

    public String getAdresa() {
        return adresa;
    }

    public Long getTekuciRacun() {
        return tekuciRacun;
    }

    public Mesto getMesto() {
        return mesto;
    }
    
}
