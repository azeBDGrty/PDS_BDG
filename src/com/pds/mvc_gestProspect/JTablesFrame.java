/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.pds.mvc_gestProspect;

import com.pds.entities.CalculPret;
import com.pds.entities.MathHepler;
import com.pds.entities.SimulationPret;
import com.pds.entities.Taux_directeur;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nodaro
 */
public class JTablesFrame extends javax.swing.JFrame {
    
   private List<View_SimTauxVari.infoMensualite> bestRate;
    
    public JTablesFrame(List<View_SimTauxVari.infoMensualite> bestRate, List<View_SimTauxVari.infoMensualite> badRate, List<View_SimTauxVari.infoMensualite> stabRate, double indice, int duree, double tauxInit, double montant, double capet){
        initComponents();
        this.bestRate = new ArrayList<>();
        
        afficherInformation(bestRate, badRate, stabRate, indice, duree, tauxInit, montant, capet);
    }
    
    
    public void afficherInformation(List<View_SimTauxVari.infoMensualite> bestRate, List<View_SimTauxVari.infoMensualite> badRate, List<View_SimTauxVari.infoMensualite> stabRate, double indice, int duree, double tauxInit, double montant, double capet){
        
        double montantTotal = -1;
        String recap = "";
        
        //Best Rate 
         montantTotal = bestRate.get(bestRate.size()-1).montantRestant;
         recap = jlRecapBaisse.getText();
        recap = recap.replace("V", MathHepler.ajustVirgule(montant, 2)+"€");
        recap = recap.replace("W", MathHepler.ajustVirgule(tauxInit, 2)+" %");
        recap = recap.replace("X", MathHepler.ajustVirgule(indice, 2)+" %");
        recap = recap.replace("Y", MathHepler.ajustVirgule(capet, 2)+" %");
        recap = recap.replace("Z", MathHepler.ajustVirgule(bestRate.get(bestRate.size()-1).montantRestant, 2)+" €");
        jlRecapBaisse.setText(recap);
        
        
        String col[] = {"Année", "Taux capé", "Indice", "Taux (%)", "Mensualité", "Montant restant", "Interet"};
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.setRowCount(0);
        dtm.setColumnIdentifiers(col);
        
        for(View_SimTauxVari.infoMensualite info : bestRate){
            montantTotal -= info.mensualite;
            info.montantRestant = montantTotal;
            dtm.addRow(new Object[]{info.annee, MathHepler.ajustVirgule(capet, 2)+" %", info.indice, MathHepler.ajustVirgule(info.taux, 2)+" %", MathHepler.ajustVirgule(info.mensualite/12, 2)+" €", MathHepler.ajustVirgule(info.montantRestant, 2)+" €", MathHepler.ajustVirgule(info.interet, 2)+" €"});
        }
        
        
        
        // Bad Rate
        montantTotal = badRate.get(badRate.size()-1).montantRestant;
        
        
        String colBadRate[] = {"Année", "Taux capé", "Indice", "Taux (%)", "Mensualité", "Montant restant", "Interet"};
        DefaultTableModel dtmBadRate = (DefaultTableModel) jTable1.getModel();
        dtmBadRate.setRowCount(0);
        dtmBadRate.setColumnIdentifiers(colBadRate);
        
        for(View_SimTauxVari.infoMensualite info : badRate){
            montantTotal -= info.mensualite;
            info.montantRestant = montantTotal;
            dtmBadRate.addRow(new Object[]{info.annee, MathHepler.ajustVirgule(capet, 2)+" %", info.indice, MathHepler.ajustVirgule(info.taux, 2)+" %", MathHepler.ajustVirgule(info.mensualite/12, 2)+" €", MathHepler.ajustVirgule(info.montantRestant, 2)+" €", MathHepler.ajustVirgule(info.interet, 2)+" €"});
        }
    

        // stab Rate
        montantTotal = stabRate.get(stabRate.size()-1).montantRestant;
        
        
        String colStabRate[] = {"Année", "Taux capé", "Indice", "Taux (%)", "Mensualité", "Montant restant", "Interet"};
        DefaultTableModel dtmStabRate = (DefaultTableModel) jTable3.getModel();
        dtmStabRate.setRowCount(0);
        dtmStabRate.setColumnIdentifiers(colStabRate);
        
        
        for(View_SimTauxVari.infoMensualite info : stabRate){
            montantTotal -= info.mensualite;
            info.montantRestant = montantTotal;
            dtmStabRate.addRow(new Object[]{info.annee, MathHepler.ajustVirgule(capet, 2)+" %", info.indice, MathHepler.ajustVirgule(info.taux, 2)+" %", MathHepler.ajustVirgule(info.mensualite/12, 2)+" €", MathHepler.ajustVirgule(info.montantRestant, 2)+" €", MathHepler.ajustVirgule(info.interet, 2)+" €"});
        }
    }
    
