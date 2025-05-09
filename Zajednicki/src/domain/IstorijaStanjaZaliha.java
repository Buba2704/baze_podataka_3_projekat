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
import javafx.scene.chart.PieChart;

/**
 *
 * @author zoran
 */
public class IstorijaStanjaZaliha extends AbstractDomainObject{
    
    private Proizvod proizvod;
    private Date datum;
    private String nazivProizvoda;
    private Float kolicinaNaStanju;
    private Magacin magacin;
    private String formatDate;
    private int pok;
    private Proizvod noviProizvod;

    public IstorijaStanjaZaliha() {
  
    }

    public IstorijaStanjaZaliha(Proizvod proizvod, String formatDate, String nazivProizvoda, Float kolicinaNaStanju, Magacin magacin) {
        this.proizvod = proizvod;
        this.formatDate = formatDate;
        this.nazivProizvoda = nazivProizvoda;
        this.kolicinaNaStanju = kolicinaNaStanju;
        this.magacin = magacin;
    }
    
        public IstorijaStanjaZaliha(Proizvod proizvod, Date datum, String nazivProizvoda, Float kolicinaNaStanju, Magacin magacin) {
        this.proizvod = proizvod;
        this.datum = datum;
        this.nazivProizvoda = nazivProizvoda;
        this.kolicinaNaStanju = kolicinaNaStanju;
        this.magacin = magacin;
    }

    
        

    @Override
    public String nazivTabele() {
        return " istorijaStanjaZaliha ";
    }

    @Override
    public String alijas() {
        return " I ";
    }
    
    
    
    public String order(){
        return " ORDER BY P.SIFPROIZVODA, I.SIFMAGACINA, I.DATUM ";
    }

    @Override
    public String join() {
        return "JOIN PROIZVOD P ON(I.SIFPROIZVODA = P.SIFPROIZVODA) JOIN MAGACIN M ON(M.SIFMAGACINA = I.SIFMAGACINA) JOIN JEDINICAMERE JM ON (JM.SIFJM = P.SIFJM)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while(rs.next()){
            JedinicaMere jm = new JedinicaMere(rs.getLong("sifJM"), rs.getString("nazivJM"),rs.getString("oznakaJM") );
            Proizvod pro = new Proizvod(rs.getLong("sifProizvoda"), rs.getString("nazivProizvoda"), rs.getString("dodatniNaziv"),
                    rs.getString("oznaka"), jm, rs.getFloat("dostupnaKolicina"));
            Magacin mag = new Magacin(rs.getLong("sifMagacina"), rs.getString("nazivMagacina"), null,rs.getString("namena"), rs.getDate("poslDatumTreb"));
            IstorijaStanjaZaliha is = new IstorijaStanjaZaliha(pro, rs.getDate("datum"), rs.getString("nazivProizvoda"), rs.getFloat("kolicinaNaStanju"), mag);
            lista.add(is);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (sifProizvoda, datum, kolicinaNaStanju, sifMagacina) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
       return " sifProizvoda = " + proizvod.getSifProizvoda() + " AND datum = '" + formatDate + "' ";
    }

    @Override
    public String vrednostiZaInsert() {
         return " " + proizvod.getSifProizvoda() + ", '" + formatDate + "', "
                + " " + kolicinaNaStanju + ", " + magacin.getSifMagacina() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        if(pok!=0 && nazivProizvoda!=null){
            System.out.println("Oba promenjena");
            return "sifProizvoda = " + noviProizvod.getSifProizvoda() + ", nazivProizvoda = '" + nazivProizvoda + "', kolicinaNaStanju = " + kolicinaNaStanju + ", sifMagacina = " + magacin.getSifMagacina() + " ";
        } else if(pok!=0){
            System.out.println("Promenjena sifra");
            return " sifProizvoda = " + noviProizvod.getSifProizvoda() + ", kolicinaNaStanju = " + kolicinaNaStanju + ", sifMagacina = " + magacin.getSifMagacina() + " ";
        } else if(nazivProizvoda!= null){
            System.out.println("Promenjen naziv");
            return " nazivProizvoda = '" + nazivProizvoda + "', kolicinaNaStanju = " + kolicinaNaStanju + ", sifMagacina = " + magacin.getSifMagacina() + " ";
        } else {
            System.out.println("Nista nije promenjeno");
            return " kolicinaNaStanju = " + kolicinaNaStanju + ", sifMagacina = " + magacin.getSifMagacina() + " ";
        }
    }
        /*if(proizvod!= null && nazivProizvoda!= null){
            return " sifProizvoda = " + proizvod.getSifProizvoda() + ", nazivProizvoda = '" + nazivProizvoda + "', kolicinaNaStanju = " + kolicinaNaStanju + ", sifMagacina = " + magacin.getSifMagacina() + "";
        } else if(proizvod!= null) {
            return " sifProizvoda = " + proizvod.getSifProizvoda() + ", kolicinaNaStanju = " + kolicinaNaStanju + ", sifMagacina = " + magacin.getSifMagacina() + " ";
        } else if(nazivProizvoda!=null){
            return " nazivProizvoda = '" + nazivProizvoda + "', kolicinaNaStanju = " + kolicinaNaStanju + ", sifMagacina = " + magacin.getSifMagacina() + " ";
        }
        else{
            return " kolicinaNaStanju = " + kolicinaNaStanju + ", sifMagacina = " + magacin.getSifMagacina() + " ";
        }*/

    @Override
    public String koloneZaSelect() {
        return "";
    }
        
   
    @Override
    public String uslov() {
        return "";
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public Date getDatum() {
        return datum;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public Float getKolicinaNaStanju() {
        return kolicinaNaStanju;
    }

    public Magacin getMagacin() {
        return magacin;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public void setKolicinaNaStanju(Float kolicinaNaStanju) {
        this.kolicinaNaStanju = kolicinaNaStanju;
    }

    public void setMagacin(Magacin magacin) {
        this.magacin = magacin;
    }
    
    public String getFormatDate(){
        Format formater = new SimpleDateFormat("dd.MM.yyyy.");
        String stringDate = formater.format(this.datum);
        return stringDate;
    }


    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }

    public int getPok() {
        return pok;
    }

    public void setPok(int pok) {
        this.pok = pok;
    }

    public Proizvod getNoviProizvod() {
        return noviProizvod;
    }

    public void setNoviProizvod(Proizvod noviProizvod) {
        this.noviProizvod = noviProizvod;
    }
    

}
