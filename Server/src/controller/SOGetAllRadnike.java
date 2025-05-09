/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Radnik;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllRadnike extends AbstractSO{

    private ArrayList<Radnik> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Radnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Radnik!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> radnici = DBBroker.getInstance().select1(ado);
        lista = (ArrayList<Radnik>) (ArrayList<?>) radnici;
    }
    
    public ArrayList<Radnik> getLista() {
        return lista;
    }
}
