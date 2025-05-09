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
public class OrganizacionaJedinica extends AbstractDomainObject {

    private Long sifOrgJed;
    private String nazivOrgJed;

    public OrganizacionaJedinica() {
    }

    public OrganizacionaJedinica(Long sifOrgJed, String nazivOrgJed) {
        this.sifOrgJed = sifOrgJed;
        this.nazivOrgJed = nazivOrgJed;
    }
    
    
    @Override
    public String nazivTabele() {
        return "OrganizacionaJedinica";
    }

    @Override
    public String alijas() {
        return "o";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String order() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            OrganizacionaJedinica org = new OrganizacionaJedinica(rs.getLong("sifOrgJed"), rs.getString("nazivOrgJed"));
            lista.add(org);
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
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "sifOrgJed = " + sifOrgJed;
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

    public Long getSifOrgJed() {
        return sifOrgJed;
    }

    public String getNazivOrgJed() {
        return nazivOrgJed;
    }

    public void setSifOrgJed(Long sifOrgJed) {
        this.sifOrgJed = sifOrgJed;
    }

    public void setNazivOrgJed(String nazivOrgJed) {
        this.nazivOrgJed = nazivOrgJed;
    }

    @Override
    public String toString() {
        return sifOrgJed + " - " + nazivOrgJed;
    }
    
    
    
}
