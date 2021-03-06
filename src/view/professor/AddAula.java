/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.professor;

import aula.Aula;
import dao.aulaDAO;
import dao.configDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.Config;
import negocio.Hora;
import pessoa.Professor;

/**
 *
 * @author adowt
 */
public class AddAula extends javax.swing.JDialog {
    private Professor profAtual;
    ArrayList<Aula> listAulas;
    /**
     * Creates new form AddAula
     */
    public AddAula(java.awt.Frame parent, boolean modal, Professor profAtual) {
        super(parent, modal);
        initComponents();
        this.profAtual = profAtual;
        //Aqui eu passo o professor como parâmetro para a tela, assim
        //eu posso usar ele para procurar aulas somente desse professor
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jAulasTab = new javax.swing.JTable();
        jRemoverAula = new javax.swing.JButton();
        jAddAula = new javax.swing.JPanel();
        jTipo = new javax.swing.JComboBox();
        jData = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jHora = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jAddButt = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jMinuto = new javax.swing.JTextField();
        jModiButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Suas aulas");

        jAulasTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo", "Hora Inicio", "Hora Fim", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jAulasTab);

        jRemoverAula.setText("Remover aula");
        jRemoverAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoverAulaActionPerformed(evt);
            }
        });

        jAddAula.setEnabled(false);

        jTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha um tipo", "Prática", "Teórica" }));

        jLabel3.setText("Data:");

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("*dd/mm/aa");

        jHora.setText("hh");

        jLabel6.setText("Hora");

        jAddButt.setText("Adicionar");
        jAddButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddButtActionPerformed(evt);
            }
        });

        jLabel7.setText(":");

        jMinuto.setText("mm");

        jModiButt.setText("Modificar");
        jModiButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModiButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jAddAulaLayout = new javax.swing.GroupLayout(jAddAula);
        jAddAula.setLayout(jAddAulaLayout);
        jAddAulaLayout.setHorizontalGroup(
            jAddAulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddAulaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jAddAulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jAddAulaLayout.createSequentialGroup()
                        .addComponent(jHora, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jAddAulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jData)
                    .addComponent(jLabel3)
                    .addComponent(jAddButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jModiButt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jAddAulaLayout.setVerticalGroup(
            jAddAulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAddAulaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jAddAulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jAddAulaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddButt)
                    .addComponent(jLabel7)
                    .addComponent(jMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jModiButt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jAddAula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                    .addComponent(jRemoverAula))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRemoverAula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jAddAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void refreshTabAula(){
        try {
            aulaDAO daoAula = new aulaDAO();
            
            //Procura as aulas e preenche uma lista com elas
            Aula aulaProc = new Aula(0, "", profAtual, "", "", "", false);
            
            listAulas = daoAula.procurar(aulaProc);
            
            //Pega o model da tabela
            DefaultTableModel tabAulas = (DefaultTableModel) jAulasTab.getModel();
            
            while(tabAulas.getRowCount()!=0){
                tabAulas.removeRow(0);
            }
            
            //Preenche a tabela com esse model
            for(Aula aulaAdd:listAulas) {
                tabAulas.addRow(new Object[]{aulaAdd.getId(), aulaAdd.getTipo(), aulaAdd.getHoraInicio(), aulaAdd.getHoraFim(), aulaAdd.getData()});
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!\n"+ex.getMessage());
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refreshTabAula();
    }//GEN-LAST:event_formWindowOpened

    private void jAddButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddButtActionPerformed
        try {
            Config conf = new configDAO().buscar();
            
            //Cria a hora de inicio
            Hora horaInicio,horaFim;
            String horaInicioAdd, horaFimAdd;
            
            //Se a hora estiver preenchida
            if(!jHora.getText().equals("hh") && !jMinuto.getText().equals("mm")) {
                //Preenche
                horaInicio = new Hora(Integer.parseInt(jHora.getText()), Integer.parseInt(jMinuto.getText()));
                horaInicioAdd = horaInicio.getHora();
                //Copia a hora de inicio e adiciona os minutos correspondentes ao que está configurado
                horaFim = new Hora(Integer.parseInt(jHora.getText()), Integer.parseInt(jMinuto.getText()));;
                horaFim.addMinutos(conf.getMinutosAula());
                horaFimAdd = horaFim.getHora();
            
            
            //Pega o model da comboBox
            DefaultComboBoxModel combModel = (DefaultComboBoxModel) jTipo.getModel();
            
            //Pega o tipo selecionado no model
            String tipo = (String) combModel.getSelectedItem();
            if(tipo == "Prática" || tipo == "Teórica") {
            
            //Cria uma aula com os valores
            Aula aulaAdd = new Aula(0, tipo, profAtual, horaInicioAdd, horaFimAdd, jData.getText(), false);
            
            //Cria o dao da aula para ser usado
            aulaDAO daoAula = new aulaDAO();
            
            //Insere a aula preenchida
            daoAula.inserir(aulaAdd);
            
            refreshTabAula();
            } else {
                JOptionPane.showMessageDialog(this, "Digite uma hora!");
            }
            } else {
                JOptionPane.showMessageDialog(this, "Escolha uma aula!");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!\n"+ex.getMessage());
        }
    }//GEN-LAST:event_jAddButtActionPerformed

    private void jModiButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModiButtActionPerformed
        try {
            Config conf = new configDAO().buscar();
            
            //Cria a hora de inicio
            Hora horaInicio,horaFim;
            String horaInicioAdd, horaFimAdd;
            
            //Se a hora estiver preenchida
            if(!jHora.getText().equals("hh") && !jMinuto.getText().equals("mm")) {
                //Preenche
                horaInicio = new Hora(Integer.parseInt(jHora.getText()), Integer.parseInt(jMinuto.getText()));
                horaInicioAdd = horaInicio.getHora();
                //Copia a hora de inicio e adiciona os minutos correspondentes ao que está configurado
                horaFim = new Hora(Integer.parseInt(jHora.getText()), Integer.parseInt(jMinuto.getText()));;
                horaFim.addMinutos(conf.getMinutosAula());
                horaFimAdd = horaFim.getHora();
            } else {
                //Senão, deixa vazia
                horaInicioAdd = "";
                horaFimAdd = "";
            }
            
            //Pega o model da comboBox
            DefaultComboBoxModel combModel = (DefaultComboBoxModel) jTipo.getModel();
            
             //Pega o tipo selecionado no model
            String tipo = (String) combModel.getSelectedItem();
            if(tipo == "Prática" || tipo == "Teórica") {
                //Pega a tabela
                DefaultTableModel tableAula = (DefaultTableModel) jAulasTab.getModel();

                //pega a linha selecionada
                int linhaSelec = jAulasTab.getSelectedRow();

                //Pega os valores da linha selecionada e coloca eles num objeto aula
                Aula modAula = listAulas.get(linhaSelec);                
                Aula aulaAdd = new Aula(0, tipo, profAtual, horaInicioAdd, horaFimAdd, jData.getText(), false);
                
                //Cria o dao da aula para ser usado
                aulaDAO daoAula = new aulaDAO();

                //Insere a aula preenchida
                daoAula.alterar(aulaAdd, modAula);

                refreshTabAula();
            } else {
                JOptionPane.showMessageDialog(this, "Escolha uma aula!");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!\n"+ex.getMessage());
        }
    }//GEN-LAST:event_jModiButtActionPerformed

    private void jRemoverAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoverAulaActionPerformed
        try {
            //Pega a tabela
            DefaultTableModel tableAula = (DefaultTableModel) jAulasTab.getModel();
            
            //pega a linha selecionada
            int linhaSelec = jAulasTab.getSelectedRow();
            
            //Pega os valores da linha selecionada e coloca eles num objeto aula
            Aula removerAula = listAulas.get(linhaSelec);
            
            //Usa esse objeto para deletar a aula
            aulaDAO daoAula = new aulaDAO();
            daoAula.apagar(removerAula);
            
            refreshTabAula();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!\n"+ex.getMessage());
        }
    }//GEN-LAST:event_jRemoverAulaActionPerformed

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
            java.util.logging.Logger.getLogger(AddAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddAula dialog = new AddAula(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jAddAula;
    private javax.swing.JButton jAddButt;
    private javax.swing.JTable jAulasTab;
    private javax.swing.JTextField jData;
    private javax.swing.JTextField jHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jMinuto;
    private javax.swing.JButton jModiButt;
    private javax.swing.JButton jRemoverAula;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jTipo;
    // End of variables declaration//GEN-END:variables
}
