/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HocKy;
import model.MonHoc;
import service.impl.adminServiceImpl;

/**
 *
 * @author Dell
 */
public class formQLMonHoc extends javax.swing.JFrame {

    private DefaultTableModel tbModel = new DefaultTableModel();
    private DefaultComboBoxModel cbbModel = new DefaultComboBoxModel();
    private adminServiceImpl admsv = new adminServiceImpl();
    private List<HocKy> listHocKy = new ArrayList<>();
    private List<MonHoc> listMH = new ArrayList<>();
    private List<String> listCBBHocKi = new ArrayList<>();
    private List<MonHoc> listAllMH = new ArrayList<>();
    private int pageIndex = 1;
    private int pageNumber = 5;

    /**
     * Creates new form formQLMonHoc
     */
    public formQLMonHoc() {
        initComponents();
        setLocationRelativeTo(null);
        listHocKy = admsv.getListHocKy();
        listAllMH = admsv.getAllMonHoc();
        listMH = admsv.listPTMonHoc(pageIndex, pageNumber);
        loadCBB(listHocKy);
        ShowDataMonHoc(listMH);

    }

    public void loadCBB(List<HocKy> list) {
        cbbHocKy.setModel(cbbModel);
        list = admsv.sortHocKy(list);
        for (HocKy h : list) {
            listCBBHocKi.add("Kì " + String.valueOf(h.getHocKy()));
        }

        cbbModel.addAll(listCBBHocKi);
        cbbModel.setSelectedItem("Kỳ 1");
    }

    public void ShowDataMonHoc(List<MonHoc> list) {
        tbMonHoc.setModel(tbModel);
        tbModel.setRowCount(0);
        String title[] = {"Tên Môn", "Học Kì", "Học Phí", "Thời Lượng"};
        tbModel.setColumnIdentifiers(title);
        for (MonHoc mh : list) {
            HocKy h = admsv.getHocKy(mh.getIdHocKy());
            String hk = "Kì " + String.valueOf(h.getHocKy());
            String tl = String.valueOf(mh.getThoiLuong()) + " Tháng";
            tbModel.addRow(new Object[]{mh.getTenMon(), hk,
                mh.getHocPhi(), tl});
        }
    }

    public void fillData(int index) {
        MonHoc mh = listMH.get(index);
        txtTenMon.setText(mh.getTenMon());
        txtHocPhi.setText(String.valueOf(mh.getHocPhi()));
        txtThoiLuong.setText(String.valueOf(mh.getThoiLuong()));
        HocKy h = admsv.getHocKy(mh.getIdHocKy());
        if (h.getHocKy() == 1) {
            cbbHocKy.setSelectedIndex(0);
        } else if (h.getHocKy() == 2) {
            cbbHocKy.setSelectedIndex(1);
        } else if (h.getHocKy() == 3) {
            cbbHocKy.setSelectedIndex(2);
        } else if (h.getHocKy() == 4) {
            cbbHocKy.setSelectedIndex(3);
        } else if (h.getHocKy() == 5) {
            cbbHocKy.setSelectedIndex(4);
        } else if (h.getHocKy() == 6) {
            cbbHocKy.setSelectedIndex(5);
        } else {
            cbbHocKy.setSelectedIndex(6);
        }
    }

