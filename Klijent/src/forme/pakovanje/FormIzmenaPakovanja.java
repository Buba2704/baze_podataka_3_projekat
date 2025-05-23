/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.pakovanje;

import forme.magacin.*;
import controller.ClientController;
import domain.Magacin;
import domain.Namena;
import domain.Pakovanje;
import domain.Radnik;
import forme.trebovanje.FormUnosTrebovanja;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;




public class FormIzmenaPakovanja extends javax.swing.JDialog {

    private Pakovanje p;
    public FormIzmenaPakovanja(JDialog parent, boolean modal, Pakovanje p) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Unos pakovanja");
        this.p = p;
        txtSifra.setText(String.valueOf(p.getSifPakovanja()));
        txtSifra.setEnabled(false);
        txtTip.setText(p.getTip());
        txtTezina.setText(String.valueOf(p.getTezina_t()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSifra = new javax.swing.JFormattedTextField();
        txtTip = new javax.swing.JTextField();
        btnIzmeni = new javax.swing.JButton();
        txtTezina = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Sifra pakovanja:");

        jLabel2.setText("Tip pakovanja:");

        jLabel3.setText("Tezina u tonama:");

        txtTip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipActionPerformed(evt);
            }
        });

        btnIzmeni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIzmeni.setText("Izmeni pakovanje");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        txtTezina.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.000"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSifra, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(txtTip)
                            .addComponent(txtTezina)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTezina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnIzmeni)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        try {
            if(txtTip.getText().isEmpty() || txtTezina.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Morate popuniti sva polja!");
                return;
            }
            
            p.setTip(txtTip.getText());
            p.setTezina_t(Float.parseFloat(txtTezina.getText()));
            ClientController.getInstance().updatePakovanje(p);
            JOptionPane.showMessageDialog(this, "Uspesno izmenjeno pakovanje.");
            FormListaPakovanja lp = (FormListaPakovanja) getParent();
            lp.refreshTable();
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormIzmenaPakovanja.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_btnIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JFormattedTextField txtSifra;
    private javax.swing.JFormattedTextField txtTezina;
    private javax.swing.JTextField txtTip;
    // End of variables declaration//GEN-END:variables
    
    
   

}
