/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.chart.PieChart;

/**
 *
 * @author zoran
 */
public class ZapisnikOPrijemuMaterijala extends AbstractDomainObject{

    private Long sifZOPM;
    private Long brojDostavnice;
    private Long evidencioniBroj;
    private Date datumDokumenta;
    private Long sifPorudzbenice;
    private PoslovniPartner partner;
    private Radnik radnik;
    private Magacin magacin;
    private Long sifNacinIsp;

    public ZapisnikOPrijemuMaterijala() {
    }

    public ZapisnikOPrijemuMaterijala(Long sifZOPM, Long brojDostavnice, Long evidencioniBroj, Date datumDokumenta, Long sifPorudzbenice, PoslovniPartner partner, Radnik radnik, Magacin magacin, Long sifNacinIsp) {
        this.sifZOPM = sifZOPM;
        this.brojDostavnice = brojDostavnice;
        this.evidencioniBroj = evidencioniBroj;
        this.datumDokumenta = datumDokumenta;
        this.sifPorudzbenice = sifPorudzbenice;
        this.partner = partner;
        this.radnik = radnik;
        this.magacin = magacin;
        this.sifNacinIsp = sifNacinIsp;
    }
    
    
    @Override
    public String nazivTabele() {
        return "ZapisnikOPrijemuMaterijala";
    }

    @Override
    public String alijas() {
        return "Z";
    }

    @Override
    public String join() {
        return "JOIN MAGACIN M ON(Z.SIFMAGACINA = M.SIFMAGACINA) JOIN RADNIK R ON(R.SIFRADNIKA = M.SIFRADNIKA) JOIN POSLOVNIPARTNER P ON (P.SIFPARTNERA = Z.SIFPARTNERA) ";
    }

    @Override
    public String order() {
        return "ORDER BY SIFZOPM";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            Radnik r = new Radnik(rs.getLong("sifRadnika"), rs.getString("ime"), rs.getString("prezime"), 0l, null, rs.getLong("telefon"), rs.getString("adresa"));
            Magacin m = new Magacin(rs.getLong("sifMagacina"), rs.getString("nazivMagacina"), r, rs.getString("namena"), rs.getDate("poslDatumTreb"));
            PoslovniPartner p = new PoslovniPartner(rs.getLong("sifPartnera"), rs.getString("nazivPartnera"));
            ZapisnikOPrijemuMaterijala z = new ZapisnikOPrijemuMaterijala(rs.getLong("sifZOPM"), rs.getLong("brojDostavnice"), rs.getLong("evidencioniBroj"), rs.getDate("datumDokumenta"), rs.getLong("sifPorudzbenice"), p, r, m, rs.getLong("sifNacinIsp"));
            lista.add(z);
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
         return "z.sifZOPM = " + this.sifZOPM;
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

    public Long getSifZOPM() {
        return sifZOPM;
    }

    public Long getBrojDostavnice() {
        return brojDostavnice;
    }

    public Long getEvidencioniBroj() {
        return evidencioniBroj;
    }

    public Date getDatumDokumenta() {
        return datumDokumenta;
    }

    public Long getSifPorudzbenice() {
        return sifPorudzbenice;
    }

    public PoslovniPartner getPartner() {
        return partner;
    }

    public void setPartner(PoslovniPartner partner) {
        this.partner = partner;
    }
    

    public Magacin getMagacin() {
        return magacin;
    }

    public Long getSifNacinIsp() {
        return sifNacinIsp;
    }

    public void setSifZOPM(Long sifZOPM) {
        this.sifZOPM = sifZOPM;
    }

    public void setBrojDostavnice(Long brojDostavnice) {
        this.brojDostavnice = brojDostavnice;
    }

    public void setEvidencioniBroj(Long evidencioniBroj) {
        this.evidencioniBroj = evidencioniBroj;
    }

    public void setDatumDokumenta(Date datumDokumenta) {
        this.datumDokumenta = datumDokumenta;
    }

    public void setSifPorudzbenice(Long sifPorudzbenice) {
        this.sifPorudzbenice = sifPorudzbenice;
    }


    public void setMagacin(Magacin magacin) {
        this.magacin = magacin;
    }

    public void setSifNacinIsp(Long sifNacinIsp) {
        this.sifNacinIsp = sifNacinIsp;
    }

    @Override
    public String toString() {
       return String.valueOf(this.sifZOPM);
    }
    
    public void setSifZOPMPretraga(Long sifZOPM) {
        this.sifZOPM = sifZOPM;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Radnik getRadnik() {
        return radnik;
    }
    
    
    
}
