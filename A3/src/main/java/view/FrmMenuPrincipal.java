
package view;


public class FrmMenuPrincipal extends javax.swing.JFrame {

    public FrmMenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemNovaFerramenta = new javax.swing.JMenuItem();
        jMenuItemGerenciarFerramentas = new javax.swing.JMenuItem();
        jMenuItemNovoAluno = new javax.swing.JMenuItem();
        jMenuItemGerenciarAlunos = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Ferramentas");

        jMenuArquivo.setText("Arquivo");

        jMenuItemNovaFerramenta.setText("Cadastrar Ferramenta");
        jMenuItemNovaFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovaFerramentaActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemNovaFerramenta);

        jMenuItemGerenciarFerramentas.setText("Gerenciar ferramentas");
        jMenuItemGerenciarFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarFerramentasActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemGerenciarFerramentas);

        jMenuItemNovoAluno.setText("Cadastrar Amigo");
        jMenuItemNovoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovoAlunoActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemNovoAluno);

        jMenuItemGerenciarAlunos.setText("Gerenciar Amigo");
        jMenuItemGerenciarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarAlunosActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemGerenciarAlunos);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemSair);

        jMenuBar1.add(jMenuArquivo);

        jMenu2.setText("Sobre");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemNovaFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovaFerramentaActionPerformed
        //instancia a tela de cadastro de ferramentas
        FrmCadastroFerramenta objeto = new FrmCadastroFerramenta();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemNovaFerramentaActionPerformed

    private void jMenuItemGerenciarFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciarFerramentasActionPerformed
        FrmGerenciarFerramenta objeto = new FrmGerenciarFerramenta();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemGerenciarFerramentasActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemNovoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovoAlunoActionPerformed
        FrmCadastroAmigo objeto = new FrmCadastroAmigo();
        objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemNovoAlunoActionPerformed

    private void jMenuItemGerenciarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciarAlunosActionPerformed
       FrmGerenciarAmigo objeto = new FrmGerenciarAmigo();
       objeto.setVisible(true);
    }//GEN-LAST:event_jMenuItemGerenciarAlunosActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemGerenciarAlunos;
    private javax.swing.JMenuItem jMenuItemGerenciarFerramentas;
    private javax.swing.JMenuItem jMenuItemNovaFerramenta;
    private javax.swing.JMenuItem jMenuItemNovoAluno;
    private javax.swing.JMenuItem jMenuItemSair;
    // End of variables declaration//GEN-END:variables
}
