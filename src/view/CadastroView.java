/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.usuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pessoa.Aluno;
import pessoa.Pessoa;
import pessoa.Professor;

/**
 *
 * @author adowt
 */
public class CadastroView extends javax.swing.JDialog {

    /**
     * Creates new form CadastroView
     */
    public CadastroView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupTipo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jNovoLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jRegistrar = new javax.swing.JButton();
        jNovaSenha = new javax.swing.JPasswordField();
        jAlunoRadio = new javax.swing.JRadioButton();
        jProfessorRadio = new javax.swing.JRadioButton();
        jAtendenteRadio = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jNovoNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Novo Login:");

        jNovoLogin.setToolTipText("");

        jLabel2.setText("Nova Senha:");

        jRegistrar.setText("Registrar");
        jRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegistrarActionPerformed(evt);
            }
        });

        groupTipo.add(jAlunoRadio);
        jAlunoRadio.setText("Aluno");
        jAlunoRadio.setToolTipText("");

        groupTipo.add(jProfessorRadio);
        jProfessorRadio.setText("Professor");

        groupTipo.add(jAtendenteRadio);
        jAtendenteRadio.setText("Atendente");
        jAtendenteRadio.setToolTipText("");

        jLabel3.setText("Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRegistrar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jAlunoRadio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jProfessorRadio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jAtendenteRadio))
                        .addComponent(jNovoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jNovaSenha)
                        .addComponent(jNovoNome)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNovoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNovoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAlunoRadio)
                    .addComponent(jProfessorRadio)
                    .addComponent(jAtendenteRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jRegistrar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegistrarActionPerformed
       try {
            usuarioDAO usuConnec = new usuarioDAO(); //Cria uma nova conexão baseada no DAO
            if (!jNovoNome.getText().equals("") || !jNovoLogin.getText().equals("") || !jNovaSenha.getText().equals("") ) {
                if (jAlunoRadio.isSelected()){
                    Aluno novoAluno = new Aluno(jNovoLogin.getText(), jNovaSenha.getText(), jNovoNome.getText(), "Aluno");
                    usuConnec.inserir(novoAluno); //Se aluno estiver selecionado
                    JOptionPane.showMessageDialog(this, "Cadastro feito com sucesso!");
                    this.dispose();
                } else if (jProfessorRadio.isSelected()) {
                    Professor novoProf = new Professor(jNovoLogin.getText(), jNovaSenha.getText(), jNovoNome.getText(), "Professor");
                    usuConnec.inserir(novoProf);//Se professor estiver selecionado
                    JOptionPane.showMessageDialog(this, "Cadastro feito com sucesso!");
                    this.dispose();
                } else if (jAtendenteRadio.isSelected()) {
                    Pessoa novaPess = new Pessoa(jNovoLogin.getText(), jNovaSenha.getText(), jNovoNome.getText(), "Atendente");
                    usuConnec.inserir(novaPess);//Se Atendente estiver selecionado
                    JOptionPane.showMessageDialog(this, "Cadastro feito com sucesso!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Selecione um tipo de pessoa!"); 
                }
            } else {
                JOptionPane.showMessageDialog(this, "Todos os campos precisam ser preenchidos!");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Faltou Driver!"); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco! \n"+ex.getMessage());
        }    
    }//GEN-LAST:event_jRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroView dialog = new CadastroView(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup groupTipo;
    private javax.swing.JRadioButton jAlunoRadio;
    private javax.swing.JRadioButton jAtendenteRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jNovaSenha;
    private javax.swing.JTextField jNovoLogin;
    private javax.swing.JTextField jNovoNome;
    private javax.swing.JRadioButton jProfessorRadio;
    private javax.swing.JButton jRegistrar;
    // End of variables declaration//GEN-END:variables
}
