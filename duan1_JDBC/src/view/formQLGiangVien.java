/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;
import service.impl.adminServiceImpl;

/**
 *
 * @author Dell
 */
public class formQLGiangVien extends javax.swing.JFrame {

    private adminServiceImpl admsv = new adminServiceImpl();
    private DefaultTableModel tbmodel = new DefaultTableModel();
    private DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbmodelGender = new DefaultComboBoxModel();
    private List<NhanVien> listGV = new ArrayList<>();
    private List<NhanVien> listGV2 = new ArrayList<>();
    private List<NhanVien> listAllGV = new ArrayList<>();
    private List<NhanVien> listNV = new ArrayList<>();
    private List<String> listCBB = new ArrayList<>();
    private List<String> listCBBGender = new ArrayList<>();
    private String urlPic = "C:\\Clone\\project_nnn\\duan1_JDBC\\src\\portrait\\ava.jpg";
    private int i1 = 1;
    private int i2 = 5;

    /**
     * Creates new form formQLGiangVien
     */
    public formQLGiangVien() {
        initComponents();
        setLocationRelativeTo(null);
        listGV = admsv.listPTGV(i1, i2);
        listAllGV = admsv.getListGV();
        listNV = admsv.getListNV();
        loadData(listGV);
        loadCBB();

    }

    public void loadCBB() {
        jComboBox1.setModel(cbbmodel);
        listCBB.add("Đi Dạy");
        listCBB.add("Nghỉ Phép");//chưa biết nên set trạng thái có những gì ?
        cbbmodel.addAll(listCBB);
        cbbmodel.setSelectedItem("Đi Dạy");
    }

    public void loadData(List<NhanVien> list) {
        tbGiangVien.setModel(tbmodel);
        tbmodel.setRowCount(0);
        String title[] = {"Mã GV", "Họ Tên", "Giới Tính", "Ngày Sinh", "Email", "SĐT", "Địa Chỉ", "Mật Khẩu", "Trạng Thái"};
        tbmodel.setColumnIdentifiers(title);
        for (NhanVien nv : list) {
            String tt;
            if (nv.getTrangThai() == 0) {
                tt = "Đi Dạy";
            } else {
                tt = "Nghỉ Phép";
            }
            String hoTen = nv.getHo() + " " + nv.getTenDem() + " " + nv.getTen();
            tbmodel.addRow(new Object[]{nv.getMaNV(), hoTen,
                nv.isGioiTinh() == true ? "Nam" : "Nữ", nv.getNgaySinh(),
                nv.getEmail(), nv.getSdt(), nv.getDiaChi(), nv.getMatKhau(),
                tt
            });
        }
    }

