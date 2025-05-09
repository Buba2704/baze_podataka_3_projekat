/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.IstorijaStanjaZaliha;
import domain.JedinicaMere;
import domain.Magacin;
import domain.Mesto;
import domain.Namena;
import domain.OrganizacionaJedinica;
import domain.Pakovanje;
import domain.PoslovniPartner;
import domain.PoslovniPartnerDetalji;
import domain.PoslovniPartnerView;
import domain.Proizvod;
import domain.Radnik;
import domain.StavkaZapisnikaOPrijemuMaterijala;
import domain.Trebovanje;
import domain.ZapisnikGRP;
import domain.ZapisnikGRP1;
import domain.ZapisnikGRP2;
import domain.ZapisnikGRP3;
import domain.ZapisnikOPrijemuMaterijala;
import java.util.ArrayList;
import javafx.scene.shape.Mesh;


/**
 *
 * @author PC
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    
    public Object getAllJediniceMere() throws Exception {
       SOGetAllJM so = new SOGetAllJM();
        so.templateExecute(new JedinicaMere());
        return so.getLista();
    }

    public Object getAllProizvod() throws Exception {
        SOGetAllProizvod so = new SOGetAllProizvod();
        so.templateExecute(new Proizvod());
        return so.getLista();
    }

    public void updateProizvod(Proizvod proizvod) throws Exception {
        (new SOUpdateProizvod()).templateExecute(proizvod);
    }

    public void addProizvod(Proizvod proizvod) throws Exception {
        (new SOAddProizvod()).templateExecute(proizvod);
    }

    public void deleteProizvod(Proizvod proizvod) throws Exception {
       (new SODeleteProizvod()).templateExecute(proizvod);
    }

    public Object getAllIstorija() throws Exception {
        SOGetAllIstorija so = new SOGetAllIstorija();
        so.templateExecute(new IstorijaStanjaZaliha());
        return so.getLista();
    }

    public Object getAllMagacin() throws Exception {
        SOGetAllMagacin so = new SOGetAllMagacin();
        so.templateExecute(new Magacin());
        return so.getLista();
    }

    public void addIstorija(IstorijaStanjaZaliha istorija) throws Exception {
        (new SOAddIstorija()).templateExecute(istorija);
    }

    public void updateIstorija(IstorijaStanjaZaliha istorija) throws Exception {
        (new SOUpdateIstorija()).templateExecute(istorija);
    }

    public void deleteIstorija(IstorijaStanjaZaliha istorijaStanjaZaliha) throws Exception {
       (new SODeleteIstorija()).templateExecute(istorijaStanjaZaliha);
    }

    public Object getAllStavkaZOPM() throws Exception {
        SOGetAllStavkaZOPM so = new SOGetAllStavkaZOPM();
        so.templateExecute(new StavkaZapisnikaOPrijemuMaterijala());
        return so.getLista();
    }

    public void updateStavkaZOPM(StavkaZapisnikaOPrijemuMaterijala stavka) throws Exception {
        (new SOUpdateStavkaZOPM()).templateExecute(stavka);
    }

    public Object getAllZOPM() throws Exception {
        SOGetAllZOPM so = new SOGetAllZOPM();
        so.templateExecute(new ZapisnikOPrijemuMaterijala());
        return so.getLista();
    }

    public void addStavkaZOPM(StavkaZapisnikaOPrijemuMaterijala stavka) throws Exception {
        (new SOAddStavkaZOPM()).templateExecute(stavka);
    }

    public void deleteStavkaZOPM(StavkaZapisnikaOPrijemuMaterijala stavka) throws Exception {
       (new SODeleteStavkaZOPM()).templateExecute(stavka);
    }

    public Object getAllPoslovniPartnerView() throws Exception {
        SOGetAllPartnerView so = new SOGetAllPartnerView ();
        so.templateExecute(new PoslovniPartnerView());
        return so.getLista();
    }

    public Object getAllPoslovniPartner() throws Exception {
        SOGetAllPartner so = new SOGetAllPartner ();
        so.templateExecute(new PoslovniPartner());
        return so.getLista();
    }

    public Object getAllPoslovniPartnerDetalji() throws Exception {
        SOGetAllPartnerDetalji so = new SOGetAllPartnerDetalji ();
        so.templateExecute(new PoslovniPartnerDetalji());
        return so.getLista();
    }

    public Object getAllMesto() throws Exception {
        SOGetAllMesto so = new SOGetAllMesto ();
        so.templateExecute(new Mesto());
        return so.getLista();
    }


    public void addPartner(PoslovniPartnerView partner) throws Exception {
        (new SOAddPartner()).templateExecute(partner);
    }

    public void updatePartner(PoslovniPartnerView poslovniPartnerView) throws Exception {
        (new SOUpdatePartner()).templateExecute(poslovniPartnerView);
    }

    public void deletePartner(PoslovniPartnerView partner) throws Exception {
        (new SODeletePartner()).templateExecute(partner);
    }

    public Object getAllRadnik() throws Exception {
        SOGetAllRadnike so = new SOGetAllRadnike();
        so.templateExecute(new Radnik());
        return so.getLista();
    }

    public void updateRadnik(Radnik radnik) throws Exception {
        (new SOUpdateRadnik()).templateExecute(radnik);
    }

    public void addRadnik(Radnik radnik) throws Exception {
        (new SOAddRadnik()).templateExecute(radnik);
    }

    public void deleteRadnik(Radnik radnik) throws Exception {
        (new SODeleteRadnik()).templateExecute(radnik);
    }

    public Object getAllTrebovanje() throws Exception {
        SOGetAllTrebovanje so = new SOGetAllTrebovanje();
        so.templateExecute(new Trebovanje());
        return so.getLista();
    }

    public Object getAllZapisnikGR1() throws Exception {
        SOGetAllZapisnikGR1 so = new SOGetAllZapisnikGR1();
        so.templateExecute(new ZapisnikGRP1());
        return so.getLista();
    }

    public Object getAllZapisnikGR2() throws Exception {
        SOGetAllZapisnikGR2 so = new SOGetAllZapisnikGR2();
        so.templateExecute(new ZapisnikGRP2());
        return so.getLista();
    }

    public Object getAllZapisnikGR3() throws Exception {
        SOGetAllZapisnikGR3 so = new SOGetAllZapisnikGR3();
        so.templateExecute(new ZapisnikGRP3());
        return so.getLista();
    }

    public Object getAllZapisnikGR() throws Exception {
        SOGetAllZapisnikGR so = new SOGetAllZapisnikGR();
        so.templateExecute(new ZapisnikGRP());
        return so.getLista();
    }

    public Object getAllOrgJed() throws Exception {
        SOGetAllOrgJed so = new SOGetAllOrgJed();
        so.templateExecute(new OrganizacionaJedinica());
        return so.getLista();
    }

    public void addZapisnikGR(ZapisnikGRP zapisnikGRP) throws Exception {
        (new SOAddZapisnikGR()).templateExecute(zapisnikGRP);
    }

    public void updateZapisnikGR(ZapisnikGRP zapisnikGRP) throws Exception {
        (new SOUpdateZapisnikGR()).templateExecute(zapisnikGRP);
    }

    public void deleteZapisnikGR(ZapisnikGRP zapisnikGRP) throws Exception {
        (new SODeleteZapisnikGR()).templateExecute(zapisnikGRP);
    }

    public void addTrebovanje(Trebovanje trebovanje) throws Exception {
        (new SOAddTrebovanje()).templateExecute(trebovanje);
    }

    public void updateTrebovanje(Trebovanje trebovanje) throws Exception {
        (new SOUpdateTrebovanje()).templateExecute(trebovanje);
    }

    public void deleteTrebovanje(Trebovanje trebovanje) throws Exception {
        (new SODeleteTrebovanje()).templateExecute(trebovanje);
    }

    public Object getAllNamena() throws Exception {
        SOGetAllNamena so = new SOGetAllNamena();
        so.templateExecute(new Namena());
        return so.getLista();
    }

    public void addMagacin(Magacin magacin) throws Exception {
       (new SOAddMagacin()).templateExecute(magacin);
    }

    public void updateMagacin(Magacin magacin) throws Exception {
        (new SOUpdateMagacin()).templateExecute(magacin);
    }

    public void deleteMagacin(Magacin magacin) throws Exception {
        (new SODeleteMagacin()).templateExecute(magacin);
    }

    public Object getAllPakovanje() throws Exception {
        SOGetAllPakovanje so = new SOGetAllPakovanje();
        so.templateExecute(new Pakovanje());
        return so.getLista();
    }

    public void addPakovanje(Pakovanje pakovanje) throws Exception {
        (new SOAddPakovanje()).templateExecute(pakovanje);
    }

    public void updatePakovanje(Pakovanje pakovanje) throws Exception {
        (new SOUpdatePakovanje()).templateExecute(pakovanje);
    }

    public void deletePakovanje(Pakovanje pakovanje) throws Exception {
        (new SODeletePakovanje()).templateExecute(pakovanje);
    }


}
