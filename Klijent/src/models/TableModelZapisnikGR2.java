/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.ZapisnikGRP1;
import domain.ZapisnikGRP2;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zoran
 */
public class TableModelZapisnikGR2 extends AbstractTableModel implements Runnable {
    
    private ArrayList<ZapisnikGRP2> lista;
    private String[] kolone = {"Sifra zapisnika", "Evidencioni broj", "Datum", "Oznaka", "Organizaciona jed.", "Radnik", "Magacin"};
    private String parametar = "";

    public TableModelZapisnikGR2() {
        try {
            lista = ClientController.getInstance().getAllZapisnikGR2();
        } catch (Exception ex) {
            Logger.getLogger(TableModelZapisnikGR2.class.getName()).log(Level.SEVERE, null, ex);
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
        ZapisnikGRP2 z = lista.get(row);
        switch(column){
            case 0:
                return z.getSifZGR();
            case 1:
                return z.getEvidencioniBroj();
            case 2:
                return z.getFormatDate();
            case 3:
                return z.getOznaka();
            case 4:
                return z.getOrgJed();
            case 5:
                return z.getRadnik();
            case 6:
                return z.getMagacin();
            default:
                return null;
        }
    }
    
    public ZapisnikGRP2 getSelectedZapisnik(int row){
     return lista.get(row);
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                refreshTable();
            } catch (InterruptedException ex) {
                Logger.getLogger(TableModelZapisnikGR2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllZapisnikGR2();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelZapisnikGR2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
