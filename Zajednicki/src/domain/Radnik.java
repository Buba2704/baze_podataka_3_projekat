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
public class Radnik extends AbstractDomainObject{

    private Long sifRadnika;
    private String ime;
    private String prezime;
    private Long JMBG;
    private String POL;
    private Long telefon;
    private String adresa;

    public Radnik() {
    }

    public Radnik(Long sifRadnika, String ime, String prezime, Long JMBG, String POL, Long telefon, String adresa) {
        this.sifRadnika = sifRadnika;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.POL = POL;
        this.telefon = telefon;
        this.adresa = adresa;
    }
    
    public Radnik(Long sifRadnika, String ime, String prezime, Long JMBG, Long telefon, String adresa) {
        this.sifRadnika = sifRadnika;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.telefon = telefon;
        this.adresa = adresa;
    }

       
    
    @Override
    public String nazivTabele() {
        return "Radnik";
    }

    @Override
    public String alijas() {
        return "R";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String order() {
        return "ORDER BY SIFRADNIKA";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            Radnik r = new Radnik(rs.getLong("sifRadnika"), rs.getString("ime"), rs.getString("prezime"), rs.getLong("JMBG"), rs.getString("POL"), rs.getLong("telefon"), rs.getString("adresa"));
            lista.add(r);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
         return " ( sifRadnika, ime, prezime, JMBG, telefon, adresa ) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
         return "sifRadnika = " + sifRadnika;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + sifRadnika + ", '" + ime + "', "
                + "'" + prezime + "', obj_jmbg( " + JMBG + "), " + telefon + ", '" + adresa + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "ime = '" + ime + "', prezime = '" + prezime + "', JMBG = obj_jmbg(" + JMBG + "), telefon = " + telefon + ", adresa = '" + adresa + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }
    
    public String koloneZaSelect() {
        return "R.SIFRADNIKA, R.IME, R.PREZIME, R.JMBG.GET_VREDNOST() \"JMBG\", R.JMBG.GET_POL() \"POL\", R.TELEFON, R.ADRESA ";
    }

    public Long getSifRadnika() {
        return sifRadnika;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public Long getJMBG() {
        return JMBG;
    }

    public String getPOL() {
        return POL;
    }

    public Long getTelefon() {
        return telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setSifRadnika(Long sifRadnika) {
        this.sifRadnika = sifRadnika;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setJMBG(Long JMBG) {
        this.JMBG = JMBG;
    }

    public void setPOL(String POL) {
        this.POL = POL;
    }

    public void setTelefon(Long telefon) {
        this.telefon = telefon;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return sifRadnika + " - " + ime + " " + prezime;
    }
    

    
}
