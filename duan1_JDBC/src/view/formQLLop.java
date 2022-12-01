/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CaHoc;
import model.Lop;
import model.LopHocVien;
import model.MonHoc;
import service.impl.adminServiceImpl;

/**
 *
 * @author Dell
 */
public class formQLLop extends javax.swing.JFrame {

    private adminServiceImpl admsv = new adminServiceImpl();
    private DefaultTableModel tbmodel = new DefaultTableModel();
    private DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbmodel2 = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbmodel3 = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbmodel4 = new DefaultComboBoxModel();
    private List<MonHoc> listMH = new ArrayList<>();
    private List<Lop> listL = new ArrayList<>();
    private List<CaHoc> listCaHoc = new ArrayList<>();

    /**
     * Creates new form formQLLop
     */
    public formQLLop() {
        initComponents();
        setLocationRelativeTo(null);
        listMH = admsv.getListMonHoc();
        listCaHoc = admsv.getListCaHoc();
        listL = admsv.getListLop();
        loadCBBMH(listMH);
        loadCBBCH(listCaHoc);
        loadCBBTT();
        loadData(listL);
    }

    public void loadCBBTT() {
        List<String> listCBB = new ArrayList<>();
        cbbTrangThai.setModel(cbbmodel3);
        listCBB.add("Chờ Xếp Lớp");
        listCBB.add("Đang Học");
        listCBB.add("Hoàn Thành Chương Trình");
        cbbmodel3.addAll(listCBB);
        cbbTrangThai.setSelectedItem("Chờ Xếp Lớp");
    }

    public void loadCBBMH(List<MonHoc> list) {
        List<String> listCBB = new ArrayList<>();
        cbbMonHoc.setModel(cbbmodel);
        for (MonHoc m : list) {
            listCBB.add(m.getTenMon());
        }
        cbbmodel.addAll(listCBB);
        cbbmodel.setSelectedItem("Lap trinh C");
    }

    public void loadCBBCH(List<CaHoc> list) {
        List<String> listCBB = new ArrayList<>();
        cbbCaHoc.setModel(cbbmodel2);
        for (CaHoc m : list) {
            listCBB.add(m.getMaCa());
        }
        cbbmodel2.addAll(listCBB);
        cbbmodel2.setSelectedItem("Ca 1");
    }

    public void loadData(List<Lop> list) {
        tbLop.setModel(tbmodel);
        tbmodel.setRowCount(0);
        String title[] = {"Mã Lớp", "Tên Lớp", "Môn Học", "Ca Học", "Thời Gian", "Giảng Viên", "SL Học Viên",
            "Sl Tối Đa", "Ngày Tạo", "Ngày Sửa", "Trạng Thái"};
        tbmodel.setColumnIdentifiers(title);
        for (Lop lop : list) {
            String trangThai;
            if (lop.getTrangThai() == 0) {
                trangThai = "Chờ Xếp Lớp";
            } else if (lop.getTrangThai() == 1) {
                trangThai = "Đang Học";
            } else {
                trangThai = "Hoàn Thành Chương Trình";
            }
            CaHoc ch = admsv.getCaHoc(lop.getIdCa());
            MonHoc mh = admsv.getMonHoc(lop.getIdMonHoc());
            String tenGV = admsv.getTenGV(lop.getIdGiangVien());
            tbmodel.addRow(new Object[]{lop.getMalop(), lop.getTenLop(),
                mh.getTenMon(), ch.getMaCa(), ch.getThoiGian(), tenGV, lop.getSlHocVien(), lop.getSlToiDa(),
                lop.getNgayTao(), lop.getNgaySua(), trangThai
            });
        }
    }

