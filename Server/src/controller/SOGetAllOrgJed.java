/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.OrganizacionaJedinica;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllOrgJed extends AbstractSO{

    private ArrayList<OrganizacionaJedinica> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof OrganizacionaJedinica)) {
            throw new Exception("Prosledjeni objekat nije instanca klase OrganizacionaJedinica!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> jedinice = DBBroker.getInstance().select(ado);
        lista = (ArrayList<OrganizacionaJedinica>) (ArrayList<?>) jedinice;
    }
    
    public ArrayList<OrganizacionaJedinica> getLista() {
        return lista;
    }
    
}
