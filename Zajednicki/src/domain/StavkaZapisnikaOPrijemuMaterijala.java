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
public class StavkaZapisnikaOPrijemuMaterijala extends AbstractDomainObject{

    private ZapisnikOPrijemuMaterijala zapisnik;
    private int redniBroj;
    private Float kolicina;
    private Proizvod proizvod;
    private JedinicaMere jedinicaMere;

    public StavkaZapisnikaOPrijemuMaterijala() {
    }

    public StavkaZapisnikaOPrijemuMaterijala(ZapisnikOPrijemuMaterijala z, int redniBroj, Float kolicina, Proizvod p, JedinicaMere jm) {
        this.zapisnik = z;
        this.redniBroj = redniBroj;
        this.kolicina = kolicina;
        this.proizvod = p;
        this.jedinicaMere = jm;
    }
    
    
    
    @Override
    public String nazivTabele() {
        return "StavkaZapisnikaOPrijemuMaterijala";
    }

    @Override
    public String alijas() {
         return "S";
    }

    @Override
    public String join() {
        return "JOIN ZAPISNIKOPRIJEMUMATERIJALA Z ON(Z.SIFZOPM = S.SIFZOPM) JOIN PROIZVOD P ON(S.SIFPROIZVODA = P.SIFPROIZVODA) JOIN JEDINICAMERE JM ON(P.SIFJM = JM.SIFJM) JOIN MAGACIN M ON (Z.SIFMAGACINA = M.SIFMAGACINA)";
    }

    @Override
    public String order() {
        return " ORDER BY S.SIFZOPM, S.REDNIBROJ ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            Magacin m = new Magacin(rs.getLong("sifMagacina"), rs.getString("nazivMagacina"), null, rs.getString("namena"), rs.getDate("poslDatumTreb"));
            ZapisnikOPrijemuMaterijala z = new ZapisnikOPrijemuMaterijala(rs.getLong("sifZOPM"), rs.getLong("brojDostavnice"), rs.getLong("evidencioniBroj"), rs.getDate("datumDokumenta"), rs.getLong("sifPorudzbenice"), null, null, m, rs.getLong("sifNacinIsp"));
            JedinicaMere jm = new JedinicaMere(rs.getLong("sifJM"), rs.getString("nazivJM"),rs.getString("oznakaJM") );
            Proizvod pro = new Proizvod(rs.getLong("sifProizvoda"), rs.getString("nazivProizvoda"), rs.getString("dodatniNaziv"),
                    rs.getString("oznaka"), jm, rs.getFloat("dostupnaKolicina"));
            StavkaZapisnikaOPrijemuMaterijala s = new StavkaZapisnikaOPrijemuMaterijala(z, rs.getInt("redniBroj"), rs.getFloat("kolicina"), pro, jm);
            lista.add(s);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (sifZOPM, redniBroj, kolicina, sifProizvoda) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
         return " sifZOPM = " + zapisnik.getSifZOPM() + " AND redniBroj = " + redniBroj;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + zapisnik.getSifZOPM() + ", " + redniBroj + ", "
            + " " + kolicina + ", " + proizvod.getSifProizvoda() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        if(proizvod!= null && jedinicaMere!=null)
            return "kolicina = " + kolicina + ", sifProizvoda = " + proizvod.getSifProizvoda() + ", sifJM = " + jedinicaMere.getSifJM() + " ";
        else if(proizvod!= null)
            return "kolicina = " + kolicina + ", sifProizvoda = " + proizvod.getSifProizvoda() + " ";
        else if(jedinicaMere!= null)
            return "kolicina = " + kolicina + ", sifJM = " + jedinicaMere.getSifJM() + " ";
        else
            return "kolicina = " + kolicina + " ";
    }

    @Override
    public String uslov() {
        return "";
    }
    
    public String koloneZaSelect() {
        return "";
    }

    public ZapisnikOPrijemuMaterijala getZapisnik() {
        return zapisnik;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public Float getKolicina() {
        return kolicina;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }
    

    public void setZapisnik(ZapisnikOPrijemuMaterijala zapisnik) {
        this.zapisnik = zapisnik;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public void setKolicina(Float kolicina) {
        this.kolicina = kolicina;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }
    
}