    private void fillDataLopHoc(int index) {
        Lop lh = listL.get(index);
        txtMaLop.setText(lh.getMalop());
        txtTenLop.setText(lh.getTenLop());
        txtSoHV.setText(String.valueOf(lh.getSlHocVien()) + "/"
                + String.valueOf(lh.getSlToiDa()));
        CaHoc ch = admsv.getCaHoc(lh.getIdCa());
        if (ch.getMaCa().equalsIgnoreCase("Ca 1")) {
            cbbCaHoc.setSelectedItem("Ca 1");
        } else if (ch.getMaCa().equalsIgnoreCase("Ca 2")) {
            cbbCaHoc.setSelectedItem("Ca 2");
        } else if (ch.getMaCa().equalsIgnoreCase("Ca 3")) {
            cbbCaHoc.setSelectedItem("Ca 3");
        } else if (ch.getMaCa().equalsIgnoreCase("Ca 4")) {
            cbbCaHoc.setSelectedItem("Ca 4");
        } else if (ch.getMaCa().equalsIgnoreCase("Ca 5")) {
            cbbCaHoc.setSelectedItem("Ca 5");
        } else {
            cbbCaHoc.setSelectedItem("Ca 6");
        }
        MonHoc mh = admsv.getMonHoc(lh.getIdMonHoc());
        for (MonHoc monhoc : listMH) {
            if (monhoc.getTenMon().equalsIgnoreCase(mh.getTenMon())) {
                cbbMonHoc.setSelectedItem(mh.getTenMon());
            }
        }
        if (lh.getTrangThai() == 0) {
            cbbTrangThai.setSelectedItem("Chờ Xếp Lớp");
        } else if (lh.getTrangThai() == 1) {
            cbbTrangThai.setSelectedItem("Đang Học");
        } else {
            cbbTrangThai.setSelectedItem("Hoàn Thành Chương Trình");
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

        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        txtTenLop = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLop = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        txtSoHV = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cbbMonHoc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbbCaHoc = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtTenMon = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setText("QUẢN LÝ LỚP HỌC");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        jButton5.setText("THÊM");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit.png"))); // NOI18N
        jButton6.setText("SỬA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete.png"))); // NOI18N
        jButton7.setText("XÓA");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel17.setText("Mã Lớp");

        jLabel18.setText("Tên Lớp");

