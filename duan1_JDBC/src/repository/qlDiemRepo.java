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
import model.DongHocPhi;
import utilities.DBContext;
import viewmodel.QLLopGV;
import viewmodel.qlDiem;

/**
 *
 * @author HánH
 */
public class qlDiemRepo {

    public List<QLLopGV> getDsLOp(String idGiangVien) {
        String query = "select lop.id,Lop.idMonHoc,hocvien.id,maLop,tenLop,MonHoc.tenMon,Lop.slHocVien\n"
                + "from Lop join LopHocVien on Lop.id = LopHocVien.idLop\n"
                + "join HocVien on LopHocVien.idHocVien = HocVien.id\n"
                + "join MonHoc on Lop.idMonHoc = MonHoc.id\n"
                + "where Lop.idGiangVien = ? ";
        List<QLLopGV> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idGiangVien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLLopGV ds = new QLLopGV();
                ds.setIdLop(rs.getString("id"));
                ds.setIdMonHoc(rs.getString("idMonHoc"));
                ds.setIdHocVien(rs.getString(3));
                ds.setMaLop(rs.getString("maLop"));
                ds.setTenLop(rs.getString("tenLop"));
                ds.setSlHocVien(rs.getInt("slHocVien"));
                ds.setTenMon(rs.getString("tenMon"));
                list.add(ds);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;

    }

    public String getIDNV(String ma) {
        String id = null;
        String query = "select Id from NhanVien where MaNV = ?";
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

    public String getIDHV(String ma) {
        String id = null;
        String query = "select Id from HocVien where MaHV = ?";
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

    public String getIDLop(String idGV) {
        String id = null;
        String query = "select Id from Lop where idGiangVien = ? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idGV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public List<qlDiem> getDSHV(String idGV, String idLop) {
        String query = "select ht.id,idHocVien,ht.idMonHoc,hv.maHV,hv.ho,hv.tenDem,hv.ten,"
                + "diemGiuaKy,diemTongKet,danhGia,ht.trangThai,ht.ngayTao,ht.ngaySua from KetQuaHT ht\n"
                + "inner join MonHoc mh on mh.id = ht.idMonHoc\n"
                + "inner join lop l on l.idMonHoc = mh.id\n"
                + "inner join NhanVien nv on nv.id = l.idGiangVien\n"
                + "inner join HocVien hv on hv.id = ht.idHocVien\n"
                + "where l.idGiangVien = ? and l.id = ?";
        List<qlDiem> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idGV);
            ps.setObject(2, idLop);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qlDiem ht = new qlDiem();
                ht.setId(rs.getString("id"));
                ht.setIdHocVien(rs.getString("idHocVien"));
                ht.setIdMonHoc(rs.getString("idMonHoc"));
                ht.setMaHV(rs.getString("maHV"));
                ht.setHoHV(rs.getString("ho"));
                ht.setTenDemHV(rs.getString("tenDem"));
                ht.setTenHV(rs.getString("ten"));
                ht.setDiemGiuaKy(rs.getFloat("diemGiuaKy"));
                ht.setDiemTongKet(rs.getFloat("diemTongKet"));
                ht.setTrangThai(rs.getInt("trangThai"));
                ht.setDanhGia(rs.getString("danhGia"));
                list.add(ht);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;

    }

    public boolean updateDiem(qlDiem kt, String idHV) {
        String query = "UPDATE [dbo].[KetQuaHT]\n"
                + "   SET [diemGiuaKy] = ?\n"
                + "      ,[diemTongKet] = ?\n"
                + "      ,[danhGia] = ?\n"
                + "      ,[trangThai] = ?\n"
                + "      ,[ngayTao] = ?\n"
                + "      ,[ngaySua] = ?\n"
                + " WHERE idHocVien =  ?";
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, kt.getDiemGiuaKy());
            ps.setObject(2, kt.getDiemTongKet());
            ps.setObject(3, kt.getDanhGia());
            ps.setObject(4, kt.getTrangThai());
            ps.setObject(5, date);
            ps.setObject(6, date);
            ps.setObject(7, idHV);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
