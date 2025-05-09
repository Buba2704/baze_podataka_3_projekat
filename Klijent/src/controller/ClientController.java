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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author PC
 */
public class ClientController {

    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }



    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }

    public ArrayList<JedinicaMere> getAllJM() throws Exception{
        return (ArrayList<JedinicaMere>) sendRequest(Operation.GET_ALL_JM, null);
    }

    public ArrayList<Proizvod> getAllProizvod() throws Exception {
       return (ArrayList<Proizvod>) sendRequest(Operation.GET_ALL_PROIZVOD, null);
    }

    public void updateProizvod(Proizvod proizvod) throws Exception {
        sendRequest(Operation.UPDATE_PROIZVOD, proizvod);
    }

    public void addProizvod(Proizvod proizvod) throws Exception {
        sendRequest(Operation.ADD_PROIZVOD, proizvod);
    }

    public void deleteProizvod(Proizvod proizvod) throws Exception {
       sendRequest(Operation.DELETE_PROIZVOD, proizvod);
    }

    public ArrayList<IstorijaStanjaZaliha> getAllIstorija() throws Exception {
        return (ArrayList<IstorijaStanjaZaliha>) sendRequest(Operation.GET_ALL_ISTORIJA, null);
    }

    public ArrayList<Magacin> getAllMagacin() throws Exception {
       return (ArrayList<Magacin>) sendRequest(Operation.GET_ALL_MAGACIN, null);
    }

    public void addIstorijaStanja(IstorijaStanjaZaliha istorija) throws Exception {
        sendRequest(Operation.ADD_ISTORIJA, istorija);
    }

    public void updateIstorija(IstorijaStanjaZaliha istorija) throws Exception {
        sendRequest(Operation.UPDATE_ISTORIJA, istorija);
    }

    public void deleteIstorija(IstorijaStanjaZaliha istorija) throws Exception {
        sendRequest(Operation.DELETE_ISTORIJA, istorija);
    }

    public ArrayList<StavkaZapisnikaOPrijemuMaterijala> getAllStavkaZOPM() throws Exception {
        return (ArrayList<StavkaZapisnikaOPrijemuMaterijala>) sendRequest(Operation.GET_ALL_STAVKAZOPM, null);
    }

    public void updateStavkaZOPM(StavkaZapisnikaOPrijemuMaterijala s) throws Exception {
        sendRequest(Operation.UPDATE_STAVKAZOPM, s);
    }

    public ArrayList<ZapisnikOPrijemuMaterijala> getAllZOPM() throws Exception {
       return (ArrayList<ZapisnikOPrijemuMaterijala>) sendRequest(Operation.GET_ALL_ZOPM, null);
    }

    public void addStavkaZOPM(StavkaZapisnikaOPrijemuMaterijala stavka) throws Exception {
        sendRequest(Operation.ADD_STAVKAZOPM, stavka);
    }

    public void deleteStavkaZOPM(StavkaZapisnikaOPrijemuMaterijala stavka) throws Exception {
        sendRequest(Operation.DELETE_STAVKAZOPM, stavka);
    }

    public ArrayList<PoslovniPartnerView> getAllPoslovniPartnerView() throws Exception {
        return (ArrayList<PoslovniPartnerView>) sendRequest(Operation.GET_ALL_PARTNERVIEW, null);
    }

    public ArrayList<PoslovniPartner> getAllPoslovniPartner() throws Exception {
        return (ArrayList<PoslovniPartner>) sendRequest(Operation.GET_ALL_PARTNER, null);
    }

    public ArrayList<PoslovniPartnerDetalji> getAllPoslovniPartnerDetalji() throws Exception {
        return (ArrayList<PoslovniPartnerDetalji>) sendRequest(Operation.GET_ALL_PARTNERDETALJI, null);
    }

    public ArrayList<Mesto> getAllMesta() throws Exception {
        return (ArrayList<Mesto>) sendRequest(Operation.GET_ALL_MESTO, null);
    }

    public void addPoslovniPartner(PoslovniPartnerView partner) throws Exception {
        sendRequest(Operation.ADD_PARTNER, partner);
    }

    public void updatePoslovniPartner(PoslovniPartnerView partner) throws Exception {
        sendRequest(Operation.UPDATE_PARTNER, partner);
    }

    public void deletePoslovniPartner(PoslovniPartnerView partner) throws Exception {
        sendRequest(Operation.DELETE_PARTNER, partner);
    }

    public ArrayList<Radnik> getAllRadnik() throws Exception {
       return (ArrayList<Radnik>) sendRequest(Operation.GET_ALL_RADNIK, null); 
    }

    public void updateRadnik(Radnik r) throws Exception {
       sendRequest(Operation.UPDATE_RADNIK, r);
    }

    public void addRadnik(Radnik r) throws Exception {
       sendRequest(Operation.ADD_RADNIK, r); 
    }

    public void deleteRadnik(Radnik radnik) throws Exception {
        sendRequest(Operation.DELETE_RADNIK, radnik);
    }

    public ArrayList<Trebovanje> getAllTrebovanje() throws Exception {
        return (ArrayList<Trebovanje>) sendRequest(Operation.GET_ALL_TREBOVANJE, null);
    }

    public ArrayList<ZapisnikGRP1> getAllZapisnikGR1() throws Exception {
        return (ArrayList<ZapisnikGRP1>) sendRequest(Operation.GET_ALL_ZAPISNIKGR1, null); 
    }

    public ArrayList<ZapisnikGRP2> getAllZapisnikGR2() throws Exception {
        return (ArrayList<ZapisnikGRP2>) sendRequest(Operation.GET_ALL_ZAPISNIKGR2, null); 
    }

    public ArrayList<ZapisnikGRP3> getAllZapisnikGR3() throws Exception {
        return (ArrayList<ZapisnikGRP3>) sendRequest(Operation.GET_ALL_ZAPISNIKGR3, null);
    }

    public ArrayList<ZapisnikGRP> getAllZapisnikGR() throws Exception {
        return (ArrayList<ZapisnikGRP>) sendRequest(Operation.GET_ALL_ZAPISNIKGR, null);
    }

    public ArrayList<OrganizacionaJedinica> getAllOrgJed() throws Exception {
       return (ArrayList<OrganizacionaJedinica>) sendRequest(Operation.GET_ALL_ORGJED, null);
    }

    public void addZapisnikGR(ZapisnikGRP z) throws Exception {
        sendRequest(Operation.ADD_ZAPISNIKGR, z); 
    }

    public void updateZapisnikGR(ZapisnikGRP z) throws Exception {
       sendRequest(Operation.UPDATE_ZAPISNIKGR, z);
    }

    public void deleteZapisnik(ZapisnikGRP z) throws Exception {
        sendRequest(Operation.DELETE_ZAPISNIKGR, z);
    }

    public void addTrebovanje(Trebovanje t) throws Exception {
        sendRequest(Operation.ADD_TREBOVANJE, t);
    }

    public void updateTrebovanje(Trebovanje t) throws Exception {
        sendRequest(Operation.UPDATE_TREBOVANJE, t);
    }

    public void deleteTrebovanje(Trebovanje t) throws Exception {
        sendRequest(Operation.DELETE_TREBOVANJE, t);
    }

    public ArrayList<Namena> getAllNamena() throws Exception {
        return (ArrayList<Namena>) sendRequest(Operation.GET_ALL_NAMENA, null);
    }

    public void addMagacin(Magacin m) throws Exception {
        sendRequest(Operation.ADD_MAGACIN, m);
    }

    public void updateMagacin(Magacin m) throws Exception {
        sendRequest(Operation.UPDATE_MAGACIN, m);
    }

    public void deleteMagacin(Magacin m) throws Exception {
        sendRequest(Operation.DELETE_MAGACIN, m);
    }

    public ArrayList<Pakovanje> getAllPakovanje() throws Exception {
        return (ArrayList<Pakovanje>) sendRequest(Operation.GET_ALL_PAKOVANJE, null);
    }

    public void addPakovanje(Pakovanje p) throws Exception {
        sendRequest(Operation.ADD_PAKOVANJE, p);
    }

    public void updatePakovanje(Pakovanje p) throws Exception {
        sendRequest(Operation.UPDATE_PAKOVANJE, p);
    }

    public void deletePakovanje(Pakovanje p) throws Exception {
        sendRequest(Operation.DELETE_PAKOVANJE, p);
    }


    
}