        tbLop.setModel(new javax.swing.table.DefaultTableModel(
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
        tbLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLopMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbLop);

        jLabel22.setText("Số Học Viên");

        txtSoHV.setText("-------");

        jLabel23.setText("Môn Học");

        cbbMonHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Ca Học");

        cbbCaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Phân Quyền Giảng Viên ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xoá Phân Quyền");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Xem Danh Sách Học Viên");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setText("Thêm Học Viên");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel2.setText("Trạng Thái");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        jButton1.setText("Quay Lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTenMon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenMonKeyReleased(evt);
            }
        });

        jButton9.setText("Tìm Kiếm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Reset CBB Môn Học");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10)
                    .addComponent(jButton1))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton9)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenMon)
                            .addComponent(txtMaLop, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(cbbMonHoc, 0, 107, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbCaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSoHV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(23, 23, 23))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6)
                                .addGap(65, 65, 65)
                                .addComponent(jButton7)
                                .addGap(59, 59, 59)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton5)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jButton4)))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtSoHV)
                    .addComponent(jButton2)
                    .addComponent(jButton8))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cbbMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbbCaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel2)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1237, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 5, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String ma = txtMaLop.getText();
        String tenLop = txtTenLop.getText();
        String caHoc = (String) cbbCaHoc.getSelectedItem();
        String tenMon = (String) cbbMonHoc.getSelectedItem();
        String idMonHoc = admsv.getIdByTenMon(tenMon);
        String idCa = admsv.getIdByMaCa(caHoc);
        Lop lop = new Lop();
        lop.setMalop(ma);
        lop.setTenLop(tenLop);
        lop.setIdCa(idCa);
        lop.setIdMonHoc(idMonHoc);
        if (admsv.addLop(lop)) {
            JOptionPane.showMessageDialog(this, "Thêm Lớp Thành Công!");
            listL = admsv.getListLop();
            loadData(listL);
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Thất Bại!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLopMouseClicked
        // TODO add your handling code here:
        int row = tbLop.getSelectedRow();
        fillDataLopHoc(row);
    }//GEN-LAST:event_tbLopMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = tbLop.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Lớp "
                    + "Cần Phần Quyền Giảng Viên!");
        } else {
            Lop l = listL.get(row);
            if (l.getIdGiangVien() == null) {
                formListGV flgv = new formListGV(l);
                flgv.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Bạn Chọn Lớp "
                        + "Đã Có Giảng Viên!");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int row = tbLop.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Lớp "
                    + "Để Thêm Học Viên!");
        } else {
            Lop l = listL.get(row);
            if (l.getSlHocVien() < 40 && l.getTrangThai() == 0) {
                FormListHV flhv = new FormListHV(l);
                flhv.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Bạn Chọn Lớp "
                        + "Đã Đầy Học Viên Hoặc Lớp Đã Kết Thúc Chương Trình Học!");

            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = tbLop.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Lớp "
                    + "Muốn Xem!");
        } else {
            Lop l = listL.get(row);
            FormListHV2 flhv = new FormListHV2(l);
            flhv.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int row = tbLop.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Lớp Muốn Tương Tác !");
        } else {
            Lop l = listL.get(row);
            String idLop = l.getId();
            String ma = txtMaLop.getText();
            String tenLop = txtTenLop.getText();
            String caHoc = (String) cbbCaHoc.getSelectedItem();
            String tenMon = (String) cbbMonHoc.getSelectedItem();
            String idMonHoc = admsv.getIdByTenMon(tenMon);
            String idCa = admsv.getIdByMaCa(caHoc);
            Lop lop = new Lop();
            lop.setId(idLop);
            lop.setMalop(ma);
            lop.setTenLop(tenLop);
            lop.setIdCa(idCa);
            lop.setIdMonHoc(idMonHoc);
            int tt;
            if (cbbTrangThai.getSelectedIndex() == 0) {
                tt = 0;
            } else if (cbbTrangThai.getSelectedIndex() == 1) {
                tt = 1;
            } else {
                tt = 2;
            }
            lop.setTrangThai(tt);
            if (admsv.updateLop(lop)) {
                JOptionPane.showMessageDialog(this, "Sửa Lớp Thành Công!");
                listL = admsv.getListLop();
                loadData(listL);
            } //else {
            //JOptionPane.showMessageDialog(this, "Sửa Lớp Thất Bại!");
            //}
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int row = tbLop.getSelectedRow();
        if (row >= 0) {
            Lop l = listL.get(row);
            List<LopHocVien> list = admsv.getListLopHV();
            for (LopHocVien lh : list) {
                if (lh.getIdLop().equalsIgnoreCase(l.getId())) {
                    if (admsv.deleteLopHV(l.getId())) {
                        if (admsv.deleteLop(l.getId())) {
                            JOptionPane.showMessageDialog(this, "Xoá Thành Công");
                            listL = admsv.getListLop();
                            loadData(listL);
                        }
                    }
                }
            }
            if (admsv.deleteLop(l.getId())) {
                JOptionPane.showMessageDialog(this, "Xoá Thành Công");
                listL = admsv.getListLop();
                loadData(listL);
            } else {
                JOptionPane.showMessageDialog(this, "Xoá Thất Bại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Lớp Muốn Tương Tác!");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = tbLop.getSelectedRow();
        if (row >= 0) {
            Lop l = listL.get(row);
            if (l.getIdGiangVien() == null) {
                JOptionPane.showMessageDialog(this, "Lớp chưa được phân quyền!");
            } else {
                if (admsv.xoaPhanQuyen(l.getId())) {
                    JOptionPane.showMessageDialog(this, "Xoá thành công !");
                    listL = admsv.getListLop();
                    loadData(listL);
                } else {
                    JOptionPane.showMessageDialog(this, "Xoá thất bại !");
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        menuAdmin m = new menuAdmin();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if (txtTenMon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Môn Học Muốn Tìm Kiếm!");
        } else {
            String tenMon = txtTenMon.getText();
            List<MonHoc> list = new ArrayList<>();
            list = admsv.listSearchMonHoc(tenMon);
            List<String> listCBB = new ArrayList<>();
            cbbMonHoc.setModel(cbbmodel4);
            for (MonHoc mh : list) {
                listCBB.add(mh.getTenMon());
            }
            cbbmodel4.addAll(listCBB);
            cbbmodel4.setSelectedItem(listCBB.get(0));
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txtTenMonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenMonKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTenMonKeyReleased

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        txtTenMon.setText("");
        loadCBBMH(listMH);
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(formQLLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formQLLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formQLLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formQLLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formQLLop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbCaHoc;
    private javax.swing.JComboBox<String> cbbMonHoc;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbLop;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JLabel txtSoHV;
    private javax.swing.JTextField txtTenLop;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}
