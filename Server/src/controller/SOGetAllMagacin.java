/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Magacin;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllMagacin extends AbstractSO  {
    private ArrayList<Magacin> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Magacin)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Magacin!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> magacini = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Magacin>) (ArrayList<?>) magacini;
    }
    
    public ArrayList<Magacin> getLista() {
        return lista;
    }
    
}
