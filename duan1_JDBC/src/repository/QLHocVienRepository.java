/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

/**
 *
 * @author Tran Duc Do
 */
import Utilities.SQLConnection;
import java.util.ArrayList;
import java.util.List;
import model.HocVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QLHocVienRepository {

    public List<HocVien> GetAllDaTa() {
        String Query = "SELECT id, maHV, ho, tenDem, ten, email, diaChi, sdt, ngaySinh, trangThai, matKhau, ngayTao, ngaySua\n"
                + " ,anh,gioiTinh FROM  HocVien ";
        List<HocVien> hocVien = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement pr = conn.prepareStatement(Query)) {
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                HocVien hv = new HocVien();
                hv.setIdHocVien(rs.getString("id"));
                hv.setMaHV(rs.getString("maHV"));
                hv.setHo(rs.getString("ho"));
                hv.setTenDem(rs.getString("tenDem"));
                hv.setTen(rs.getString("ten"));
                hv.setEmail(rs.getString("email"));
                hv.setDiaChi(rs.getString("diaChi"));
                hv.setSdt(rs.getString("sdt"));
                hv.setNgaySinh(rs.getDate("ngaySinh"));
                hv.setTrangThai(rs.getInt("trangThai"));
                hv.setMatKhau(rs.getString("matKhau"));
                hv.setNgayTao(rs.getDate("ngayTao"));
                hv.setNgaySua(rs.getDate("ngaySua"));
                hv.setImg(rs.getString("anh"));
                hv.setGioiTinh(rs.getBoolean("gioiTinh"));
                hocVien.add(hv);
            }
        } catch (Exception e) {
        }
        return hocVien;
    }

    public boolean addhv(HocVien hocVien) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "INSERT INTO HocVien\n"
                + "(maHV, ho, tenDem, ten, email, diaChi, sdt, ngaySinh, "
                + "trangThai, matKhau, ngayTao, ngaySua , anh , gioiTinh)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement pr = conn.prepareStatement(query)) {

            pr.setObject(1, hocVien.getMaHV());
            pr.setObject(2, hocVien.getHo());
            pr.setObject(3, hocVien.getTenDem());
            pr.setObject(4, hocVien.getTen());
            pr.setObject(5, hocVien.getEmail());
            pr.setObject(6, hocVien.getDiaChi());
            pr.setObject(7, hocVien.getSdt());
            pr.setObject(8, hocVien.getNgaySinh());
            pr.setObject(9, 0);
            pr.setObject(10, "1234");
            pr.setObject(11, date);
            pr.setObject(12, date);
            pr.setObject(13, hocVien.getImg());
            pr.setObject(14, hocVien.isGioiTinh());
            check = pr.executeUpdate();

        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean updateHv(HocVien hocVien, String ma) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "UPDATE HocVien\n"
                + "SET  maHV =?, ho =?, tenDem =?, ten =?, email =?, diaChi =?,"
                + " sdt =?, ngaySinh =?, trangThai =?, matKhau =?, ngaySua =? "
                + ", anh = ? , gioiTinh = ? where maHV = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement pr = conn.prepareStatement(query)) {
            pr.setObject(1, hocVien.getMaHV());
            pr.setObject(2, hocVien.getHo());
            pr.setObject(3, hocVien.getTenDem());
            pr.setObject(4, hocVien.getTen());
            pr.setObject(5, hocVien.getEmail());
            pr.setObject(6, hocVien.getDiaChi());
            pr.setObject(7, hocVien.getSdt());
            pr.setObject(8, hocVien.getNgaySinh());
            pr.setObject(9, 0);
            pr.setObject(10, "1234");
            pr.setObject(11, date);
            pr.setObject(12, hocVien.getImg());
            pr.setObject(13, hocVien.isGioiTinh());
            pr.setObject(14, ma);

            check = pr.executeUpdate();

        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean deleteLHV(String idHV) {
        int check = 0;
        String query = "Delete LopHocVien Where idHocVien = ?";
        try ( Connection con = SQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, idHV);
            check = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return check > 0;
    }

    public boolean updateKQHT(String idHV) {
        int check = 0;
        String query = "";
        try ( Connection con = SQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, idHV);
            check = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return check > 0;
    }

    public boolean Delete(String ma) {
        String query = "DELETE FROM [dbo].[HocVien]\n"
                + "      WHERE maHV = ?";
        int check = 0;
        try ( Connection con = SQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteVi(String id) {
        int check = 0;
        String query = "Delete Vi where idHocVien = ?";
        try ( Connection con = SQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteDHP(String id) {
        int check = 0;
        String query = "Delete DongHocPhi where idHocVien = ?";
        try ( Connection con = SQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteDKHocLai(String id) {
        int check = 0;
        String query = "Delete DangKiHocLai where idHocVien = ?";
        try ( Connection con = SQLConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean addVi(String idHV) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "INSERT INTO [dbo].[Vi]\n"
                + "           ([idHocVien]\n"
                + "           ,[soDuVi]\n"
                + "           ,[ngayTao]\n"
                + "           ,[ngaySua]\n"
                + "           ,[trangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ps.setObject(2, 0);
            ps.setObject(3, date);
            ps.setObject(4, date);
            ps.setObject(5, 0);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public HocVien getOne(String maHV) {
        String Query = "SELECT id, maHV, ho, tenDem, ten, email, diaChi, sdt, ngaySinh, trangThai, matKhau, ngayTao, ngaySua\n"
                + " ,anh,gioiTinh FROM  HocVien where maHV = ?";
        HocVien hv = new HocVien();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement pr = conn.prepareStatement(Query)) {
            pr.setObject(1, maHV);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                hv.setIdHocVien(rs.getString("id"));
                hv.setMaHV(rs.getString("maHV"));
                hv.setHo(rs.getString("ho"));
                hv.setTenDem(rs.getString("tenDem"));
                hv.setTen(rs.getString("ten"));
                hv.setEmail(rs.getString("email"));
                hv.setDiaChi(rs.getString("diaChi"));
                hv.setSdt(rs.getString("sdt"));
                hv.setNgaySinh(rs.getDate("ngaySinh"));
                hv.setTrangThai(rs.getInt("trangThai"));
                hv.setMatKhau(rs.getString("matKhau"));
                hv.setNgayTao(rs.getDate("ngayTao"));
                hv.setNgaySua(rs.getDate("ngaySua"));
                hv.setImg(rs.getString("anh"));
                hv.setGioiTinh(rs.getBoolean("gioiTinh"));
            }
        } catch (Exception e) {
        }
        return hv;
    }

    public boolean deleteKqht(String idHV) {
        int check = 0;
        String query = "Delete from KetQuaHT where idHocVien = ? ";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteLopHV(String idHV) {
        int check = 0;
        String query = "Delete from LopHocVien where idHocVien = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<HocVien> hv = new QLHocVienRepository().GetAllDaTa();

    }

}
