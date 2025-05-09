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
public class PoslovniPartner extends AbstractDomainObject{
    private Long sifPartnera;
    private String nazivPartnera;

    public PoslovniPartner() {
    }

    public PoslovniPartner(Long sifPartnera, String nazivPartnera) {
        this.sifPartnera = sifPartnera;
        this.nazivPartnera = nazivPartnera;
    }
    
    
    
    @Override
    public String nazivTabele() {
        return "poslovniPartner";
    }

    @Override
    public String alijas() {
        return "p";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String order() {
        return " ORDER BY SIFPARTNERA ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            PoslovniPartner p = new PoslovniPartner(rs.getLong("sifPartnera"), rs.getString("nazivPartnera"));
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
    
    public String koloneZaSelect() {
        return "";
    }

    public Long getSifPartnera() {
        return sifPartnera;
    }

    public String getNazivPartnera() {
        return nazivPartnera;
    }

    public void setSifPartnera(Long sifPartnera) {
        this.sifPartnera = sifPartnera;
    }

    public void setNazivPartnera(String nazivPartnera) {
        this.nazivPartnera = nazivPartnera;
    }
    
    @Override
    public String toString() {
        return sifPartnera + " - " + nazivPartnera;
    }
}
