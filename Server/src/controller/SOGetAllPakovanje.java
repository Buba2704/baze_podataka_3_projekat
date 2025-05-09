/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pakovanje;
import domain.Radnik;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllPakovanje extends AbstractSO{

    private ArrayList<Pakovanje> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pakovanje)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Pakovanje!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> pakovanja = DBBroker.getInstance().select1(ado);
        lista = (ArrayList<Pakovanje>) (ArrayList<?>) pakovanja;
    }
    
    public ArrayList<Pakovanje> getLista() {
        return lista;
    }
}
