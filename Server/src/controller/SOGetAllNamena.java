/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Magacin;
import domain.Namena;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllNamena extends AbstractSO{

    private ArrayList<Namena> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Namena)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Namena!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> namene = DBBroker.getInstance().select1(ado);
        lista = (ArrayList<Namena>) (ArrayList<?>) namene;
    }
    
    public ArrayList<Namena> getLista() {
        return lista;
    }
     
}
