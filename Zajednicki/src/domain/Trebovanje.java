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
public class Trebovanje extends AbstractDomainObject{

    private Long sifTrebovanja;
    private Long evidencioniBroj;
    private Date datumDokumenta;
    private OrganizacionaJedinica OrgJedNosilacTroska;
    private OrganizacionaJedinica OrgJedMestoTroska;
    private Radnik radnikIzradio;
    private Radnik radnikOdobrio;
    private Magacin magacin;
    private String formatDate;

    public Trebovanje() {
    }

    public Trebovanje(Long sifTrebovanja, Long evidencioniBroj, Date datumDokumenta, OrganizacionaJedinica OrgJedNosilacTroska, OrganizacionaJedinica OrgJedMestoTroska, Radnik radnikIzradio, Radnik radnikOdobrio, Magacin magacin) {
        this.sifTrebovanja = sifTrebovanja;
        this.evidencioniBroj = evidencioniBroj;
        this.datumDokumenta = datumDokumenta;
        this.OrgJedNosilacTroska = OrgJedNosilacTroska;
        this.OrgJedMestoTroska = OrgJedMestoTroska;
        this.radnikIzradio = radnikIzradio;
        this.radnikOdobrio = radnikOdobrio;
        this.magacin = magacin;
    }

    public Trebovanje(Long sifTrebovanja, Long evidencioniBroj, String formatDate, OrganizacionaJedinica OrgJedNosilacTroska, OrganizacionaJedinica OrgJedMestoTroska, Radnik radnikIzradio, Radnik radnikOdobrio, Magacin magacin) {
        this.sifTrebovanja = sifTrebovanja;
        this.evidencioniBroj = evidencioniBroj;
        this.formatDate = formatDate;
        this.OrgJedNosilacTroska = OrgJedNosilacTroska;
        this.OrgJedMestoTroska = OrgJedMestoTroska;
        this.radnikIzradio = radnikIzradio;
        this.radnikOdobrio = radnikOdobrio;
        this.magacin = magacin;
    }
    
    
    
    
    
    @Override
    public String nazivTabele() {
        return "Trebovanje";
    }

    @Override
    public String alijas() {
        return "T";
    }

    @Override
    public String join() {
        return "JOIN ORGANIZACIONAJEDINICA ONT ON(ONT.SIFORGJED = T.SIFORGJEDNOSILACTROSKA) JOIN ORGANIZACIONAJEDINICA OMT ON(OMT.SIFORGJED = T.SIFORGJEDMESTOTROSKA) JOIN RADNIK RIz ON (RIz.SIFRADNIKA = T.SIFRADNIKAIZRADIO) JOIN RADNIK RO ON (RO.SIFRADNIKA = T.SIFRADNIKAODOBRIO) JOIN MAGACIN M ON (M.SIFMAGACINA = T.SIFMAGACINA)";
    }

    @Override
    public String order() {
        return " ORDER BY sifTrebovanja asc, datumdokumenta desc";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            Radnik rIzradio = new Radnik(rs.getLong("sifRadnikaIzradio"), rs.getString("imeIzradio"), rs.getString("prezimeIzradio"), 0l, null, 0l, null);
            Radnik rOdobrio = new Radnik(rs.getLong("sifRadnikaOdobrio"), rs.getString("imeOdobrio"), rs.getString("prezimeOdobrio"), 0l, null, 0l, null);
            OrganizacionaJedinica oNosilac = new OrganizacionaJedinica(rs.getLong("sifOrgJedNosilacTroska"), rs.getString("nazivNosilac"));
            OrganizacionaJedinica oMesto = new OrganizacionaJedinica(rs.getLong("sifOrgJedMestoTroska"), rs.getString("nazivMesto"));
            Magacin m = new Magacin(rs.getLong("sifMagacina"), rs.getString("nazivMagacina"), null, null, rs.getDate("poslDatumTreb"));
            Trebovanje t = new Trebovanje(rs.getLong("sifTrebovanja"), rs.getLong("evidencioniBroj"), rs.getDate("datumDokumenta"), oNosilac, oMesto, rIzradio, rOdobrio, m);
            lista.add(t);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " ( sifTrebovanja, evidencioniBroj, datumDokumenta, SifOrgJedNosilacTroska, sifOrgJedMestoTroska, sifRadnikaIzradio, sifRadnikaOdobrio, sifMagacina ) ";
    }

