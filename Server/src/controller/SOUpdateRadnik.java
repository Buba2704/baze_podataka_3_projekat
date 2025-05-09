/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Radnik;
import javafx.scene.paint.RadialGradient;
import so.AbstractSO;

/**
 *
 * @author zoran
 */
public class SOUpdateRadnik extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Radnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Radnik!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }

    
}
