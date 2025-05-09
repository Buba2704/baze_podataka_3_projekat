/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import javafx.scene.input.DataFormat;

/**
 *
 * @author zoran
 */
public class Magacin extends AbstractDomainObject{
    
    private Long sifMagacina;
    private String nazivMagacina;
    private Radnik radnik;
    private String namena;
    private Date poslDatumTreb;
    private String formatDate;
    private int pok;

    public Magacin() {
    }

    public Magacin(Long sifMagacina, String nazivMagacina, Radnik radnik, String namena, Date poslDatumTreb) {
        this.sifMagacina = sifMagacina;
        this.nazivMagacina = nazivMagacina;
        this.radnik = radnik;
        this.namena = namena;
        this.poslDatumTreb = poslDatumTreb;
        
    }
    
    public Magacin(Long sifMagacina, String nazivMagacina, Radnik radnik, String namena, String formatDate) {
        this.sifMagacina = sifMagacina;
        this.nazivMagacina = nazivMagacina;
        this.radnik = radnik;
        this.namena = namena;
        this.formatDate = formatDate;
    }

    
    @Override
    public String nazivTabele() {
        return " magacin ";
    }

    @Override
    public String alijas() {
       return " m ";
    }

    @Override
    public String join() {
       return "JOIN RADNIK R ON (R.SIFRADNIKA = M.SIFRADNIKA)";
    }
    
    public String order(){
        return " ORDER BY SIFMAGACINA";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            Radnik r = new Radnik(rs.getLong("sifRadnika"), rs.getString("ime"), rs.getString("prezime"), 0l, null, rs.getLong("telefon"), rs.getString("adresa"));
            Magacin m = new Magacin(rs.getLong("sifMagacina"), rs.getString("nazivMagacina"), r, rs.getString("namena"), rs.getDate("poslDatumTreb"));
            lista.add(m);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
       return "( sifMagacina, nazivMagacina, sifRadnika, namena )";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "sifMagacina = " + sifMagacina;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + sifMagacina + ", '" + nazivMagacina + "', " + radnik.getSifRadnika() + ", "
                + "'" + namena + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        if(formatDate!= null && this.pok!= 0)
            return "nazivMagacina = '" + nazivMagacina + "', sifRadnika = " +radnik.getSifRadnika() + ", namena = '" + namena + "', poslDatumTreb = '" + formatDate + "' ";
        else if(this.pok != 0 && formatDate == null)
            return "nazivMagacina = '" + nazivMagacina + "', sifRadnika = " +radnik.getSifRadnika() + ", namena = '" + namena + "', poslDatumTreb = " + formatDate + " ";
        else
            return "nazivMagacina = '" + nazivMagacina + "', sifRadnika = " + radnik.getSifRadnika() + ", namena = '" + namena + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }
    
    public String koloneZaSelect() {
        return "distinct namena";
    }

    public Long getSifMagacina() {
        return sifMagacina;
    }

    public String getNazivMagacina() {
        return nazivMagacina;
    }
    private static final Logger LOG = Logger.getLogger(Magacin.class.getName());

    

    public String getNamena() {
        return namena;
    }

    public Date getPoslDatumTreb() {
        return poslDatumTreb;
    }

    public void setSifMagacina(Long sifMagacina) {
        this.sifMagacina = sifMagacina;
    }

    public void setNazivMagacina(String nazivMagacina) {
        this.nazivMagacina = nazivMagacina;
    }


    public void setNamena(String namena) {
        this.namena = namena;
    }

    public void setPoslDatumTreb(Date poslDatumTreb) {
        this.poslDatumTreb = poslDatumTreb;
    }
    
    public String toString() {
        return sifMagacina + " - " + nazivMagacina;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }
    
    
    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }

    public String getFormatDate(){
        if(this.poslDatumTreb!= null){
            Format formater = new SimpleDateFormat("dd.MM.yyyy.");
            String stringDate = formater.format(this.poslDatumTreb);
            return stringDate;
        }
        return null;
    }

    public int getPok() {
        return pok;
    }

    public void setPok(int pok) {
        this.pok = pok;
    }
    
    
    


    
}
