//package Frame1;
//import java.awt.Color;
//
//
//public class Frame1 extends javax.swing.JFrame {
//
//    public Frame1() {
//        initComponents();
//        setLocationRelativeTo(null);
//
//    }
//
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        jColorChooser1 = new javax.swing.JColorChooser();
//        InputUser = new javax.swing.JTextField();
//        Bfind = new javax.swing.JButton();
//        Table = new javax.swing.JScrollPane();
//        List = new javax.swing.JList<>();
//        Ltitle = new javax.swing.JLabel();
//        Lfond = new javax.swing.JLabel();
//        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
//        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setSize(new java.awt.Dimension(200, 200));
//        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//
//        InputUser.setText("Ingresar Sintomas y Signos del paciente");
//        InputUser.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                InputUserActionPerformed(evt);
//            }
//        });
//        getContentPane().add(InputUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 210, -1));
//
//        Bfind.setText("Enfermedades asociadas");
//        Bfind.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                BfindActionPerformed(evt);
//            }
//        });
//        getContentPane().add(Bfind, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 158, 182, -1));
//
//        List.setModel(new javax.swing.AbstractListModel<String>() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
//        Table.setViewportView(List);
//
//        getContentPane().add(Table, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 260, 154));
//
//        Ltitle.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
//        Ltitle.setText("Diagnóstico Diferencial");
//        getContentPane().add(Ltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 230, 60));
//
//        Lfond.setIcon(new javax.swing.ImageIcon("C:\\Users\\aldo\\Downloads\\fondo-azul,-lineas-206492 (1).jpg")); // NOI18N
//        Lfond.setText("jLabel1");
//        Lfond.setMaximumSize(new java.awt.Dimension(200, 200));
//        Lfond.setMinimumSize(new java.awt.Dimension(200, 200));
//        Lfond.setPreferredSize(new java.awt.Dimension(200, 200));
//        getContentPane().add(Lfond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 440));
//        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 350, 130));
//        getContentPane().add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));
//
//        pack();
//    }// </editor-fold>//GEN-END:initComponents
//
//    private void BfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BfindActionPerformed
//        if(!InputUser.getText().trim().equals("")){
//            String input = InputUser.getText();
//            InputUser.setText("");
//        }else{
//            InputUser.setBackground(Color.red);
//        }
//
//
//
//
//    }//GEN-LAST:event_BfindActionPerformed
//
//    private void InputUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputUserActionPerformed
//
//    }//GEN-LAST:event_InputUserActionPerformed
//
//
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Frame1().setVisible(true);
//            }
//        });
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JButton Bfind;
//    private javax.swing.JTextField InputUser;
//    private javax.swing.JLabel Lfond;
//    private javax.swing.JList<String> List;
//    private javax.swing.JLabel Ltitle;
//    private javax.swing.JScrollPane Table;
//    private javax.swing.Box.Filler filler1;
//    private javax.swing.Box.Filler filler2;
//    private javax.swing.JColorChooser jColorChooser1;
//    // End of variables declaration//GEN-END:variables
//}
