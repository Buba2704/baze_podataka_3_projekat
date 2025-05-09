/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.IstorijaStanjaZaliha;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
class SOGetAllIstorija extends AbstractSO{
    private ArrayList<IstorijaStanjaZaliha> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof IstorijaStanjaZaliha)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Proizvod!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> istorije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<IstorijaStanjaZaliha>) (ArrayList<?>) istorije;
    }
    
    public ArrayList<IstorijaStanjaZaliha> getLista() {
        return lista;
    }
    
}
