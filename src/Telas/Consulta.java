
package Telas;

import AcessoDB.FilmeDAO;
import AcessoDB.Filmes;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Consulta extends javax.swing.JFrame {

    private void exibir(){
        FilmeDAO filmeDAO = new FilmeDAO();
        List<Filmes> listaFilmes = filmeDAO.consultar();
        DefaultTableModel tabelaFilmes = (DefaultTableModel) tblFilmes.getModel();
        tblFilmes.setRowSorter(new TableRowSorter(tabelaFilmes));
        for(Filmes f : listaFilmes){
            Object[] obj = new Object[]{
                f.getId(),
                f.getNome(),
                f.getDatalancamento(),
                f.getCategoria()
            };
            tabelaFilmes.addRow(obj);
        }
    }
    public Consulta() {
        initComponents();
        exibir();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lllll = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txxx = new javax.swing.JScrollPane();
        tblFilmes = new javax.swing.JTable();
        ButtonRemover = new javax.swing.JButton();
        ButtonRemover2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de filmes");

        lllll.setBackground(new java.awt.Color(255, 102, 102));
        lllll.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Relatório de Filmes");

        txxx.setBackground(new java.awt.Color(255, 255, 51));
        txxx.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data Lançamento", "Categoria"
            }
        ));
        txxx.setViewportView(tblFilmes);

        ButtonRemover.setText("Remover");
        ButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemoverActionPerformed(evt);
            }
        });

        ButtonRemover2.setText("Editar");
        ButtonRemover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemover2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lllllLayout = new javax.swing.GroupLayout(lllll);
        lllll.setLayout(lllllLayout);
        lllllLayout.setHorizontalGroup(
            lllllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lllllLayout.createSequentialGroup()
                .addGroup(lllllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lllllLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1))
                    .addGroup(lllllLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(txxx, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lllllLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(ButtonRemover2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        lllllLayout.setVerticalGroup(
            lllllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lllllLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txxx, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lllllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonRemover2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(ButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lllll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lllll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemoverActionPerformed
         
    if(tblFilmes.getSelectedRow() != -1) {
        
        FilmeDAO filmesDAO = new FilmeDAO();
        
        String idStr = tblFilmes.getValueAt(tblFilmes.getSelectedRow(), 0).toString();
        int id = Integer.parseInt(idStr); 
        
        
        boolean sucesso = filmesDAO.excluir(id);
        
        if (sucesso) {
            
            DefaultTableModel model = (DefaultTableModel) tblFilmes.getModel();
            model.removeRow(tblFilmes.getSelectedRow());
            JOptionPane.showMessageDialog(this, "Filme removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao remover o filme.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        
        JOptionPane.showMessageDialog(this, "Selecione um filme para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }   
    }//GEN-LAST:event_ButtonRemoverActionPerformed

    private void ButtonRemover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemover2ActionPerformed
        Editar e = new Editar();
        e.setVisible(true);
    }//GEN-LAST:event_ButtonRemover2ActionPerformed
   
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonRemover;
    private javax.swing.JButton ButtonRemover2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel lllll;
    javax.swing.JTable tblFilmes;
    javax.swing.JScrollPane txxx;
    // End of variables declaration//GEN-END:variables
}
