/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Magacin;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zoran
 */
public class TableModelMagacin extends AbstractTableModel implements Runnable {
    private ArrayList<Magacin> lista;
    private String[] kolone = {"Sifra magacina", "Naziv magacina", "Racunopolagac", "Namena", "Poslednji datum trebovanja"};
    private String parametar = "";

    public TableModelMagacin() {
        try {
            lista = ClientController.getInstance().getAllMagacin();
        } catch (Exception ex) {
            Logger.getLogger(TableModelMagacin.class.getName()).log(Level.SEVERE, null, ex);
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
        Magacin m = lista.get(row);
        switch(column){
            case 0:
                return m.getSifMagacina();
            case 1:
                return m.getNazivMagacina();
            case 2:
                return m.getRadnik().getSifRadnika();
            case 3:
                return m.getNamena();
            case 4:
                return m.getFormatDate();
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
                Logger.getLogger(TableModelProizvod.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Magacin getSelectedMagacin(int row){
     return lista.get(row);
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllMagacin();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelMagacin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