    public ImageIcon resizeImage(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(lbPhoto.getWidth(), lbPhoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    public void filllData(int index) {
        NhanVien nv = listGV.get(index);
        txtMaGV.setText(nv.getMaNV());
        lbHoTen.setText(nv.getHo() + " " + nv.getTenDem() + " " + nv.getTen());
        txtNgaySinh.setText(String.valueOf(nv.getNgaySinh()));
        txtEmail.setText(nv.getEmail());
        txtDiaChi.setText(nv.getDiaChi());
        txtSDT.setText(nv.getSdt());
        lbMatKhau.setText(nv.getMatKhau());
        txtTen.setText(nv.getTen());
        txtTenDem.setText(nv.getTenDem());
        txtHo.setText(nv.getHo());
        lbPhoto.setIcon(resizeImage(String.valueOf(nv.getImg())));
        if (nv.getTrangThai() == 0) {
            jComboBox1.setSelectedItem("Đi Dạy");
        } else {
            jComboBox1.setSelectedItem("Nghỉ Phép");
        }
        if (nv.isGioiTinh()) {
            jRadioButton1.setSelected(true);
            jRadioButton2.setSelected(false);
        } else {
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(true);

        }
    }

    public boolean validateForm(NhanVien nv, String maNV) {
        String checkSDT = "^0\\d{10}$";
        String checkEmail = "^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$";
        //String regexDate = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\20[2-9]{2}";
//        String checkMaNV = "^NV[0-9]{1,3}$";
        Pattern pt = Pattern.compile(checkSDT);
        Matcher mt = pt.matcher(nv.getSdt());
        if (nv.getMaNV().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã Nhân Viên Chưa Được Nhập");
            return false;
        }
//        if(!nv.getMaNV().matches(checkMaNV)){
//            JOptionPane.showMessageDialog(this, "Mã Nhân Viên Không Đúng Định Đạng!");
//            return false;
//        }
//        for (NhanVien nhanVien : listNV) {
//            
//        }
        if (nv.getHo().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ Chưa Được Nhập!");
            return false;
        }
        if (!nv.getHo().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Họ Phải Là Chữ!");
            return false;
        }
        if (nv.getTenDem().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên Đệm Chưa Được Nhập!");
            return false;
        }
        if (!nv.getTenDem().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Tên Đệm Phải Là Chữ!");
            return false;
        }
        if (nv.getTen().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên Chưa Được Nhập!");
            return false;
        }
        if (!nv.getTen().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Tên Phải Là Chữ!");
            return false;
        }
        if (nv.getEmail().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email Chưa Được Nhập!");
            return false;
        }
        if (!nv.getEmail().matches(checkEmail)) {
            JOptionPane.showMessageDialog(this, "Email Sai Định Dạng!");
            return false;
        }
        if (nv.getDiaChi().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa Chỉ Chưa Được Nhập!");
            return false;
        }
        if (!nv.getDiaChi().matches("^[a-zA-Z][a-zA-Z0-9 ]+$")) {
            JOptionPane.showMessageDialog(this, "Địa Chỉ Chưa Đúng Định Dạng!");
            return false;
        }
        if (nv.getSdt().isEmpty()) {
            JOptionPane.showMessageDialog(this, "SDT Chưa Được Nhập!");
            return false;
        }
        if (!mt.find()) {
            JOptionPane.showMessageDialog(this, "SDT Chưa Đúng Định Dạng!");
            return false;
        }
        return true;
    }

    public boolean validateFormAdd(NhanVien nv) {
        String checkSDT = "^0\\d{10}$";
        String checkEmail = "^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$";
        //String regexDate = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\20[2-9]{2}";
//        String checkMaNV = "^NV[0-9]{1,3}$";
        Pattern pt = Pattern.compile(checkSDT);
        Matcher mt = pt.matcher(nv.getSdt());
        if (nv.getMaNV().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã Nhân Viên Chưa Được Nhập");
            return false;
        }
//        if(!nv.getMaNV().matches(checkMaNV)){
//            JOptionPane.showMessageDialog(this, "Mã Nhân Viên Không Đúng Định Đạng!");
//            return false;
//        }
        for (NhanVien nhanVien : listNV) {
            if (nhanVien.getMaNV().equalsIgnoreCase(nv.getMaNV())) {
                JOptionPane.showMessageDialog(this, "Mã Bạn Nhập Đã Tồn Tại!!");
                return false;
            }
        }
        if (nv.getHo().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ Chưa Được Nhập!");
            return false;
        }
        if (!nv.getHo().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Họ Phải Là Chữ!");
            return false;
        }
        if (nv.getTenDem().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên Đệm Chưa Được Nhập!");
            return false;
        }
        if (!nv.getTenDem().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Tên Đệm Phải Là Chữ!");
            return false;
        }
        if (nv.getTen().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên Chưa Được Nhập!");
            return false;
        }
        if (!nv.getTen().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Tên Phải Là Chữ!");
            return false;
        }
        if (nv.getEmail().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email Chưa Được Nhập!");
            return false;
        }
        if (!nv.getEmail().matches(checkEmail)) {
            JOptionPane.showMessageDialog(this, "Email Sai Định Dạng!");
            return false;
        }
        if (nv.getDiaChi().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa Chỉ Chưa Được Nhập!");
            return false;
        }
        if (!nv.getDiaChi().matches("^[a-zA-Z][a-zA-Z0-9 ]+$")) {
            JOptionPane.showMessageDialog(this, "Địa Chỉ Chưa Đúng Định Dạng!");
            return false;
        }
        if (nv.getSdt().isEmpty()) {
            JOptionPane.showMessageDialog(this, "SDT Chưa Được Nhập!");
            return false;
        }
        if (!mt.find()) {
            JOptionPane.showMessageDialog(this, "SDT Chưa Đúng Định Dạng!");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGiangVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaGV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtTenDem = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbMatKhau = new javax.swing.JLabel();
        lbPhoto = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        lbHoTen = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbGiangVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tbGiangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGiangVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbGiangVien);

        jLabel1.setText("Quản Lý Giảng Viên");

        jLabel2.setText("Mã GV");

        jLabel3.setText("Họ Tên");

        jLabel4.setText("Ngày Sinh");

        jLabel5.setText("Email");

        jLabel6.setText("SDT");

        jLabel7.setText("Địa Chỉ");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        jLabel8.setText("Trạng Thái");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Mật Khẩu");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete.png"))); // NOI18N
        jButton3.setText("Xoá");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setText("Họ");

