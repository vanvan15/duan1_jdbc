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
import model.CaHoc;
import model.HocKy;
import model.Lop;
import model.MonHoc;
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

    public List<Lop> getListLop() {
        List<Lop> listL = new ArrayList<>();
        String query = "select id,idGiangVien,maLop,tenLop,slHocVien,slToiDa,"
                + "idCa,idMonHoc,trangThai,ngayTao,ngaySua from Lop";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lop l = new Lop();
                l.setId(rs.getString("id"));
                l.setIdGiangVien(rs.getString("idGiangVien"));
                l.setMalop(rs.getString("maLop"));
                l.setTenLop(rs.getString("tenLop"));
                l.setSlHocVien(rs.getInt("slHocVien"));
                l.setSlToiDa(rs.getInt("slToiDa"));
                l.setIdCa(rs.getString("idCa"));
                l.setIdMonHoc(rs.getString("idMonHoc"));
                l.setTrangThai(rs.getInt("trangThai"));
                l.setNgayTao(rs.getDate("ngayTao"));
                l.setNgaySua(rs.getDate("ngaySua"));
                listL.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return listL;
    }

    public List<CaHoc> getListCaHoc() {
        List<CaHoc> listCaHoc = new ArrayList<>();
        String query = "select id,maCa,thoiGian,trangThai,ngayTao,ngaySua from Cahoc";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CaHoc ch = new CaHoc();
                ch.setId(rs.getString("id"));
                ch.setMaCa(rs.getString("maCa"));
                ch.setThoiGian(rs.getString("thoiGian"));
                ch.setTrangThai(rs.getInt("trangThai"));
                ch.setNgayTao(rs.getDate("ngayTao"));
                ch.setNgaySua(rs.getDate("ngaySua"));
                listCaHoc.add(ch);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listCaHoc;
    }

    public List<MonHoc> getListMonHoc() {
        List<MonHoc> listMonHoc = new ArrayList<>();
        String query = "select id,idHocKy,tenMon,hocPhi,thoiLuong,trangThai,ngayTao,ngaySua from MonHoc";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setId(rs.getString("id"));
                mh.setIdHocKy(rs.getString("idHocKy"));
                mh.setTenMon(rs.getString("tenMon"));
                mh.setHocPhi(rs.getBigDecimal("hocPhi"));
                mh.setThoiLuong(rs.getInt("thoiLuong"));
                mh.setTrangThai(rs.getInt("trangThai"));
                mh.setNgayTao(rs.getDate("ngayTao"));
                mh.setNgaySua(rs.getDate("ngaySua"));
                listMonHoc.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listMonHoc;
    }

    public List<HocKy> getListHocKy() {
        List<HocKy> listK = new ArrayList<>();
        String query = "select idHocKy,hocKy,moTa,thoiLuong,trangThai,"
                + "ngayTao,ngaySua from HocKy";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocKy h = new HocKy();
                h.setIdHocKy(rs.getString("idHocKy"));
                h.setHocKy(rs.getInt("hocKy"));
                h.setMoTa(rs.getString("moTa"));
                h.setThoiLuong(rs.getString("thoiLuong"));
                h.setTrangThai(rs.getInt("trangThai"));
                h.setNgayTao(rs.getDate("ngayTao"));
                h.setNgaySua(rs.getDate("ngaySua"));
                listK.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listK;
    }

    public HocKy getHocKy(String id) {
        String query = "select idHocKy,hocKy,moTa,thoiLuong,trangThai,"
                + "ngayTao,ngaySua from HocKy where idHocKy = ?";
        HocKy h = new HocKy();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h.setIdHocKy(rs.getString("idHocKy"));
                h.setHocKy(rs.getInt("hocKy"));
                h.setMoTa(rs.getString("moTa"));
                h.setThoiLuong(rs.getString("thoiLuong"));
                h.setTrangThai(rs.getInt("trangThai"));
                h.setNgayTao(rs.getDate("ngayTao"));
                h.setNgaySua(rs.getDate("ngaySua"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return h;
    }

    public String getIdHocKi(int hocki) {
        String id = null;
        String query = "select idHocKy from HocKy Where hocKy = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, hocki);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("idHocKy");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public boolean updateMonHoc(String id, MonHoc mh) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "UPDATE [dbo].[MonHoc]\n"
                + "   SET [idHocKy] = ?\n"
                + "      ,[tenMon] = ?\n"
                + "      ,[hocPhi] = ?\n"
                + "      ,[thoiLuong] = ?\n"
//              + "           ,[trangThai]\n"
                + "      ,[ngaySua] = ?\n"
                + " WHERE id = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, mh.getIdHocKy());
            ps.setObject(2, mh.getTenMon());
            ps.setObject(3, mh.getHocPhi());
            ps.setObject(4, mh.getThoiLuong());
            ps.setObject(5, date);
            ps.setObject(6, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean addMonHoc(MonHoc mh) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "INSERT INTO [dbo].[MonHoc]\n"
                + "           ([idHocKy]\n"
                + "           ,[tenMon]\n"
                + "           ,[hocPhi]\n"
                + "           ,[thoiLuong]\n"
//                + "           ,[trangThai]\n"
                + "           ,[ngayTao]\n"
                + "           ,[ngaySua])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, mh.getIdHocKy());
            ps.setObject(2, mh.getTenMon());
            ps.setObject(3, mh.getHocPhi());
            ps.setObject(4, mh.getThoiLuong());
            ps.setObject(5, date);
            ps.setObject(6, date);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public boolean deleteMonHoc(String idMonHoc){
        int check = 0 ;
        String query = "Delete From MonHoc Where id = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idMonHoc);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public static void main(String[] args) {
//        String maNV = "NV03";
//        NhanVien nv = new NhanVienAdminRepository().getOneAdmin(maNV);
//        System.out.println(nv.getHo());
//        List<NhanVien> list = new NhanVienAdminRepository().getListGV();
//        list.forEach(l -> System.out.printf("\n%s - %s\n", l.getHo(), l.getTen()));
//        List<HocKy> list = new NhanVienAdminRepository().getListHocKy();
//        list.forEach(l-> System.out.printf("\n%d",l.getHocKy()));
//        String id = "73023F9D-E4AA-40E5-8EC2-218619B3CC77";
//        HocKy h = new NhanVienAdminRepository().getHocKy(id);
//        System.out.println(h.getHocKy());
//        int hk = 1;
//        String id = new NhanVienAdminRepository().getIdHocKi(hk);
//        System.out.println(id);
    }
}
