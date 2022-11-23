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
import model.HocVien;
import utilities.DBContext;

/**
 *
 * @author HánH
 */
public class hocvienRepo {

    public List<HocVien> getAll() {
        String query = "select id,maHV,ho,tenDem,ten,email,diaChi,sdt,ngaySinh,trangThai,matKhau,ngayTao,ngaySua,anh,gioiTinh from HocVien";
        List<HocVien> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocVien nv = new HocVien();
                nv.setIdHocVien(rs.getString("id"));
                nv.setMaHV(rs.getString("maHV"));
                nv.setHo(rs.getString("ho"));
                nv.setTenDem(rs.getString("tenDem"));
                nv.setTen(rs.getString("ten"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setTrangThai(rs.getInt("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
                nv.setImg(rs.getString("anh"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;

    }

    public String getIDHocVien(String ma) {
        String id = null;
        String query = "select id from HocVien where Ma = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public HocVien getOne(String ma) {
        String query = "select id,maHV,ho,tenDem,ten,email,diaChi,sdt,ngaySinh,trangThai,matKhau,ngayTao,ngaySua,anh,gioiTinh from HocVien where maHV = ?";
        HocVien nv = new HocVien();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.setIdHocVien(rs.getString("id"));
                nv.setMaHV(rs.getString("maHV"));
                nv.setHo(rs.getString("ho"));
                nv.setTenDem(rs.getString("tenDem"));
                nv.setTen(rs.getString("ten"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setTrangThai(rs.getInt("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
                nv.setImg(rs.getString("anh"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
            }
            return nv;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public boolean updateNV(String maHV, HocVien hv){
        String query ="Update HocVien SET diaChi = ? , sdt = ? where maHV = ?";
        int check = 0;
        try(Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hv.getDiaChi());
            ps.setObject(2, hv.getSdt());
            ps.setObject(3, hv.getMaHV());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }
//public boolean updateMK(String maNV, HocVien hv){
//        String query ="Update HocVien SET diaChi = ? , sdt = ? where maHV = ?";
//        int check = 0;
//        try(Connection con = DBContext.getConnection();
//                PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setObject(1, hv.getDiaChi());
//            ps.setObject(2, hv.getSdt());
//            ps.setObject(3, hv.getMaHV());
//            check = ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return check >0;
//    }
}
