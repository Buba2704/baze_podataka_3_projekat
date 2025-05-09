/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author zoran
 */
public class ZapisnikGRP extends AbstractDomainObject {

    private Long sifZGR;
    private Long evidencioniBroj;
    private Date datumDokumenta;
    private String oznaka;
    private OrganizacionaJedinica orgJed;
    private Radnik radnik;
    private Magacin magacin;
    private String formatDate;

    public ZapisnikGRP() {
    }

    public ZapisnikGRP(Long sifZGR, Long evidencioniBroj, Date datumDokumenta, String oznaka, OrganizacionaJedinica orgJed, Radnik radnik, Magacin magacin) {
        this.sifZGR = sifZGR;
        this.evidencioniBroj = evidencioniBroj;
        this.datumDokumenta = datumDokumenta;
        this.oznaka = oznaka;
        this.orgJed = orgJed;
        this.radnik = radnik;
        this.magacin = magacin;
    }
    
    public ZapisnikGRP(Long sifZGR, Long evidencioniBroj, String formatDate, String oznaka, OrganizacionaJedinica orgJed, Radnik radnik, Magacin magacin) {
        this.sifZGR = sifZGR;
        this.evidencioniBroj = evidencioniBroj;
        this.formatDate = formatDate;
        this.oznaka = oznaka;
        this.orgJed = orgJed;
        this.radnik = radnik;
        this.magacin = magacin;
    }
    
    
    
    @Override
    public String nazivTabele() {
        return "ZapisnikOUlazuGotoveRobe";
    }

    @Override
    public String alijas() {
        return "z";
    }

    @Override
    public String join() {
        return "JOIN ORGANIZACIONAJEDINICA O ON(O.SIFORGJED = Z.SIFORGJED) JOIN RADNIK R ON(R.SIFRADNIKA = Z.SIFRADNIKA) JOIN MAGACIN M ON (M.SIFMAGACINA = Z.SIFMAGACINA)";
    }

    @Override
    public String order() {
        return " ORDER BY SIFZGR";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            Radnik r = new Radnik(rs.getLong("sifRadnika"), rs.getString("ime"), rs.getString("prezime"), 0l, null, rs.getLong("telefon"), rs.getString("adresa"));
             Magacin m = new Magacin(rs.getLong("sifMagacina"), rs.getString("nazivMagacina"), null, rs.getString("namena"), rs.getDate("poslDatumTreb"));
             OrganizacionaJedinica org = new OrganizacionaJedinica(rs.getLong("sifOrgJed"), rs.getString("nazivOrgJed"));
             ZapisnikGRP z = new ZapisnikGRP(rs.getLong("sifZGR"), rs.getLong("evidencioniBroj"), rs.getDate("datumDokumenta"), rs.getString("oznaka"), org, r, m);
            lista.add(z);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " ( sifZGR, evidencioniBroj, datumDokumenta, oznaka, sifOrgJed, sifRadnika, sifMagacina ) ";
    }

    @Override
    public String koloneZaSelect() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "sifZGR = " + sifZGR;
    }

    @Override
    public String vrednostiZaInsert() {
          return " " + sifZGR + ", " + evidencioniBroj + ", "
            + " '" + formatDate + "', '" + oznaka + "', " +orgJed.getSifOrgJed() + ", " + radnik.getSifRadnika() + ", " + magacin.getSifMagacina() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " evidencioniBroj = " + evidencioniBroj + ", datumDokumenta = '" + formatDate + "', oznaka = '" + oznaka + "', sifOrgJed = " + orgJed.getSifOrgJed() + ", sifRadnika = " + radnik.getSifRadnika() + ", sifMagacina = " + magacin.getSifMagacina() + " ";
    }

    @Override
    public String uslov() {
       return "";
    }

    public Long getSifZGR() {
        return sifZGR;
    }

    public Long getEvidencioniBroj() {
        return evidencioniBroj;
    }

    public Date getDatumDokumenta() {
        return datumDokumenta;
    }

    public String getOznaka() {
        return oznaka;
    }

    public OrganizacionaJedinica getOrgJed() {
        return orgJed;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public Magacin getMagacin() {
        return magacin;
    }

    public void setSifZGR(Long sifZGR) {
        this.sifZGR = sifZGR;
    }

    public void setEvidencioniBroj(Long evidencioniBroj) {
        this.evidencioniBroj = evidencioniBroj;
    }

    public void setDatumDokumenta(Date datumDokumenta) {
        this.datumDokumenta = datumDokumenta;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public void setOrgJed(OrganizacionaJedinica orgJed) {
        this.orgJed = orgJed;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public void setMagacin(Magacin magacin) {
        this.magacin = magacin;
    }
    
    public String getFormatDate(){
        Format formater = new SimpleDateFormat("dd.MM.yyyy.");
        String stringDate = formater.format(this.datumDokumenta);
        return stringDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }
    
}
