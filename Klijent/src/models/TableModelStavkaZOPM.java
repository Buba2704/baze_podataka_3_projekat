/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.StavkaZapisnikaOPrijemuMaterijala;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zoran
 */ 
public class TableModelStavkaZOPM  extends AbstractTableModel{

    private ArrayList<StavkaZapisnikaOPrijemuMaterijala> lista;
    private String[] kolone = {"SifZOPM", "Redni broj", "Proizvod", "Kolicina", "Jedinica mere"};
    private String parametar = "";

    public TableModelStavkaZOPM() {
        try {
            lista = ClientController.getInstance().getAllStavkaZOPM();
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkaZOPM.class.getName()).log(Level.SEVERE, null, ex);
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
        StavkaZapisnikaOPrijemuMaterijala s = lista.get(row);
            switch(column){
                case 0:
                    return s.getZapisnik().getSifZOPM();
                case 1:
                    return s.getRedniBroj();
                case 2:
                    return s.getProizvod();
                case 3:
                    return s.getKolicina();
                case 4:
                    return s.getJedinicaMere();
                default:
                    return null;
            }
    }
    
    public StavkaZapisnikaOPrijemuMaterijala getSelectedstavka(int row){
        return lista.get(row);
    }
    
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                refreshTable();
            } catch (InterruptedException ex) {
                Logger.getLogger(TableModelStavkaZOPM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setParametar(String parametar){
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllStavkaZOPM();
            if(!parametar.equals("")){
                ArrayList<StavkaZapisnikaOPrijemuMaterijala> novaLista = new ArrayList<>();
                for(StavkaZapisnikaOPrijemuMaterijala s: lista){
                    if(String.valueOf(s.getZapisnik().getSifZOPM()).toLowerCase().contains(parametar.toLowerCase())){
                        novaLista.add(s);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkaZOPM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
