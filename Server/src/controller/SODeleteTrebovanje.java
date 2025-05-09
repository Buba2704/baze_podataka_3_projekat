/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Trebovanje;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
public class SODeleteTrebovanje extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Trebovanje)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trebovanje!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

    
}
