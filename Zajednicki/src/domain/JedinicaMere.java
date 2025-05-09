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
public class JedinicaMere extends AbstractDomainObject{
    private Long sifJM;
    private String nazivJM;
    private String oznakaJM;

    
    public JedinicaMere() {
    }

    public JedinicaMere(Long sifJM, String nazivJM, String oznakaJM) {
        this.sifJM = sifJM;
        this.nazivJM = nazivJM;
        this.oznakaJM = oznakaJM;
    }
    
    @Override
    public String toString() {
        return oznakaJM;
    }

    
    public Long getSifJM() {
        return sifJM;
    }

    public String getNazivJM() {
        return this.nazivJM;
    }

    public String getOznakaJM() {
        return oznakaJM;
    }

    public void setSifJM(Long sifJM) {
        this.sifJM = sifJM;
    }

    public void setNazivJM(String nazivJM) {
        this.nazivJM = nazivJM;
    }

    public void setOznakaJM(String oznakaJM) {
        this.oznakaJM = oznakaJM;
    }

    @Override
    public String nazivTabele() {
       return "JedinicaMere";
    }

    @Override
    public String alijas() {
        return "JM";
    }

    @Override
    public String join() {
        return "";
    }
    
    public String order(){
        return " ORDER BY SIFJM";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            JedinicaMere jm = new JedinicaMere(rs.getLong("sifJM"), rs.getString("nazivJM"), rs.getString("oznakaJM"));
            lista.add(jm);
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
        return "sifJM= " + sifJM;
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
    
    
    
    
    
    
    
}
