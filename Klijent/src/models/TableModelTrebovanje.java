/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Trebovanje;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zoran
 */
public class TableModelTrebovanje extends AbstractTableModel {

    private ArrayList<Trebovanje> lista;
    private String[] kolone = {"Sifra trebovanja", "Evidencioni broj", "Datum", "Nosilac troska", "Mesto troska", "Izradio", "Odobrio", "Magacin"};
    private String parametar = "";
    
    public TableModelTrebovanje() {
        try {
            lista = ClientController.getInstance().getAllTrebovanje();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTrebovanje.class.getName()).log(Level.SEVERE, null, ex);
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
        Trebovanje t = lista.get(row);
            switch(column){
                case 0:
                    return t.getSifTrebovanja();
                case 1:
                    return t.getEvidencioniBroj();
                case 2:
                    return t.getFormatDate();
                case 3:
                    return t.getOrgJedNosilacTroska();
                case 4:
                    return t.getOrgJedMestoTroska();
                case 5:
                    return t.getRadnikIzradio();
                case 6:
                    return t.getRadnikOdobrio();
                case 7:
                    return t.getMagacin();
                default:
                    return null;
            }
    }
    
     public Trebovanje getSelectedTrebovanje(int row){
        return lista.get(row);
    }
     
    public void setParametar(String parametar){
        this.parametar = parametar;
        refreshTable();
    }

    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                refreshTable();
            } catch (InterruptedException ex) {
                Logger.getLogger(TableModelTrebovanje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllTrebovanje();
            if(!parametar.equals("")){
                ArrayList<Trebovanje> novaLista = new ArrayList<>();
                for(Trebovanje t: lista){
                    if(String.valueOf(t.getMagacin()).toLowerCase().contains(parametar.toLowerCase())){
                        novaLista.add(t);
                    }
                }
                lista = novaLista;
            }
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTrebovanje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
