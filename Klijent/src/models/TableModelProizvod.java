/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import controller.ClientController;
import domain.Proizvod;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zoran
 */
public class TableModelProizvod extends AbstractTableModel implements Runnable{
    
    private ArrayList<Proizvod> lista;
    private String[] kolone = {"SifProizvoda", "NazivProizvoda", "DodatniNaziv", "Oznaka", "Jedinica mere", "DostupnaKolicina"};
    private String parametar = "";

    public TableModelProizvod() {
        try {
            lista = ClientController.getInstance().getAllProizvod();
        } catch (Exception ex) {
            Logger.getLogger(TableModelProizvod.class.getName()).log(Level.SEVERE, null, ex);
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
        Proizvod p = lista.get(row);
        switch(column){
            case 0:
                return p.getSifProizvoda();
            case 1:
                return p.getNazivProizvoda();
            case 2:
                return p.getDodatniNaziv();
            case 3:
                return p.getOznaka();
            case 4:
                return p.getJM();
            case 5:
                return p.getDostupnaKolicina();
            default:
                return null;
        }
    }
    
    public Proizvod getSelectedProizvod(int row){
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
    
    public void setParametar(String parametar){
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllProizvod();
        if(!parametar.equals("")){
            ArrayList<Proizvod> novaLista = new ArrayList<>();
            for(Proizvod p: lista){
                if(p.getNazivProizvoda().toLowerCase().contains(parametar.toLowerCase())){
                    novaLista.add(p);
                }
            
            }
            lista = novaLista;
        }
        fireTableDataChanged();
    } catch (Exception ex) {
            Logger.getLogger(TableModelProizvod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
