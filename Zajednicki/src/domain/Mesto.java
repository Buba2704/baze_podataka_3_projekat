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
public class Mesto extends AbstractDomainObject {

    private Long sifMesta;
    private String naziv;
    private Long postanskiBroj;

    public Mesto() {
    }

    public Mesto(Long sifMesta, String naziv, Long postanskiBroj) {
        this.sifMesta = sifMesta;
        this.naziv = naziv;
        this.postanskiBroj = postanskiBroj;
    }
    
    
    
    @Override
    public String nazivTabele() {
        return "Mesto";
    }

    @Override
    public String alijas() {
        return "M";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String order() {
        return " ORDER BY " + sifMesta;
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            Mesto m = new Mesto(rs.getLong("sifMesta"), rs.getString("naziv"), rs.getLong("postanskiBroj"));
            lista.add(m);
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
        return "sifMesta = " + sifMesta;
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

    public Long getSifMesta() {
        return sifMesta;
    }

    public String getNaziv() {
        return naziv;
    }

    public Long getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setSifMesta(Long sifMesta) {
        this.sifMesta = sifMesta;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setPostanskiBroj(Long postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    @Override
    public String toString() {
        return sifMesta + " - " + naziv;
    }
    
    
    
}
