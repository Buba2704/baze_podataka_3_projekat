/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Trebovanje;
import java.util.ArrayList;
import so.AbstractSO;


class SOGetAllTrebovanje extends AbstractSO{

    private ArrayList<Trebovanje> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Trebovanje)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trebovanje!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> trebovanja = DBBroker.getInstance().select1(ado);
        lista = (ArrayList<Trebovanje>) (ArrayList<?>) trebovanja;
    }
    
    public ArrayList<Trebovanje> getLista() {
        return lista;
    }
    
}
