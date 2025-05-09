/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Pakovanje;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zoran
 */
public class TableModelPakovanje extends AbstractTableModel implements Runnable {
    
    private ArrayList<Pakovanje> lista;
    private String[] kolone = {"Sifra pakovanja", "Tip", "Tezina u tonama", "Tazina u kilogramima"};
    private String parametar = "";

    public TableModelPakovanje() {
        try {
            lista = ClientController.getInstance().getAllPakovanje();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPakovanje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
    public String getColumnName(int i){
        return kolone[i];
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        Pakovanje p = lista.get(row);
        switch(column){
            case 0:
                return p.getSifPakovanja();
            case 1:
                return p.getTip();
            case 2:
                return p.getTezina_t();
            case 3:
                return p.getTezina_kg();
            default:
                return null;
        }
    }
    
    public Pakovanje getSelectedPakovanje(int row){
     return lista.get(row);
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                refreshTable();
            } catch (InterruptedException ex) {
                Logger.getLogger(TableModelPakovanje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllPakovanje();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPakovanje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
