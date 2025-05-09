/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaZapisnikaOPrijemuMaterijala;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllStavkaZOPM extends AbstractSO{
    
    private ArrayList<StavkaZapisnikaOPrijemuMaterijala> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof StavkaZapisnikaOPrijemuMaterijala)) {
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaZapisnikaOPrijemuMaterijala!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> stavke = DBBroker.getInstance().select(ado);
        lista = (ArrayList<StavkaZapisnikaOPrijemuMaterijala>) (ArrayList<?>) stavke;
    }
    
    public ArrayList<StavkaZapisnikaOPrijemuMaterijala> getLista() {
        return lista;
    }
    
}
