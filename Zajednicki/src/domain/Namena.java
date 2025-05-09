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
public class Namena extends AbstractDomainObject{
    String namena;

    public Namena() {
    }

    public Namena(String namena) {
        this.namena = namena;
    }

    @Override
    public String nazivTabele() {
        return "magacin";
    }

    @Override
    public String alijas() {
        return "m";
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
            Namena n = new Namena(rs.getString("namena"));
            lista.add(n);
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
        return "distinct namena ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "";
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

    @Override
    public String toString() {
        return namena;
    }
    
    
    
    
}
