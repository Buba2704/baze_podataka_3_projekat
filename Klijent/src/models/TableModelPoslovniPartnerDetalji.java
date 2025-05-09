/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.PoslovniPartnerDetalji;
import domain.PoslovniPartnerView;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zoran
 */
public class TableModelPoslovniPartnerDetalji extends AbstractTableModel implements Runnable {

    private ArrayList<PoslovniPartnerDetalji> lista;
    private String[] kolone = {"Sifra partnera", "Maticni broj", "PIB", "Tekuci racun", "Adresa", "Mesto"};
    private String parametar = "";
    
    
    public TableModelPoslovniPartnerDetalji() {
        try {
            lista = ClientController.getInstance().getAllPoslovniPartnerDetalji();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPoslovniPartnerView.class.getName()).log(Level.SEVERE, null, ex);
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
        PoslovniPartnerDetalji p = lista.get(row);
        switch(column){
            case 0:
                return p.getSifPartnera();
            case 1:
                return p.getMaticniBroj();
            case 2:
                return p.getPIB();
            case 3:
                return p.getTekuciRacun();
            case 4:
                return p.getAdresa();
            case 5:
                return p.getMesto();
            default:
                return null;
        }
    }
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                refreshTable();
            } catch (InterruptedException ex) {
                Logger.getLogger(TableModelPoslovniPartnerDetalji.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllPoslovniPartnerDetalji();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPoslovniPartnerDetalji.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