        jLabel13.setText("Tên");

        jLabel14.setText("Tên Đệm");

        lbMatKhau.setText("_____________");

        lbPhoto.setText("Photo");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Open file.png"))); // NOI18N
        jButton4.setText("Chọn Ảnh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel17.setText("Giớ Tính");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Nam");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Nữ");

        lbHoTen.setText("-------------------------");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        jButton5.setText("Quay Lại");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText(">");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("<");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel10.setText("?/?");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        jButton8.setText("Tìm Kiếm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jRadioButton1)
                        .addGap(31, 31, 31)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(txtTenDem)
                                    .addComponent(txtHo))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                        .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSDT)
                                            .addComponent(lbHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEmail))))))))
                .addGap(3, 3, 3)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lbPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 25, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(346, 346, 346)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(198, 198, 198)
                                        .addComponent(jButton1)
                                        .addGap(60, 60, 60)
                                        .addComponent(jButton2)
                                        .addGap(57, 57, 57))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(94, 94, 94)))
                                .addComponent(jButton3)
                                .addGap(104, 104, 104)
                                .addComponent(jButton4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel10)
                .addGap(52, 52, 52)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(463, 463, 463))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel16)
                            .addComponent(lbMatKhau))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton4))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(142, 142, 142)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jButton5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(lbHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jRadioButton2)
                                            .addComponent(jRadioButton1)
                                            .addComponent(jLabel17))))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jLabel10)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbGiangVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGiangVienMouseClicked
        // TODO add your handling code here:
        int row = tbGiangVien.getSelectedRow();
        filllData(row);
    }//GEN-LAST:event_tbGiangVienMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String maNV = txtMaGV.getText();
        String ho = txtHo.getText();
        String tenDem = txtTenDem.getText();
        String ten = txtTen.getText();
        String email = txtEmail.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        String ngaySinh = txtNgaySinh.getText();
        String matKhau = lbMatKhau.getText();
        boolean gender;
        NhanVien nv = new NhanVien();
        nv.setMaNV(maNV);
        nv.setHo(ho);
        nv.setTenDem(tenDem);
        nv.setTen(ten);
        try {
            Date d1 = df.parse(ngaySinh);
            nv.setNgaySinh(d1);
        } catch (ParseException ex) {
            Logger.getLogger(formQLGiangVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        int tt;
        if (jComboBox1.getSelectedItem() == "Đi Dạy") {
            tt = 0;
        } else {
            tt = 1;
        }
        nv.setTrangThai(tt);
        nv.setEmail(email);
        nv.setDiaChi(diaChi);
        nv.setSdt(sdt);
        nv.setMatKhau(matKhau);
        nv.setImg(urlPic);
        if (jRadioButton1.isSelected()) {
            gender = true;
        } else {
            gender = false;
        }
        nv.setGioiTinh(gender);
        boolean a = validateFormAdd(nv);
        if (a) {
            if (admsv.addGV(nv)) {
                JOptionPane.showMessageDialog(this, "Thêm Giảng Viên Thành Công!");
                listGV = admsv.getListGV();
                loadData(listGV);
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi Chưa Rõ!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int row = tbGiangVien.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Giảng Viên Muốn Cập Nhật!");
        } else {
            NhanVien nvv = listGV.get(row);
            String maNV = txtMaGV.getText();
            String ho = txtHo.getText();
            String tenDem = txtTenDem.getText();
            String ten = txtTen.getText();
            String email = txtEmail.getText();
            String diaChi = txtDiaChi.getText();
            String sdt = txtSDT.getText();
            String ngaySinh = txtNgaySinh.getText();
            String matKhau = lbMatKhau.getText();
            boolean gender;
            NhanVien nv = new NhanVien();
            nv.setMaNV(maNV);
            nv.setHo(ho);
            nv.setTenDem(tenDem);
            nv.setTen(ten);
            try {
                Date d1 = df.parse(ngaySinh);
                nv.setNgaySinh(d1);
            } catch (ParseException ex) {
                Logger.getLogger(formQLGiangVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            int tt;
            if (jComboBox1.getSelectedItem() == "Đi Dạy") {
                tt = 0;
            } else {
                tt = 1;
            }
            nv.setTrangThai(tt);
            nv.setEmail(email);
            nv.setDiaChi(diaChi);
            nv.setSdt(sdt);
            nv.setMatKhau(matKhau);
            nv.setImg(urlPic);
            if (jRadioButton1.isSelected()) {
                gender = true;
            } else {
                gender = false;
            }
            nv.setGioiTinh(gender);
            boolean a = validateForm(nv, nvv.getMaNV());
            if (a) {
                if (admsv.updateGV(nv, nvv.getMaNV())) {
                    JOptionPane.showMessageDialog(this, "Sửa Thành Công!");
                    listGV = admsv.getListGV();
                    loadData(listGV);
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi Update!");
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = tbGiangVien.getSelectedRow();
        NhanVien nv = listGV.get(row);
        if (admsv.deleteGV(nv.getMaNV())) {
            JOptionPane.showMessageDialog(this, "Xoá Giảng Viên Thành Công!");
            listGV = admsv.getListGV();
            loadData(listGV);
        } else {
            JOptionPane.showMessageDialog(this, "Bug rồi Chớ Fix Đi!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("C:\\Clone\\project_nnn\\duan1_JDBC\\src\\portrait");
            jfc.setDialogTitle("Chọn Ảnh :");
            jfc.showOpenDialog(null);
            File fl = jfc.getSelectedFile();
            urlPic = fl.getAbsolutePath();
            if (urlPic != null) {
                lbPhoto.setIcon(resizeImage(urlPic));
            } else {
                JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Ảnh!"
                        + "Nếu Chưa Chọn Thì Hệ Thống Sẽ Chọn Ảnh Mặc Định");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Chọn Ảnh!"
                    + "Nếu Chưa Chọn Thì Hệ Thống Sẽ Chọn Ảnh Mặc Định");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        menuAdmin m = new menuAdmin();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (listAllGV.size() % 5 != 0) {
            if (i1 >= listAllGV.size() / 5 + 1) {
                i1 = 1;
                int maxPage = listAllGV.size() / 5 + 1;
                jLabel10.setText(i1 + "/" + maxPage);
                listGV = admsv.listPTGV(i1, i2);
                loadData(listGV);
            } else {
                i1 += 1;
                int maxPage = listAllGV.size() / 5 + 1;
                jLabel10.setText(i1 + "/" + maxPage);
                listGV = admsv.listPTGV(i1, i2);
                loadData(listGV);
            }
        } else {
            if (i1 >= listAllGV.size() / 5) {
                i1 = 1;
                int maxPage = listAllGV.size() / 5;
                jLabel10.setText(i1 + "/" + maxPage);
                listGV = admsv.listPTGV(i1, i2);
                loadData(listGV);
            } else {
                i1 += 1;
                int maxPage = listAllGV.size() / 5;
                jLabel10.setText(i1 + "/" + maxPage);
                listGV = admsv.listPTGV(i1, i2);
                loadData(listGV);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if (listAllGV.size() % 5 != 0) {
            if (i1 <= 1) {
                i1 = listAllGV.size() / 5 + 1;
                listGV = admsv.listPTGV(i1, i2);
                int maxPage = listAllGV.size() / 5 + 1;
                jLabel10.setText(i1 + "/" + maxPage);
                loadData(listGV);
            } else {
                i1 -= 1;
                listGV = admsv.listPTGV(i1, i2);
                int maxPage = listAllGV.size() / 5 + 1;
                jLabel10.setText(i1 + "/" + maxPage);
                loadData(listGV);
            }
        } else {
            if (i1 <= 1) {
                i1 = listAllGV.size() / 5;
                listGV = admsv.listPTGV(i1, i2);
                int maxPage = listAllGV.size() / 5;
                jLabel10.setText(i1 + "/" + maxPage);
                loadData(listGV);
            } else {
                i1 -= 1;
                listGV = admsv.listPTGV(i1, i2);
                int maxPage = listAllGV.size() / 5;
                jLabel10.setText(i1 + "/" + maxPage);
                loadData(listGV);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        String ten = txtSearch.getText();
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Tên Giảng Viên Muốn Tìm!");
        } else {
            listGV2 = admsv.listSearchGV(ten);
            if (listGV2.size() == 0) {
                JOptionPane.showMessageDialog(this, "Không Tìm Thấy");
            } else {
                jLabel10.setText("");
                loadData(listGV2);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(formQLGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formQLGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formQLGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formQLGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formQLGiangVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbPhoto;
    private javax.swing.JTable tbGiangVien;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMaGV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    // End of variables declaration//GEN-END:variables
}
