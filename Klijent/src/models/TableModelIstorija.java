/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.IstorijaStanjaZaliha;
import domain.Proizvod;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zoran
 */
public class TableModelIstorija extends AbstractTableModel{
    private ArrayList<IstorijaStanjaZaliha> lista;
    private String[] kolone = {"Proizvod", "Datum", "Naziv proizvoda", "Kolicina na stanju", "Jedinica mere", "Magacin"};
    
    private String parametar = "";

    public TableModelIstorija() {
        try {
            lista = ClientController.getInstance().getAllIstorija();
        } catch (Exception ex) {
            Logger.getLogger(TableModelIstorija.class.getName()).log(Level.SEVERE, null, ex);
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
            IstorijaStanjaZaliha i = lista.get(row);
            switch(column){
                case 0:
                    return i.getProizvod().getSifProizvoda();
                case 1:
                    return i.getFormatDate();
                case 2:
                    return i.getNazivProizvoda();
                case 3:
                    return i.getKolicinaNaStanju();
                case 4:
                    return i.getProizvod().getJM();
                case 5:
                    return i.getMagacin();
                default:
                    return null;
            }
    }
    
     public IstorijaStanjaZaliha getSelectedIstorija(int row){
        return lista.get(row);
    }

    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                refreshTable();
            } catch (InterruptedException ex) {
                Logger.getLogger(TableModelIstorija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setParametar(String parametar){
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllIstorija();
            if(!parametar.equals("")){
                ArrayList<IstorijaStanjaZaliha> novaLista = new ArrayList<>();
                for(IstorijaStanjaZaliha i: lista){
                    if(i.getNazivProizvoda().toLowerCase().contains(parametar.toLowerCase())){
                        novaLista.add(i);
                    }
                }
                lista = novaLista;
            }
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelIstorija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
