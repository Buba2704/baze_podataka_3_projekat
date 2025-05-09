/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.ZapisnikGRP1;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllZapisnikGR1 extends AbstractSO{
    private ArrayList<ZapisnikGRP1> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof ZapisnikGRP1)) {
            throw new Exception("Prosledjeni objekat nije instanca klase ZapisnikGRP1!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> zapisnici = DBBroker.getInstance().select2(ado);
        lista = (ArrayList<ZapisnikGRP1>) (ArrayList<?>) zapisnici;
    }
    
    public ArrayList<ZapisnikGRP1> getLista() {
        return lista;
    }
}
