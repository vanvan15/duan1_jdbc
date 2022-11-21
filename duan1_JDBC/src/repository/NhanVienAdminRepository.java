/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author acer
 */
public class NhanVienAdminRepository {

    public boolean updatePassAdmin(String newPass, String maNV) {
        int check = 0;
        String query = "Update NhanVien Set matKhau = ? where idChucVu = 1 and maNV = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, newPass);
            ps.setObject(2, maNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public NhanVien getOneAdmin(String maNV) {
        NhanVien nv = new NhanVien();
        String query = "select id,ten,tenDem,ho,email,diaChi,sdt,ngaySinh,trangThai"
                + ",matKhau,idChucVu,ngayTao,ngaySua "
                + "from NhanVien where maNV = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.setId(rs.getString("id"));
                nv.setMaNV(maNV);
                nv.setTen(rs.getString("ten"));
                nv.setTenDem(rs.getString("tenDem"));
                nv.setHo(rs.getString("ho"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setTrangThai(rs.getInt("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setIdChucVu(rs.getInt("idChucVu"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public List<NhanVien> getListGV() {
        String query = "select id,maNV,ho,ten,tendem,email,diaChi,sdt,ngaySinh,"
                + "trangThai,matKhau,idChucVu,ngayTao,ngaySua "
                + "from NhanVien Where idChucVu = 0";
        List<NhanVien> listGV = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getString("id"));
                nv.setMaNV(rs.getString("maNV"));
                nv.setTen(rs.getString("ten"));
                nv.setTenDem(rs.getString("tenDem"));
                nv.setHo(rs.getString("ho"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setTrangThai(rs.getInt("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setIdChucVu(rs.getInt("idChucVu"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
                listGV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listGV;
    }

    public boolean addGV(NhanVien nv) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([maNV]\n"
                + "           ,[ho]\n"
                + "           ,[tenDem]\n"
                + "           ,[ten]\n"
                + "           ,[email]\n"
                + "           ,[diaChi]\n"
                + "           ,[sdt]\n"
                + "           ,[ngaySinh]\n"
                + "           ,[trangThai]\n"
                + "           ,[matKhau]\n"
                + "           ,[idChucVu]\n"
                + "           ,[ngayTao]\n"
                + "           ,[ngaySua])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getHo());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getTen());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(8, nv.getNgaySinh());
            ps.setObject(7, nv.getSdt());
            ps.setObject(9, nv.getTrangThai());
            ps.setObject(10, "1234");
            ps.setObject(11, 0);
            ps.setObject(12, date);
            ps.setObject(13, date);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateGV(NhanVien nv, String maNV) {
        int check = 0;
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        String query = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [maNV] = ?\n"
                + "      ,[ho] = ?\n"
                + "      ,[tenDem] = ?\n"
                + "      ,[ten] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[diaChi] = ?\n"
                + "      ,[sdt] = ?\n"
                + "      ,[ngaySinh] = ?\n"
                + "      ,[trangThai] = ?\n"
                + "      ,[matKhau] = ?\n"
                + "      ,[ngaySua] = ?\n"
                + " WHERE maNV = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getHo());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getTen());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getSdt());
            ps.setObject(8, nv.getNgaySinh());
            ps.setObject(9, 0);
            ps.setObject(10, nv.getMatKhau());
            ps.setObject(11, date);
            ps.setObject(12, maNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteGV(String maGV) {
        int check = 0;
        String query = "Delete NhanVien Where maNV = ? and idChucVu = 0";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maGV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<NhanVien> getListNV() {
        String query = "select id,maNV,ho,ten,tendem,email,diaChi,sdt,ngaySinh,"
                + "trangThai,matKhau,idChucVu,ngayTao,ngaySua "
                + "from NhanVien";
        List<NhanVien> listNV = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getString("id"));
                nv.setMaNV(rs.getString("maNV"));
                nv.setTen(rs.getString("ten"));
                nv.setTenDem(rs.getString("tenDem"));
                nv.setHo(rs.getString("ho"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setTrangThai(rs.getInt("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setIdChucVu(rs.getInt("idChucVu"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
                listNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listNV;
    }

    public static void main(String[] args) {
//        String maNV = "NV03";
//        NhanVien nv = new NhanVienAdminRepository().getOneAdmin(maNV);
//        System.out.println(nv.getHo());
        List<NhanVien> list = new NhanVienAdminRepository().getListGV();
        list.forEach(l -> System.out.printf("\n%s - %s\n", l.getHo(), l.getTen()));
    }
}
