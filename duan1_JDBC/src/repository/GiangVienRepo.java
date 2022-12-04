/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utilities.SQLConnection;
import model.NhanVien;

/**
 *
 * @author Nguyễn Thắng
 */
public class GiangVienRepo {

    public List<NhanVien> getAll() {

        String query = "select * from NhanVien";
        List<NhanVien> listNV = new ArrayList<>();
        try (Connection con = SQLConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getString("id"));
                nv.setMaNV(rs.getString("maNV"));
                nv.setHo(rs.getString("ho"));
                nv.setTenDem(rs.getString("tenDem"));
                nv.setTen(rs.getString("ten"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setTrangThai(rs.getInt("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setIdChucVu(rs.getInt("idChucVu"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                nv.setImg(rs.getString("anh"));
                listNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listNV;
    }

    public boolean updateNV(String maNV, NhanVien nv) {
        String query = "Update NhanVien SET diaChi = ? , sdt = ? where maNV = ?";
        int check = 0;
        try (Connection con = SQLConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getDiaChi());
            ps.setObject(2, nv.getSdt());
            ps.setObject(3, nv.getMaNV());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public NhanVien getOne(String maNV) {
        String query = "select * from NhanVien where maNV = ?";
        NhanVien nv = new NhanVien();
        try (Connection conn = SQLConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.setId(rs.getString("id"));
                nv.setMaNV(rs.getString("maNV"));
                nv.setHo(rs.getString("ho"));
                nv.setTenDem(rs.getString("tenDem"));
                nv.setTen(rs.getString("ten"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setTrangThai(rs.getInt("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setIdChucVu(rs.getInt("idChucVu"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                nv.setImg(rs.getString("anh"));
            }
            return nv;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;

    }
    
    public boolean updatePassGv(String newPass, String maNV) {
        int check = 0;
        String query = "Update NhanVien Set matKhau = ? where idChucVu = 0 and maNV = ?";
        try (Connection conn = SQLConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, newPass);
            ps.setObject(2, maNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
