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
    private List<NhanVien> listNV = new ArrayList<>();
    private List<String> listCBB = new ArrayList<>();
    private List<String> listCBBGender = new ArrayList<>();
    private String urlPic = "C:\\Clone\\project_nnn\\duan1_JDBC\\src\\portrait\\ava.jpg";

    /**
     * Creates new form formQLGiangVien
     */
    public formQLGiangVien() {
        initComponents();
        setLocationRelativeTo(null);
        listGV = admsv.getListGV();
        listNV = admsv.getListNV();
        loadData(listGV);
        loadCBBGender();
    }

    public void loadCBBGender() {
        jComboBox2.setModel(cbbmodelGender);
        listCBBGender.add("Nam");
        listCBBGender.add("Nữ");
        cbbmodelGender.addAll(listCBBGender);
        cbbmodelGender.setSelectedItem("Nam");
    }

    public void loadCBB() {
        jComboBox1.setModel(cbbmodel);
        listCBB.add("");
        listCBB.add("");//chưa biết nên set trạng thái có những gì ?
    }

    public void loadData(List<NhanVien> list) {
        tbGiangVien.setModel(tbmodel);
        tbmodel.setRowCount(0);
        String title[] = {"Mã GV", "Họ Tên", "Giới Tính", "Ngày Sinh", "Email", "SĐT", "Địa Chỉ", "Mật Khẩu",};
        tbmodel.setColumnIdentifiers(title);
        for (NhanVien nv : list) {
            String hoTen = nv.getHo() + " " + nv.getTenDem() + " " + nv.getTen();
            tbmodel.addRow(new Object[]{nv.getMaNV(), hoTen, 
                nv.isGioiTinh() == true ? "Nam" : "Nữ", nv.getNgaySinh(),
                nv.getEmail(), nv.getSdt(), nv.getDiaChi(), nv.getMatKhau()});
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
        txtHoTen.setText(nv.getHo() + " " + nv.getTenDem() + " " + nv.getTen());
        txtNgaySinh.setText(String.valueOf(nv.getNgaySinh()));
        lbNgayTao.setText(String.valueOf(nv.getNgayTao()));
        lbNgaySua.setText(String.valueOf(nv.getNgaySua()));
        txtEmail.setText(nv.getEmail());
        txtDiaChi.setText(nv.getDiaChi());
        txtSDT.setText(nv.getSdt());
        lbMatKhau.setText(nv.getMatKhau());
        txtTen.setText(nv.getTen());
        txtTenDem.setText(nv.getTenDem());
        txtHo.setText(nv.getHo());
        lbPhoto.setIcon(resizeImage(String.valueOf(nv.getImg())));
        if (nv.isGioiTinh()) {
            jComboBox2.setSelectedIndex(0);
        } else {
            jComboBox2.setSelectedIndex(1
            );
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tbGiangVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaGV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbNgaySua = new javax.swing.JLabel();
        lbNgayTao = new javax.swing.JLabel();
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
        jComboBox2 = new javax.swing.JComboBox<>();

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

        jLabel10.setText("Ngày Tạo");

        jLabel12.setText("Ngày Sửa");

        lbNgaySua.setText("_____________");

        lbNgayTao.setText("_____________");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        jButton4.setText("Chọn Ảnh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel17.setText("Giớ Tính");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addComponent(lbPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 223, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(lbNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(lbMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel13)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jButton1)
                        .addGap(60, 60, 60)
                        .addComponent(jButton2)
                        .addGap(57, 57, 57)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(401, 401, 401))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel16)
                            .addComponent(lbMatKhau)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel4)
                                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel14))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel17)
                                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel11)
                                                    .addComponent(lbNgayTao))
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel12)
                                                    .addComponent(lbNgaySua))))
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(lbPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
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
        nv.setEmail(email);
        nv.setDiaChi(diaChi);
        nv.setSdt(sdt);
        nv.setMatKhau(matKhau);
        nv.setImg(urlPic);
        if (jComboBox2.getSelectedItem() == "Nam") {
            gender = false;
        } else {
            gender = true;
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

        nv.setEmail(email);
        nv.setDiaChi(diaChi);
        nv.setSdt(sdt);
        nv.setMatKhau(matKhau);
        nv.setImg(urlPic);
        if (jComboBox2.getSelectedItem() == "Nam") {
            gender = false;
        } else {
            gender = true;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbNgaySua;
    private javax.swing.JLabel lbNgayTao;
    private javax.swing.JLabel lbPhoto;
    private javax.swing.JTable tbGiangVien;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaGV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    // End of variables declaration//GEN-END:variables
}
