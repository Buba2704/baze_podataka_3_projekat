/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.JedinicaMere;
import so.AbstractSO;
import java.util.ArrayList;

/**
 *
 * @author zoran
 */
public class SOGetAllJM extends AbstractSO {
    
   private ArrayList<JedinicaMere> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof JedinicaMere)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Jedinica mere!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> jedinice = DBBroker.getInstance().select(ado);
        lista = (ArrayList<JedinicaMere>) (ArrayList<?>) jedinice;
    }
      public ArrayList<JedinicaMere> getLista() {
        return lista;
    }
}