   public JTablesFrame(double indice, int duree, double tauxInit, double montant, double capet) {
        SimulationPret sp=new SimulationPret();
        sp.setMtPret(montant);
        Taux_directeur td=new Taux_directeur();
        td.setValue(tauxInit);
        CalculPret cp=new CalculPret();
        cp.setT_marge(0d);
        sp.setCalcPret(cp);
        sp.setDureePret(duree);
        cp.setTauxDirecteur(td);
        initComponents();
        
        // Rate increase 
    
        
        
        
        
        
        //Rate down
        
        
        {
            String col[] = {"Année", "nombre de mois", "Indice", "Taux", "Mensualité", "Montant restant"};
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            dtm.setRowCount(0);
            dtm.setColumnIdentifiers(col);

            double tauxTmp = tauxInit;
            double remaining=montant;

            double montantTotal = 0;
            List<infoMensualite> listeTable = new LinkedList<>();

            for (int j=0;j<duree;j++){      //Display values in cells 

                //montantTotal +=  sp.calcMensualiteTauxVariable(tauxTmp,remaining);
                sp.getCalcPret().getTauxDirecteur().setValue(tauxTmp);
                montantTotal +=  sp.getMensualite();
                listeTable.add(new infoMensualite(j+1, indice, tauxTmp, sp.getMensualite(), 0));          
                //dtm.addRow(data);

                if( (tauxTmp - indice) >  2)
                    tauxTmp -= indice;
                else
                    tauxTmp = 2;
            }


            for(infoMensualite info : listeTable){
                montantTotal -= info.mensualite;
                info.montantRestant = montantTotal;
                dtm.addRow(new Object[]{info.annee, 12, info.indice, MathHepler.ajustVirgule(info.taux, 2)+" %", MathHepler.ajustVirgule(info.mensualite/12, 2)+" €", MathHepler.ajustVirgule(info.montantRestant, 2)+" €"});
            }
        }
        
        
        
        // stable rate
        
        {
            String col[] = {"Année", "nombre de mois", "Indice", "Taux", "Mensualité", "Montant restant"};
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            dtm.setRowCount(0);
            dtm.setColumnIdentifiers(col);

            double tauxTmp = tauxInit;
            double remaining=montant;

            double montantTotal = 0;
            List<infoMensualite> listeTable = new LinkedList<>();

            for (int j=0;j<duree;j++){      //Display values in cells 

                //montantTotal +=  sp.calcMensualiteTauxVariable(tauxTmp,remaining);
                sp.getCalcPret().getTauxDirecteur().setValue(tauxTmp);
                montantTotal +=  sp.getMensualite();
                listeTable.add(new infoMensualite(j+1, indice, tauxTmp, sp.getMensualite(), 0));          
                //dtm.addRow(data);

            }


            for(infoMensualite info : listeTable){
                montantTotal -= info.mensualite;
                info.montantRestant = montantTotal;
                dtm.addRow(new Object[]{info.annee, 12, info.indice, MathHepler.ajustVirgule(info.taux, 2)+" %", MathHepler.ajustVirgule(info.mensualite/12, 2)+" €", MathHepler.ajustVirgule(info.montantRestant, 2)+" €"});
            }
        }
        
        this.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlRecapBaisse = new javax.swing.JLabel();
        jlRecapHausse = new javax.swing.JLabel();
        jlRecapStab = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Année", "Indice", "Taux", "Mensualité", "Montant Restant"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Année", "Indice", "Taux", "Mensualité", "Montant Restant"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Année", "Indice", "Taux", "Mensualité", "Montant Restant"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Baisse du taux:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setText("Augmentation du taux: ");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel3.setText("Stabilité du taux:");

        jLabel4.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Le tableau d'amortissement");

        jlRecapBaisse.setText("Pour un montant de V , avec un taux initial de W , un indice de X , et un taux capé de Y , ce crédit vous coûtera Z .");

        jlRecapHausse.setText("Pour un montant de V , avec un taux initial de W , un indice de X , et un taux capé de Y , ce crédit vous coûtera Z .");

        jlRecapStab.setText("Pour un montant de V , avec un taux initial de W , un indice de X , et un taux capé de Y , ce crédit vous coûtera Z .");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlRecapBaisse, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlRecapHausse, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlRecapStab, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jlRecapBaisse, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlRecapHausse)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlRecapStab)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JTablesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JTablesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JTablesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JTablesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        
    }
    
    
    
    public class infoMensualite{
        int annee;
        double indice, taux, mensualite, montantRestant;

        public infoMensualite(int annee, double indice, double taux, double mensualite, double montantRestant) {
            this.annee = annee;
            this.indice = indice;
            this.taux = taux;
            this.mensualite = mensualite;
            this.montantRestant = montantRestant;
        }
        
        
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel jlRecapBaisse;
    private javax.swing.JLabel jlRecapHausse;
    private javax.swing.JLabel jlRecapStab;
    // End of variables declaration//GEN-END:variables
}