    public boolean validateFormUpdate(String tl, String hp, String tenMon) {

        if (!tenMon.matches("^[a-zA-Z][a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ#+ ]{2,49}+$")) {
            JOptionPane.showMessageDialog(this, "Tên Môn Sai Định Dạng!");
            return false;
        }
        if (!hp.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Học Phí Phải Là Số!");
            return false;
        }
        if (Integer.valueOf(hp) < 500000 && Integer.valueOf(hp) > 3000000) {
            JOptionPane.showMessageDialog(this, "Theo Yêu Cầu Của Bộ Đào Tạo Học Phí 1 Môn"
                    + "Sẽ Tối Thiểu Là 500.000VNĐ Và Tối Đa Là 3.000.000VNĐ!");
            return false;
        }
        if (!tl.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Thời Lượng Phải Là Số!");
            return false;
        }
        if (Integer.valueOf(tl) < 1 && Integer.valueOf(tl) > 12) {
            JOptionPane.showMessageDialog(this, "Thời Lượng Phải Nằm Trong Khoảng 1 -> 12!");
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTenMon = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbMonHoc = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cbbHocKy = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("Môn Học");

        jLabel19.setText("Tên Môn");

        jLabel20.setText("Thời Lượng");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        jButton8.setText("Tạo ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit.png"))); // NOI18N
        jButton9.setText("Sửa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete.png"))); // NOI18N
        jButton10.setText("Xóa");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        tbMonHoc.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMonHocMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbMonHoc);

        jLabel21.setText("Học Phí");

        jLabel24.setText("Kì Học");

        cbbHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Tháng");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Log out.png"))); // NOI18N
        jButton1.setText("Quay Lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(">");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("?/?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(jButton8))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButton1)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton9)
                                .addGap(40, 40, 40)
                                .addComponent(jButton10))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)
                        .addGap(49, 49, 49)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton1)))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbbHocKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jButton9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jLabel4))
                .addGap(132, 132, 132))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String tenMon = txtTenMon.getText();
        String tl = txtThoiLuong.getText();
        String hp = txtHocPhi.getText();
        int hk;
        if (cbbHocKy.getSelectedIndex() == 0) {
            hk = 1;
        } else if (cbbHocKy.getSelectedIndex() == 1) {
            hk = 2;
        } else if (cbbHocKy.getSelectedIndex() == 2) {
            hk = 3;
        } else if (cbbHocKy.getSelectedIndex() == 3) {
            hk = 4;
        } else if (cbbHocKy.getSelectedIndex() == 4) {
            hk = 5;
        } else if (cbbHocKy.getSelectedIndex() == 5) {
            hk = 6;
        } else {
            hk = 7;
        }
        Double h = Double.valueOf(hp);
        String idHocKy = admsv.getIdHocKi(hk);
        MonHoc mh = new MonHoc();
        mh.setTenMon(tenMon);
        mh.setIdHocKy(idHocKy);
        mh.setThoiLuong(Integer.valueOf(tl));
        mh.setHocPhi(BigDecimal.valueOf(h));
        if (validateFormUpdate(tl, hp, tenMon)) {
            if (admsv.addMonHoc(mh)) {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công!");
                listMH = admsv.getAllMonHoc();
               ShowDataMonHoc(listMH);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm Thất Bại!");
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        int row = tbMonHoc.getSelectedRow();
        MonHoc mh = listMH.get(row);
        if (admsv.deleteMonHoc(mh.getId())) {
            JOptionPane.showMessageDialog(this, "Xoá Môn Học Thành Công!");
            listMH = admsv.getAllMonHoc();
            ShowDataMonHoc(listMH);
        } else {
            JOptionPane.showMessageDialog(this, "Môn Học không được xóa!");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tbMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMonHocMouseClicked
        // TODO add your handling code here:
        int row = tbMonHoc.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tbMonHocMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int row = tbMonHoc.getSelectedRow();
        MonHoc mc = listMH.get(row);
        String id = mc.getId();
        String tenMon = txtTenMon.getText();
        String tl = txtThoiLuong.getText();
        String hp = txtHocPhi.getText();
        int hk;
        if (cbbHocKy.getSelectedIndex() == 0) {
            hk = 1;
        } else if (cbbHocKy.getSelectedIndex() == 1) {
            hk = 2;
        } else if (cbbHocKy.getSelectedIndex() == 2) {
            hk = 3;
        } else if (cbbHocKy.getSelectedIndex() == 3) {
            hk = 4;
        } else if (cbbHocKy.getSelectedIndex() == 4) {
            hk = 5;
        } else if (cbbHocKy.getSelectedIndex() == 5) {
            hk = 6;
        } else {
            hk = 7;
        }
        Double h = Double.valueOf(hp);
        String idHocKy = admsv.getIdHocKi(hk);
        MonHoc mh = new MonHoc();
        mh.setTenMon(tenMon);
        mh.setIdHocKy(idHocKy);
        mh.setThoiLuong(Integer.valueOf(tl));
        mh.setHocPhi(BigDecimal.valueOf(h));
        if (validateFormUpdate(tl, hp, tenMon)) {
            if (admsv.updateMonHoc(id, mh)) {
                JOptionPane.showMessageDialog(this, "Sửa Thành Công!");
                listMH = admsv.getAllMonHoc();
                ShowDataMonHoc(listMH);
            } else {
                JOptionPane.showMessageDialog(this, "Sửa Thất Bại!");
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        menuAdmin m = new menuAdmin();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (listAllMH.size() % 5 != 0) {
            if (pageIndex >= listAllMH.size() / 5 + 1) {
                pageIndex = 1;
                listMH = admsv.listPTMonHoc(pageIndex, pageNumber);
                int maxPage = listAllMH.size() / 5 + 1;
                jLabel4.setText(pageIndex + "/" + maxPage);
                ShowDataMonHoc(listMH);
            } else {
                pageIndex += 1;
                listMH = admsv.listPTMonHoc(pageIndex, pageNumber);
                int maxPage = listAllMH.size() / 5 + 1;
                jLabel4.setText(pageIndex + "/" + maxPage);
                ShowDataMonHoc(listMH);
            }
        } else {
            if (pageIndex >= listAllMH.size() / 5) {
                pageIndex = 1;
                listMH = admsv.listPTMonHoc(pageIndex, pageNumber);
                int maxPage = listAllMH.size() / 5;
                jLabel4.setText(pageIndex + "/" + maxPage);
                ShowDataMonHoc(listMH);
            } else {
                pageIndex += 1;
                listMH = admsv.listPTMonHoc(pageIndex, pageNumber);
                int maxPage = listAllMH.size() / 5;
                jLabel4.setText(pageIndex + "/" + maxPage);
                ShowDataMonHoc(listMH);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (listAllMH.size() % 5 != 0) {
            if (pageIndex <= 1) {
                pageIndex = listAllMH.size() / 5 + 1;
                listMH = admsv.listPTMonHoc(pageIndex, pageNumber);
                int maxPage = listAllMH.size() / 5 + 1;
                jLabel4.setText(pageIndex + "/" + maxPage);
                ShowDataMonHoc(listMH);
            } else {
                pageIndex -= 1;
                listMH = admsv.listPTMonHoc(pageIndex, pageNumber);
                int maxPage = listAllMH.size() / 5 + 1;
                jLabel4.setText(pageIndex + "/" + maxPage);
                ShowDataMonHoc(listMH);
            }
        } else {
            if (pageIndex <= 1) {
                pageIndex = listAllMH.size() / 5;
                listMH = admsv.listPTMonHoc(pageIndex, pageNumber);
                int maxPage = listAllMH.size() / 5;
                jLabel4.setText(pageIndex + "/" + maxPage);
               ShowDataMonHoc(listMH);
            } else {
                pageIndex -= 1;
                listMH = admsv.listPTMonHoc(pageIndex, pageNumber);
                int maxPage = listAllMH.size() / 5;
                jLabel4.setText(pageIndex + "/" + maxPage);
                ShowDataMonHoc(listMH);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(formQLMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formQLMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formQLMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formQLMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formQLMonHoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbHocKy;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbMonHoc;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtTenMon;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
