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
public class Pakovanje extends AbstractDomainObject {
    
    private Long sifPakovanja;
    private String tip;
    private Float tezina_t;
    private Float tezina_kg;

    public Pakovanje() {
    }

    public Pakovanje(Long sifPakovanja, String tip, Float tezina_t, Float tezina_kg) {
        this.sifPakovanja = sifPakovanja;
        this.tip = tip;
        this.tezina_t = tezina_t;
        this.tezina_kg = tezina_kg;
    }
    
    
    
    @Override
    public String nazivTabele() {
        return "pakovanje";
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
        return "ORDER BY SIFPAKOVANJA";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            Pakovanje p = new Pakovanje(rs.getLong("sifPakovanja"), rs.getString("tip"), rs.getFloat("tezina_t"), rs.getFloat("tezina_kg"));
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
    public String koloneZaSelect() {
        return " p.sifPakovanja, p.naziv.get_tip() \"tip\", p.naziv.get_tezina_u_t() \"tezina_t\", p.naziv.get_tezina_u_kg() \"tezina_kg\" ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "sifPakovanja = " + sifPakovanja;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + sifPakovanja + ", obj_naziv_pak('" + tip + "', " + tezina_t + ") ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " p.naziv.tip = '" + tip + "', p.naziv.tezina = " + tezina_t + " ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getSifPakovanja() {
        return sifPakovanja;
    }

    public String getTip() {
        return tip;
    }

    public Float getTezina_t() {
        return tezina_t;
    }

    public Float getTezina_kg() {
        return tezina_kg;
    }

    public void setSifPakovanja(Long sifPakovanja) {
        this.sifPakovanja = sifPakovanja;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setTezina_t(Float tezina_t) {
        this.tezina_t = tezina_t;
    }

    public void setTezina_kg(Float tezina_kg) {
        this.tezina_kg = tezina_kg;
    }
    
}
