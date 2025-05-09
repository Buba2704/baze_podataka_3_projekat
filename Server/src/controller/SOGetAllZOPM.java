/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.ZapisnikOPrijemuMaterijala;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllZOPM extends AbstractSO{
    
    private ArrayList<ZapisnikOPrijemuMaterijala> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof ZapisnikOPrijemuMaterijala)) {
            throw new Exception("Prosledjeni objekat nije instanca klase ZapisnikOPrijemuMaterijala!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> zapisnici = DBBroker.getInstance().select(ado);
        lista = (ArrayList<ZapisnikOPrijemuMaterijala>) (ArrayList<?>) zapisnici;
    }
    
    public ArrayList<ZapisnikOPrijemuMaterijala> getLista() {
        return lista;
    }
    
    
}
