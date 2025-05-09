/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.PoslovniPartnerView;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllPartnerView extends AbstractSO{

    private ArrayList<PoslovniPartnerView> lista;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof PoslovniPartnerView)) {
            throw new Exception("Prosledjeni objekat nije instanca pogleda PoslovniPartner_View!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> partneri = DBBroker.getInstance().select(ado);
        lista = (ArrayList<PoslovniPartnerView>) (ArrayList<?>) partneri;
    }
    
    public ArrayList<PoslovniPartnerView> getLista() {
        return lista;
    }
    
}