    @Override
    public String koloneZaSelect() {
        return "T.SIFTREBOVANJA, T.EVIDENCIONIBROJ, T.DATUMDOKUMENTA, T.SIFORGJEDNOSILACTROSKA, ONT.NAZIVORGJED \"nazivNosilac\", T.SIFORGJEDMESTOTROSKA, OMT.NAZIVORGJED \"nazivMesto\", T.SIFRADNIKAIZRADIO, RIz.IME \"imeIzradio\", RIz.PREZIME \"prezimeIzradio\", T.SIFRADNIKAODOBRIO, RO.IME \"imeOdobrio\", RO.PREZIME \"prezimeOdobrio\", T.SIFMAGACINA, M.NAZIVMAGACINA, M.POSLDATUMTREB ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "sifTrebovanja = " + sifTrebovanja;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + sifTrebovanja + ", " + evidencioniBroj+ ", "
            + " '" + formatDate + "', " + OrgJedNosilacTroska.getSifOrgJed() + ", " + OrgJedMestoTroska.getSifOrgJed() + " "
                + ", " + radnikIzradio.getSifRadnika() + ", " + radnikOdobrio.getSifRadnika() + ", " + magacin.getSifMagacina() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
         return " evidencioniBroj = " + evidencioniBroj + ", datumDokumenta = '" + formatDate + "', sifOrgJedNosilacTroska = " + OrgJedNosilacTroska.getSifOrgJed() + ", sifOrgJedMestoTroska = " + OrgJedMestoTroska.getSifOrgJed()  + ", sifRadnikaIzradio = " + radnikIzradio.getSifRadnika() + ", sifRadnikaOdobrio = " + radnikOdobrio.getSifRadnika() + ", sifMagacina = " + magacin.getSifMagacina() + " ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getSifTrebovanja() {
        return sifTrebovanja;
    }

    public Long getEvidencioniBroj() {
        return evidencioniBroj;
    }

    public Date getDatumDokumenta() {
        return datumDokumenta;
    }

    public OrganizacionaJedinica getOrgJedNosilacTroska() {
        return OrgJedNosilacTroska;
    }

    public OrganizacionaJedinica getOrgJedMestoTroska() {
        return OrgJedMestoTroska;
    }

    public Radnik getRadnikIzradio() {
        return radnikIzradio;
    }

    public Radnik getRadnikOdobrio() {
        return radnikOdobrio;
    }

    public Magacin getMagacin() {
        return magacin;
    }

    public void setSifTrebovanja(Long sifTrebovanja) {
        this.sifTrebovanja = sifTrebovanja;
    }

    public void setEvidencioniBroj(Long evidencioniBroj) {
        this.evidencioniBroj = evidencioniBroj;
    }

    public void setDatumDokumenta(Date datumDokumenta) {
        this.datumDokumenta = datumDokumenta;
    }

    public void setOrgJedNosilacTroska(OrganizacionaJedinica OrgJedNosilacTroska) {
        this.OrgJedNosilacTroska = OrgJedNosilacTroska;
    }

    public void setOrgJedMestoTroska(OrganizacionaJedinica OrgJedMestoTroska) {
        this.OrgJedMestoTroska = OrgJedMestoTroska;
    }

    public void setRadnikIzradio(Radnik radnikIzradio) {
        this.radnikIzradio = radnikIzradio;
    }

    public void setRadnikOdobrio(Radnik radnikOdobrio) {
        this.radnikOdobrio = radnikOdobrio;
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
