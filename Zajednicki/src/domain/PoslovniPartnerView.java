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
public class PoslovniPartnerView extends AbstractDomainObject {
    private Long sifPartnera;
    private String nazivPartnera;
    private Long maticniBroj;
    private Long PIB;
    private String adresa;
    private Long tekuciRacun;
    private Mesto mesto;

    public PoslovniPartnerView() {
    }

    public PoslovniPartnerView(Long sifPartnera, String nazivPartnera, Long maticniBroj, Long PIB, String adresa, Long tekuciRacun, Mesto mesto) {
        this.sifPartnera = sifPartnera;
        this.nazivPartnera = nazivPartnera;
        this.maticniBroj = maticniBroj;
        this.PIB = PIB;
        this.adresa = adresa;
        this.tekuciRacun = tekuciRacun;
        this.mesto = mesto;
    }

    public Long getSifPartnera() {
        return sifPartnera;
    }

    public String getNazivPartnera() {
        return nazivPartnera;
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

    public void setSifPartnera(Long sifPartnera) {
        this.sifPartnera = sifPartnera;
    }

    public void setNazivPartnera(String nazivPartnera) {
        this.nazivPartnera = nazivPartnera;
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

    @Override
    public String nazivTabele() {
        return "poslovniPartner_View";
    }

    @Override
    public String alijas() {
        return "P";
    }

    @Override
    public String join() {
        return "JOIN MESTO M ON(P.SIFMESTA = M.SIFMESTA)";
    }

    @Override
    public String order() {
        return " ORDER BY SIFPARTNERA ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            Mesto m = new Mesto(rs.getLong("sifMesta"), rs.getString("naziv"), rs.getLong("postanskiBroj"));
            PoslovniPartnerView p = new PoslovniPartnerView(rs.getLong("sifPartnera"), rs.getString("nazivPartnera"), rs.getLong("maticniBroj"), rs.getLong("PIB"), rs.getString("adresa"), rs.getLong("tekuciRacun"), m);
            lista.add(p);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "( sifPartnera, nazivPartnera, maticniBroj, PIB, adresa, tekuciRacun, sifMesta) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "sifPartnera = " + sifPartnera;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + sifPartnera + ", '" + nazivPartnera + "', "
            + " " + maticniBroj + ", " + PIB + ", '" + adresa + "', " + tekuciRacun + ", " + mesto.getSifMesta() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivPartnera = '" + nazivPartnera + "', maticniBroj = " + maticniBroj + ", PIB = " + PIB + ", adresa = '" + adresa + "', tekuciRacun = " + tekuciRacun + ", sifMesta = " + mesto.getSifMesta() + " ";
    }

    @Override
    public String uslov() {
        return "";    
    }
    
    public String koloneZaSelect() {
        return "";
    }

    
    
}
