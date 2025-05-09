/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.ZapisnikGRP2;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllZapisnikGR2 extends AbstractSO{
    private ArrayList<ZapisnikGRP2> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof ZapisnikGRP2)) {
            throw new Exception("Prosledjeni objekat nije instanca klase ZapisnikGRP2!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> zapisnici = DBBroker.getInstance().select2(ado);
        lista = (ArrayList<ZapisnikGRP2>) (ArrayList<?>) zapisnici;
    }
    
    public ArrayList<ZapisnikGRP2> getLista() {
        return lista;
    }
}
