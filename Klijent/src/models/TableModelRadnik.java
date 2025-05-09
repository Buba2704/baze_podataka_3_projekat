/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Radnik;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zoran
 */
public class TableModelRadnik extends AbstractTableModel implements Runnable{

    private ArrayList<Radnik> lista;
    private String[] kolone = {"Sifra radnika", "Ime", "Prezime", "JMBG", "Pol", "Telefon", "Adresa"};
    private String parametar = "";
    
    
    public TableModelRadnik() {
        try {
            lista = ClientController.getInstance().getAllRadnik();
        } catch (Exception ex) {
            Logger.getLogger(TableModelRadnik.class.getName()).log(Level.SEVERE, null, ex);
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
        Radnik r = lista.get(row);
        switch(column){
            case 0:
                return r.getSifRadnika();
            case 1:
                return r.getIme();
            case 2:
                return r.getPrezime();
            case 3:
                return r.getJMBG();
            case 4:
                return r.getPOL();
            case 5:
                return r.getTelefon();
            case 6:
                return r.getAdresa();
            default:
                return null;
        }
    }
    
    public Radnik getSelectedRadnik(int row){
     return lista.get(row);
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

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllRadnik();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelRadnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
