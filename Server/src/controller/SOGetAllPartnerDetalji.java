/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.PoslovniPartnerDetalji;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllPartnerDetalji extends AbstractSO{

    private ArrayList<PoslovniPartnerDetalji> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof PoslovniPartnerDetalji)) {
            throw new Exception("Prosledjeni objekat nije instanca tabele poslovniPartnerDetalji!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> partneri = DBBroker.getInstance().select(ado);
        lista = (ArrayList<PoslovniPartnerDetalji>) (ArrayList<?>) partneri;
    }
    
    public ArrayList<PoslovniPartnerDetalji> getLista() {
        return lista;
    }
    
}
