/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.HocVien;
import model.MonHoc;
import service.impl.adminServiceImpl;
import viewmodel.thongKeViewModel1;
import viewmodel.thongKeViewModel2;

/**
 *
 * @author acer
 */
public class FormThongKe extends javax.swing.JFrame {

    private DefaultTableModel tbmodel1 = new DefaultTableModel();
    private DefaultTableModel tbmodel2 = new DefaultTableModel();
    private List<thongKeViewModel1> listTK1 = new ArrayList<>();
    private List<thongKeViewModel2> listTK2 = new ArrayList<>();
    private adminServiceImpl admsv = new adminServiceImpl();

    /**
     * Creates new form FormThongKe
     */
    public FormThongKe() {
        initComponents();
        setLocationRelativeTo(null);
        BigDecimal sumMoney = admsv.thongKeTongTien();
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        String tt = formatter.format(sumMoney) + " VNĐ";
        lbSumMoney.setText("Tổng Số Học Phí Đã Thu : " + tt);
        int sl = admsv.tkSLHV();
        lbSumHV.setText("Số Học Viên Đóng Học Phí : " + sl);
        listTK1 = admsv.tKHPHV();
        listTK2 = admsv.tKHPMH();
        loadData2(listTK2);
        loadData(listTK1);
    }

    public void loadData(List<thongKeViewModel1> list) {
        tbTK1.setModel(tbmodel1);
        tbmodel1.setRowCount(0);
        String title[] = {"Mã Học Viên", "Học Viên", "Tổng Tiền Đóng"};
        tbmodel1.setColumnIdentifiers(title);
        for (thongKeViewModel1 tk : listTK1) {
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            HocVien hv = admsv.getHVById(tk.getIdHocVien());
            tbmodel1.addRow(new Object[]{hv.getMaHV(), hv.getHo() + " " + hv.getTenDem()
                + " " + hv.getTen(), formatter.format(tk.getTien()) + " VNĐ"});
        }
    }

    public void loadData2(List<thongKeViewModel2> list) {
        tbTK2.setModel(tbmodel2);
        tbmodel2.setRowCount(0);
        String title[] = {"Tên Môn", "Tổng Tiền Đóng"};
        tbmodel2.setColumnIdentifiers(title);
        for (thongKeViewModel2 tk : listTK2) {
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            MonHoc mh = admsv.getMonHoc(tk.getIdMonHoc());
            tbmodel2.addRow(new Object[]{mh.getTenMon(),
                 formatter.format(tk.getTien()) + " VNĐ"});
        }
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
        lbSumHV = new javax.swing.JLabel();
        lbSumMoney = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTK2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTK1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Thống Kê Doanh Số");

        lbSumHV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSumHV.setText("jLabel2");

        lbSumMoney.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSumMoney.setText("jLabel");

        tbTK2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbTK2);

        tbTK1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbTK1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 540, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(372, 372, 372))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSumMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSumHV, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(121, 121, 121)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(508, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(lbSumHV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lbSumMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(262, 262, 262)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(355, Short.MAX_VALUE)))
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
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbSumHV;
    private javax.swing.JLabel lbSumMoney;
    private javax.swing.JTable tbTK1;
    private javax.swing.JTable tbTK2;
    // End of variables declaration//GEN-END:variables
}
