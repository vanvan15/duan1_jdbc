/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnext.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HocVien;
import model.NhanVien;


/**
 *
 * @author Dell
 */
public class loginRepo {
     public List<NhanVien> getALLNV() {
        String query = "select*from NhanVien";
        List<NhanVien> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getString(1));
                nv.setMaNV(rs.getString(2));
                nv.setHo(rs.getString(3));
                nv.setTenDem(rs.getString(4));
                nv.setTen(rs.getString(5));
                nv.setEmail(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setSdt(rs.getString(8));
                nv.setNgaySinh(rs.getDate(9));
                nv.setTrangThai(rs.getInt(10));
                nv.setMatKhau(rs.getString(11));
                nv.setIdChucVu(rs.getInt(12));
                nv.setNgayTao(rs.getDate(13));
                nv.setNgaySua(rs.getDate(14));
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
        
    }
    
    public List<HocVien> getALLHV() {
        String query = "select*from HocVien";
        List<HocVien> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocVien nv = new HocVien();
                nv.setIdHocVien(rs.getString(1));
                nv.setMaHV(rs.getString(2));
                nv.setHo(rs.getString(3));
                nv.setTenDem(rs.getString(4));
                nv.setTen(rs.getString(5));
                nv.setEmail(rs.getString(6));
                nv.setSdt(rs.getString(7));
                nv.setNgaySinh(rs.getDate(8));
                nv.setTrangThai(rs.getInt(9));
                nv.setMatKhau(rs.getString(10));
                nv.setNgayTao(rs.getDate(11));
                nv.setNgaySua(rs.getDate(12));
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
        
    }
    
    public String getOne(String maNV) {
        String id = null;
        String query = "select idChucVu from NhanVien where maNV = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return id;
    }
     public String getIDNV(String ma) {
        String id = null;
        String query = "select Id from NhanVien where Ma = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
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

    public String getIDHocVien(String ma) {
        String id = null;
        String query = "select Id from HocVien where Ma = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
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
    public static void main(String[] args) {
        String maNV = "nv005";
        String id = new loginRepo().getOne(maNV);
        System.out.println(id);
    }
}
