/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.math.BigDecimal;
import utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DongHocPhi;
import model.HocVien;
import model.MonHoc;
import model.NhanVien;
import viewmodel.DongHoc;
import viewmodel.KetQuaHTHV;
import viewmodel.hocPhi;
import viewmodel.monHocLai;

/**
 *
 * @author Dell
 */
public class loginRepo {

    public List<NhanVien> getALLNV() {
        String query = "select id,manv,ho,tenDem,ten,email,diachi,sdt,ngaySinh,trangThai,matKhau,idChucVu,ngayTao\n"
                + ",ngaySua,gioiTinh,anh\n"
                + "from nhanvien";
        List<NhanVien> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getString("id"));
                nv.setMaNV(rs.getString("manv"));
                nv.setHo(rs.getString("ho"));
                nv.setTenDem(rs.getString("tenDem"));
                nv.setTen(rs.getString("ten"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setTrangThai(rs.getInt("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setIdChucVu(rs.getInt("idChucVu"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                nv.setImg(rs.getString("anh"));
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;

    }

    public List<HocVien> getALLHV() {
        String query = "select id,maHV,ho,tenDem,ten,email,diachi,sdt,ngaySinh,trangThai,matKhau,ngayTao\n"
                + ",ngaySua,gioiTinh,anh\n"
                + "from HocVien";
        List<HocVien> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocVien nv = new HocVien();
                nv.setIdHocVien(rs.getString("id"));
                nv.setMaHV(rs.getString("maHV"));
                nv.setHo(rs.getString("ho"));
                nv.setTenDem(rs.getString("tenDem"));
                nv.setTen(rs.getString("ten"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setTrangThai(rs.getInt("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                nv.setImg(rs.getString("anh"));
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
        String query = "select id from NhanVien where maNV = ?";
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

    public String getIDHocVien(String maHV) {
        String id = null;
        String query = "select id from HocVien where MaHV = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maHV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public boolean updatePassHocVien(String newPass, String maNV) {
        int check = 0;
        String query = "Update HocVien Set matKhau = ? where  maHV = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, newPass);
            ps.setObject(2, maNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<KetQuaHTHV> getKQHT(String maHV) {
        String query = "select hocky.hocKy,MonHoc.tenMon,Lop.maLop,Ketquaht.diemGiuaKy,diemTongKet,danhGia,ketquaHT.trangThai\n"
                + "	   from KetQuaHT  join MonHoc on KetQuaHT.idMonHoc = MonHoc.id\n"
                + "	   join HocKy on MonHoc.idHocKy = hocKy.idHocKy\n"
                + "	   join HocVien on KetQuaHT.idHocVien = HocVien.id\n"
                + "	   join Lop on MonHoc.id = Lop.idMonHoc\n"
                + "	   where HocVien.maHV = ?";
        List<KetQuaHTHV> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maHV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KetQuaHTHV kt = new KetQuaHTHV();
                kt.setHocKy(rs.getInt(1));
                kt.setTenMon(rs.getString(2));
                kt.setTenLop(rs.getString(3));
                kt.setDiemGK(rs.getFloat(4));
                kt.setDiemTK(rs.getFloat(5));
                kt.setDanhGia(rs.getString(6));
                kt.setTrangThai(rs.getInt(7));
                list.add(kt);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<monHocLai> getHocLai(String maHV) {
        String query = " select MonHoc.id,MonHoc.tenMon,Lop.maLop,Monhoc.hocPhi,vi.soduvi\n"
                + "from KetQuaHT  join MonHoc on KetQuaHT.idMonHoc = MonHoc.id\n"
                + "join HocKy on MonHoc.idHocKy = hocKy.idHocKy\n"
                + "join HocVien on KetQuaHT.idHocVien = HocVien.id\n"
                + "join Lop on MonHoc.id = Lop.idMonHoc\n"
                + "join vi on HocVien.id = Vi.idHocVien\n"
                + "where HocVien.maHV = ? and ketquaht.trangthai = 2";
        List<monHocLai> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maHV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                monHocLai dk = new monHocLai();
                dk.setIdMonHoc(rs.getString("id"));
                dk.setMaHV(maHV);
                dk.setTenMon(rs.getString("tenMon"));
                dk.setTenLop(rs.getString("maLop"));
                dk.setTienHocLai(rs.getBigDecimal("hocPhi"));
                dk.setSoDuVi(rs.getBigDecimal("soDuVi"));

                list.add(dk);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<hocPhi> getALLHocPhi(String maHV) {
        String query = "select MonHoc.id,hocky.hocky,monhoc.tenMon,MonHoc.hocPhi,DongHocPhi.trangThai,Vi.soDuVi\n"
                + "from DongHocPhi join HocVien on DongHocPhi.idHocVien = HocVien.id\n"
                + "join monhoc on DongHocPhi.idMonHoc = MonHoc.id\n"
                + "join HocKy on MonHoc.idHocKy = hocKy.idHocKy\n"
                + "join Vi on HocVien.id = Vi.idHocVien\n"
                + " where HocVien.maHV = ? and DongHocPhi.trangThai = 0 ";
        List<hocPhi> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maHV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hocPhi mh = new hocPhi();
                mh.setIdMonHoc(rs.getString(1));
                mh.setHocKy(rs.getInt("HocKy"));
                mh.setTenMon(rs.getString("TenMon"));
                mh.setHocPhi(rs.getBigDecimal("hocPhi"));
                mh.setTrangThai(rs.getInt("trangThai"));
                mh.setSoDuVi(rs.getBigDecimal("soDuVi"));
                list.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean thanhToanHocPhi(BigDecimal tienHocPhi, String idHV, String idMonHoc) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        String query = "INSERT INTO [dbo].[DongHocPhi]\n"
                + "           (\n"
                + "           [idHocVien]\n"
                + "           ,[idMonHoc]\n"
                + "           ,[ngayDong]\n"
                + "           ,[tienDong]\n"
                + "           ,[trangThai]\n"
                + "           ,[ngayTao]\n"
                + "           ,[ngaySua])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?) ";
        int check = 0;
        try (Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ps.setObject(2, idMonHoc);
            ps.setObject(3, date);
            ps.setObject(4, tienHocPhi);
            ps.setObject(5, 1);
            ps.setObject(6, date);
            ps.setObject(7, date);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean thanhToanHocPhi1(BigDecimal tienHocPhi, String idHV, String idMonHoc) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        String query = "INSERT INTO [dbo].[DongHocPhi]\n"
                + "           (\n"
                + "           [idHocVien]\n"
                + "           ,[idMonHoc]\n"
                + "           ,[ngayDong]\n"
                + "           ,[tienDong]\n"
                + "           ,[trangThai]\n"
                + "           ,[ngayTao]\n"
                + "           ,[ngaySua])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)  ";
        int check = 0;

        try (Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ps.setObject(2, idMonHoc);
            ps.setObject(3, date);
            ps.setObject(4, tienHocPhi);
            ps.setObject(5, 1);
            ps.setObject(6, date);
            ps.setObject(7, date);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateSoDuVi(BigDecimal tienHocPhi, String idHocVien) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        String query = "update Vi \n"
                + "set soDuVi = soDuVi - ? \n,"
                + "ngaySua = ? "
                + "where idHocVien = ? ";
        int check = 0;
        try (Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, tienHocPhi);
            ps.setObject(2, date);
            ps.setObject(3, idHocVien);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public BigDecimal getSoDuVi(String idHV) {
        String query = "select soDuVi from Vi "
                + "where idHocVien = ? ";
        BigDecimal soDuVi = null;
        try (Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soDuVi = rs.getBigDecimal("soDuVi");

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return soDuVi;
    }

    public List<DongHocPhi> listDongPhi(String idHV) {
        String query = "select idDongHP,idHocVien,idMonHoc,ngayDong,tienDong,trangThai,ngayTao,ngaySua \n"
                + "from DongHocPhi \n"
                + "where idHocVien = ? and trangThai= 1 ";
        List<DongHocPhi> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongHocPhi dp = new DongHocPhi();
                dp.setIdDongHP(rs.getString("idDongHP"));
                dp.setIdHocVien(idHV);
                dp.setIdMonHoc(rs.getString("idMonHoc"));
                dp.setNgayDong(rs.getDate("ngayDong"));
                dp.setTienDong(rs.getBigDecimal("tienDong"));
                dp.setTrangThai(rs.getInt("trangThai"));
                dp.setNgayTao(rs.getDate("ngayTao"));
                dp.setNgaySua(rs.getDate("ngaySua"));
                list.add(dp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<DongHoc> listDH(String idHV) {
        String query = "select idDongHP,idHocVien,idMonHoc,ngayDong,tienDong,dongHocPhi.trangThai,"
                + "dongHocPhi.ngayTao,dongHocPhi.ngaySua,MonHoc.tenMon \n"
                + "from DongHocPhi join MonHoc on dongHocPhi.idMonHoc = MonHoc.id \n"
                + "where idHocVien = ? and dongHocPhi.trangThai= 1 ";
        List<DongHoc> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongHoc dp = new DongHoc();
                dp.setIdDongHP(rs.getString("idDongHP"));
                dp.setIdHocVien(idHV);
                dp.setIdMonHoc(rs.getString("idMonHoc"));
                dp.setNgayDong(rs.getDate("ngayDong"));
                dp.setTienDong(rs.getBigDecimal("tienDong"));
                dp.setTrangThai(rs.getInt("trangThai"));
                dp.setNgayTao(rs.getDate("ngayTao"));
                dp.setNgaySua(rs.getDate("ngaySua"));
                dp.setTenMon(rs.getString("tenMon"));
                list.add(dp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<DongHoc> getIDMonHoc(String idHV) {
        String query = "select idMonHoc  from DongHocPhi \n"
                + "where idHocVien = ? ";
        List<DongHoc> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongHoc dp = new DongHoc();
                dp.setIdMonHoc(rs.getString("idMonHoc"));
                dp.setIdHocVien(idHV);
                list.add(dp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<DongHoc> listDKHL(String idHV) {
        String query = "select idDongHP,idHocVien,idMonHoc,ngayDong,tienDong,dongHocPhi.trangThai,"
                + "dongHocPhi.ngayTao,dongHocPhi.ngaySua,MonHoc.tenMon \n"
                + "from DongHocPhi join MonHoc on dongHocPhi.idMonHoc = MonHoc.id \n"
                + "where idHocVien = ? and dongHocPhi.trangThai= 2 ";
        List<DongHoc> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongHoc dp = new DongHoc();
                dp.setIdDongHP(rs.getString("idDongHP"));
                dp.setIdHocVien(idHV);
                dp.setIdMonHoc(rs.getString("idMonHoc"));
                dp.setNgayDong(rs.getDate("ngayDong"));
                dp.setTienDong(rs.getBigDecimal("tienDong"));
                dp.setTrangThai(rs.getInt("trangThai"));
                dp.setNgayTao(rs.getDate("ngayTao"));
                dp.setNgaySua(rs.getDate("ngaySua"));
                dp.setTenMon(rs.getString("tenMon"));
                list.add(dp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean updateHocVien(String id) {
        String query = "UPDATE [dbo].[HocVien]\n"
                + "   SET\n"
                + "      [trangThai] = ?,\n"
                + "      [ngaySua] = ?\n"
                + "\n"
                + " WHERE id = ?";
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        try (Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, 1);
            ps.setObject(2, date);
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<MonHoc> listMonHoc(int row) {
        String query = "Select id ,idHocKy,tenMon,hocPhi,thoiLuong,trangThai,ngayTao,ngaySua "
                + "from MonHoc "
                + "where trangThai = 0"
                + "order by tenMon asc "
                + "offset ? rows "
                + "fetch next 5 rows only ";
        List<MonHoc> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, row);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc hoc = new MonHoc();
                hoc.setId(rs.getString("id"));
                hoc.setIdHocKy(rs.getString("idHocKy"));
                hoc.setTenMon(rs.getString("tenMon"));
                hoc.setHocPhi(rs.getBigDecimal("hocPhi"));
                hoc.setThoiLuong(rs.getInt("thoiLuong"));
                hoc.setTrangThai(rs.getInt("trangThai"));
                hoc.setNgayTao(rs.getDate("ngayTao"));
                hoc.setNgaySua(rs.getDate("ngaySua"));
                list.add(hoc);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<MonHoc> listMonHoc1() {
        String query = "Select tenMon , hocPhi "
                + "from MonHoc "
                + "order by tenMon asc ";
        List<MonHoc> list = new ArrayList<>();
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc dp = new MonHoc();
                dp.setTenMon(rs.getString("tenMon"));
                dp.setHocPhi(rs.getBigDecimal("hocPhi"));
                list.add(dp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<MonHoc> findByFullname(String fullname) {
        List<MonHoc> listAllMH = new ArrayList<>();
        String query = "Select id ,idHocKy,tenMon,hocPhi,thoiLuong,trangThai,ngayTao,ngaySua "
                + "from MonHoc where tenMon like ? ";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, "%" + fullname + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc hoc = new MonHoc();
                hoc.setId(rs.getString("id"));
                hoc.setIdHocKy(rs.getString("idHocKy"));
                hoc.setTenMon(rs.getString("tenMon"));
                hoc.setHocPhi(rs.getBigDecimal("hocPhi"));
                hoc.setThoiLuong(rs.getInt("thoiLuong"));
                hoc.setTrangThai(rs.getInt("trangThai"));
                hoc.setNgayTao(rs.getDate("ngayTao"));
                hoc.setNgaySua(rs.getDate("ngaySua"));
                listAllMH.add(hoc);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listAllMH;
    }

    // nạp tiền vào ví
    public boolean napTien(String idHV, BigDecimal tienNap) {
        String query = "UPDATE [dbo].[Vi]\n"
                + "   SET \n"
                + "      [soDuVi] = soDuVi + ?\n"
                + "      ,[ngaySua] = ?\n"
                + "      ,[trangThai] = ?\n"
                + " WHERE idHocVien = ? ";
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        try (Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, tienNap);
            ps.setObject(2, date);
            ps.setObject(3, 1);
            ps.setObject(4, idHV);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public HocVien getOneHV(String maHV) {
        HocVien nv = new HocVien();
        String query = "select id,ten,tenDem,ho,email,diaChi,sdt,ngaySinh,trangThai"
                + ",matKhau,ngayTao,ngaySua "
                + "from HocVien where maHV = ?";
        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maHV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nv.setIdHocVien(rs.getString("id"));
                nv.setMaHV(maHV);
                nv.setTen(rs.getString("ten"));
                nv.setTenDem(rs.getString("tenDem"));
                nv.setHo(rs.getString("ho"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setTrangThai(rs.getInt("trangThai"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public static void main(String[] args) {
        String mahV = "mahv001";
        String id = new loginRepo().getIDHocVien(mahV);
        System.out.println(id);
        List<DongHocPhi> list = new loginRepo().listDongPhi(id);
        list.forEach(l-> System.out.printf("%f \n",l.getTienDong()));
    }
}
