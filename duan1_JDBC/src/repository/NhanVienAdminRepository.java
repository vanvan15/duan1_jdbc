/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model.CaHoc;
import model.DongHocPhi;
import model.HocKy;
import model.HocVien;
import model.LichHoc;
import model.Lop;
import model.LopHocVien;
import model.MonHoc;
import model.NhanVien;
import utilities.DBContext;
import viewmodel.thongKeViewModel1;
import viewmodel.thongKeViewModel2;

/**
 *
 * @author acer
 */
public class NhanVienAdminRepository {

    public boolean updatePassAdmin(String newPass, String maNV) {
        int check = 0;
        String query = "Update NhanVien Set matKhau = ? where idChucVu = 1 and maNV = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, newPass);
            ps.setObject(2, maNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateTTHV(String idHV) {
        int check = 0;
        String query = "Update HocVien Set trangThai = 1 where id = ? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<MonHoc> listSearchMonHoc(String text) {
        List<MonHoc> list = new ArrayList<>();
        String query = "select id,idHocKy,tenMon,hocPhi,thoiLuong from MonHoc where tenMon like N'%"
                + text + "%'";
        try ( Connection conn =DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setId(rs.getString("id"));
                mh.setIdHocKy(rs.getString("idHocKy"));
                mh.setTenMon(rs.getString("tenMon"));
                mh.setHocPhi(rs.getBigDecimal("hocPhi"));
                mh.setThoiLuong(rs.getInt("thoiLuong"));
                list.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<DongHocPhi> getListPTDHP(int pageIndex, int pageNumber) {
        List<DongHocPhi> list = new ArrayList<>();
        String query = "Exec Paging3 ?,? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, pageIndex);
            ps.setObject(2, pageNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongHocPhi dhp = new DongHocPhi();
                dhp.setIdDongHP(rs.getString("idDongHP"));
                dhp.setIdHocVien(rs.getString("idHocVien"));
                dhp.setIdMonHoc(rs.getString("idMonHoc"));
                dhp.setNgayDong(rs.getDate("ngayDong"));
                dhp.setTienDong(rs.getBigDecimal("tienDong"));
                list.add(dhp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<DongHocPhi> getListDHP() {
        List<DongHocPhi> list = new ArrayList<>();
        String query = "select idDongHP,idHocVien,idMonHoc,ngayDong,tienDong,trangThai from DongHocPhi";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongHocPhi dhp = new DongHocPhi();
                dhp.setIdDongHP(rs.getString("idDongHP"));
                dhp.setIdHocVien(rs.getString("idHocVien"));
                dhp.setIdMonHoc(rs.getString("idMonHoc"));
                dhp.setNgayDong(rs.getDate("ngayDong"));
                dhp.setTienDong(rs.getBigDecimal("tienDong"));
                dhp.setTrangThai(rs.getInt("trangThai"));
                list.add(dhp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean addDHP(DongHocPhi dhp) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "INSERT INTO [dbo].[DongHocPhi]\n"
                + "           ([idHocVien]\n"
                + "           ,[idMonHoc]\n"
                + "           ,[ngayDong]\n"
                + "           ,[tienDong]\n"
                + "           ,[trangThai]\n"
                + "           ,[ngayTao])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, dhp.getIdHocVien());
            ps.setObject(2, dhp.getIdMonHoc());
            ps.setObject(3, date);
            ps.setObject(4, dhp.getTienDong());
            ps.setObject(5, 1);
            ps.setObject(6, date);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<HocVien> listPTHocVien(int pageIndex, int pageNumber) {
        String query = "Exec Paging1 ?,? ";
        List<HocVien> listHV = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, pageIndex);
            ps.setObject(2, pageNumber);
            ResultSet rs = ps.executeQuery();
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
                hv.setImg(rs.getString("anh"));
                hv.setGioiTinh(rs.getBoolean("gioiTinh"));
                listHV.add(hv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listHV;
    }

    public List<MonHoc> listPTMonHoc(int pageIndex, int pageNumber) {
        String query = "Exec Paging2 ?,? ";
        List<MonHoc> listMH = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, pageIndex);
            ps.setObject(2, pageNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setId(rs.getString("id"));
                mh.setIdHocKy(rs.getString("idHocKy"));
                mh.setTenMon(rs.getString("tenMon"));
                mh.setHocPhi(rs.getBigDecimal("hocPhi"));
                mh.setThoiLuong(rs.getInt("thoiLuong"));
                listMH.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listMH;
    }

    public List<HocVien> getAllHocVien() {
        String Query = "SELECT id, maHV, ho, tenDem, ten, email, diaChi, sdt, ngaySinh, trangThai, matKhau, ngayTao, ngaySua\n"
                + " ,anh,gioiTinh FROM  HocVien ";
        List<HocVien> listHV = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement pr = conn.prepareStatement(Query)) {
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
                listHV.add(hv);
            }
        } catch (Exception e) {
        }
        return listHV;
    }

    public boolean updateTTDHP(String idHocVien, String idMH) {
        int check = 0;
        String query = "Update DongHocPhi Set trangThai = 2 where idHocVien = ? \n"
                + " and idMonHoc = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHocVien);
            ps.setObject(2, idMH);
            check = ps.executeUpdate();
        } catch (Exception e) {
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
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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

    public boolean deleteLichHoc(LichHoc lh) {
        int check = 0;
        String query = "Delete From LichHoc Where id = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, lh.getId());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public NhanVien getOneAdmin(String maNV) {
        NhanVien nv = new NhanVien();
        String query = "select id,ten,tenDem,ho,email,diaChi,sdt,ngaySinh,trangThai"
                + ",anh,gioiTinh,matKhau,idChucVu,ngayTao,ngaySua "
                + "from NhanVien where maNV = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
                nv.setImg(rs.getString("anh"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public boolean deleteKqht(String idHV, String idMonHoc) {
        int check = 0;
        String query = "Delete from KetQuaHT where idHocVien = ? and idMonHoc = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ps.setObject(2, idMonHoc);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<LichHoc> getListLichHoc(String idLop) {
        String query = "Select id,idLop,ngayHoc,trangThai,ngayTao,ngaySua from LichHoc where idLop = ? \n"
                + " ORDER by day(ngayHoc),MONTH(ngayHoc) ,YEAR(ngayHoc) asc";
        List<LichHoc> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichHoc lh = new LichHoc();
                lh.setId(rs.getString("id"));
                lh.setIdLop(rs.getString("idLop"));
                lh.setTrangThai(rs.getInt("trangThai"));
                lh.setNgayHoc(rs.getDate("ngayHoc"));
                lh.setNgayTao(rs.getDate("ngayTao"));
                lh.setNgaySua(rs.getDate("ngaySua"));
                list.add(lh);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean checkLH(LichHoc lh) {
        boolean check = true;
        String query = "Select id,idLop,ngayHoc from LichHoc Where id = ? and idLop = ? "
                + " and ngayHoc = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, lh.getId());
            ps.setObject(2, lh.getIdLop());
            ps.setObject(3, lh.getNgayHoc());
            ResultSet rs = ps.executeQuery();
            check = rs.next();
        } catch (Exception e) {
        }
        return check;
    }

    public boolean updateLichHoc(LichHoc lh) {
        int check = 0;
        String query = "Update LichHoc Set ngayHoc = ? where id = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, lh.getNgayHoc());
            ps.setObject(2, lh.getId());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public boolean addLichHoc(LichHoc lh) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "INSERT INTO [dbo].[LichHoc]\n"
                + "           ([idLop]\n"
                + "           ,[ngayHoc]\n"
                + "           ,[trangThai]\n"
                + "           ,[ngayTao]\n"
                + "           ,[ngaySua])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, lh.getIdLop());
            ps.setObject(2, lh.getNgayHoc());
            ps.setObject(3, 0);
            ps.setObject(4, date);
            ps.setObject(5, date);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public MonHoc getMonHocByIdLop(String idLop) {
        String query = "select  mh.id,mh.idHocKy,mh.tenMon,mh.hocPhi,mh.thoiLuong,mh.trangThai\n"
                + "from LichHoc lh join Lop l on lh.idLop = l.id join MonHoc mh on l.idMonHoc = mh.id\n"
                + "where l.id = ?";
        MonHoc mh = new MonHoc();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mh.setId(rs.getString(1));
                mh.setIdHocKy(rs.getString(2));
                mh.setTenMon(rs.getString(3));
                mh.setHocPhi(rs.getBigDecimal(4));
                mh.setThoiLuong(rs.getInt(5));
                mh.setTrangThai(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return mh;
    }

    public CaHoc getCaHocByIdLop(String idLop) {
        String query = "select ch.id,ch.maCa,ch.thoiGian,ch.trangThai from LichHoc \n"
                + " lh join Lop l on lh.idLop = l.id join CaHoc ch on l.idCa = ch.id \n"
                + " where l.id = ?";
        CaHoc ch = new CaHoc();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ch.setId(rs.getString(1));
                ch.setMaCa(rs.getString(2));
                ch.setThoiGian(rs.getString(3));
                ch.setTrangThai(rs.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return ch;
    }

    public NhanVien getGVByIdLop(String idLop) {
        String query = "select nv.id,nv.maNV,nv.ho,nv.tenDem,nv.ten,nv.email,nv.diaChi,nv.sdt"
                + " ,nv.ngaySinh,nv.trangThai,nv.matKhau,nv.gioiTinh from NhanVien"
                + " nv join Lop l on nv.id = l.idGiangVien where l.id = ?";
        NhanVien nv = new NhanVien();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public boolean deleteLopHV(String idHV, String idLop) {
        int check = 0;
        String query = "Delete from LopHocVien where idHocVien = ? and idLop = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ps.setObject(2, idLop);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean addKqht(String idHV, String idMonHoc) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "insert into KetQuaHT (idHocVien,IdMonHoc,trangThai,ngayTao,ngaySua) "
                + "values (?,?,?,?,?) ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ps.setObject(2, idMonHoc);
            ps.setObject(3, 0);
            ps.setObject(4, date);
            ps.setObject(5, date);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean xoaPhanQuyen(String idLop) {
        int check = 0;
        String query = "Update Lop Set idGiangVien = null where id = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateLop(Lop l) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "UPDATE [dbo].[Lop]\n"
                + "   SET [maLop] = ? \n"
                + "      ,[tenLop] = ?\n"
                + "      ,[idCa] = ?\n"
                + "      ,[idMonHoc] = ?\n"
                + "      ,[trangThai] = ?\n"
                + "      ,[ngaySua] = ?\n"
                + " WHERE id = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, l.getMalop());
            ps.setObject(2, l.getTenLop());
            ps.setObject(3, l.getIdCa());
            ps.setObject(4, l.getIdMonHoc());
            ps.setObject(5, l.getTrangThai());
            ps.setObject(6, date);
            ps.setObject(7, l.getId());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteLop(String idLop) {
        int check = 0;
        String query = "delete Lop Where id = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteLopHV(String idLop) {
        int check = 0;
        String query = "delete LopHocVien Where idLop = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<HocVien> getHocVienByIdLop(String idLop) {
        String query = "select hv.id,hv.maHV,hv.ho,hv.tenDem,hv.ten,hv.email,hv.diaChi,hv.sdt,hv.ngaySinh,\n"
                + " hv.trangThai,hv.matKhau,hv.ngayTao,hv.ngaySua,hv.anh,hv.gioiTinh\n"
                + " from Lop l join LopHocVien lhv on l.id = lhv.idLop join HocVien hv on lhv.idHocVien = hv.id\n"
                + " where l.id = ? ";
        List<HocVien> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            ResultSet rs = ps.executeQuery();
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
                list.add(hv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public static void main(String[] args) {

    }

    public boolean updateTTLop(String idLop) {
        int check = 0;
        String query = "Update Lop Set trangThai = 1 where id = ? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public HocVien getHVById(String id) {
        String query = "select id,maHV,ho,tenDem,ten,email,diaChi,sdt"
                + " ,ngaySinh,trangThai,matKhau,ngayTao,ngaySua,anh,gioiTinh"
                + " from HocVien where id = ?";
        HocVien hv = new HocVien();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
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
            e.printStackTrace(System.out);
        }

        return hv;
    }

    public MonHoc getMHByID(String id) {
        MonHoc mh = new MonHoc();
        String query = "Select id,idHocKy,tenMon,hocPhi,thoiLuong,trangThai "
                + " From MonHoc Where id = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                mh.setId(rs.getString("id"));
                mh.setIdHocKy(rs.getString("idHocKy"));
                mh.setTenMon(rs.getString("tenMon"));
                mh.setHocPhi(rs.getBigDecimal("hocPhi"));
                mh.setThoiLuong(rs.getInt("thoiLuong"));
                mh.setTrangThai(rs.getInt("trangThai"));

            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return mh;
    }

    public List<HocVien> getHocVien1(String idMH) {
        String query = "select hv.id,hv.maHV,hv.ho,hv.tenDem,hv.ten,hv.email,hv.diaChi,\n"
                + "hv.sdt,hv.ngaySinh,hv.trangThai,hv.matKhau,hv.ngayTao,hv.ngaySua,hv.anh,hv.gioiTinh\n"
                + "from HocVien hv join DongHocPhi dhp on hv.id = dhp.idHocVien join MonHoc mh on\n"
                + "dhp.idMonHoc = mh.id\n"
                + "where mh.id = ? and dhp.trangThai = 1 and hv.trangThai = 1 ";
        List<HocVien> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idMH);
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

    public boolean addLopHv(LopHocVien lv) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "INSERT INTO [dbo].[LopHocVien]\n"
                + "           ([idLop]\n"
                + "           ,[idHocVien]\n"
                + "           ,[trangThai]\n"
                + "           ,[ngayTao]\n"
                + "           ,[ngaySua])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, lv.getIdLop());
            ps.setObject(2, lv.getIdHocVien());
            ps.setObject(3, 0);
            ps.setObject(4, date);
            ps.setObject(5, date);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateHV(String id) {
        int check = 0;
        String query = "Update HocVien Set trangThai = 2 where id = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteLH(String idLH) {
        int check = 0;
        String query = "Delete from LichHoc where id = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLH);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public BigDecimal tkTTForHV() {
        BigDecimal sumMoney = null;
        String query = "select distinct idhocvien,sum(tienDong) from DongHocPhi";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sumMoney = rs.getBigDecimal(1);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sumMoney;
    }

    public List<thongKeViewModel1> tKHPHV() {
        String query = "select distinct idhocvien,sum(tienDong) as 'TongTien' "
                + "from DongHocPhi group by idHocVien order by TongTien desc";
        List<thongKeViewModel1> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                thongKeViewModel1 tk = new thongKeViewModel1();
                tk.setIdHocVien(rs.getString("idHocVien"));
                tk.setTien(rs.getBigDecimal(2));
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<thongKeViewModel2> tKHPMH() {
        String query = "select distinct idMonHoc,sum(tienDong) as 'TongTien' "
                + "from DongHocPhi group by idMonHoc order by TongTien desc";
        List<thongKeViewModel2> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                thongKeViewModel2 tk = new thongKeViewModel2();
                tk.setIdMonHoc(rs.getString("idMonHoc"));
                tk.setTien(rs.getBigDecimal(2));
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<NhanVien> listSearchGV(String text) {
        String query = "Select id,maNV,ho,tenDem,ten,email,diaChi,sdt,ngaySinh,trangThai,"
                + " matKhau,anh,gioiTinh from NhanVien Where ten like '%" + text + "%'"
                + " or tenDem like '%" + text + "%'" + " or ho like '%" + text + "%'" + " and idChucVu = 0";
        List<NhanVien> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
                nv.setImg(rs.getString(12));
                nv.setGioiTinh(rs.getBoolean(13));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public List<NhanVien> listPTGV(int pageIndex, int pageNum) {
        String query = "exec Paging ?,? ";
        List<NhanVien> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, pageIndex);
            ps.setObject(2, pageNum);
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
                nv.setImg(rs.getString(12));
                nv.setGioiTinh(rs.getBoolean(13));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int tkSLHV() {
        List<HocVien> list = new ArrayList<>();
        String query = "select distinct idHocVien from DongHocPhi group by idHocVien";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocVien hv = new HocVien();
                hv.setIdHocVien(rs.getString("idHocVien"));
                list.add(hv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.size();
    }

    public BigDecimal thongKeTongTien() {
        BigDecimal sumMoney = null;
        String query = "select sum(tienDong) from DongHocPhi";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sumMoney = rs.getBigDecimal(1);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sumMoney;
    }

    public boolean updateTTDHP1(String idHV, String idMonHoc) {
        int check = 0;
        String query = "Update DongHocPhi Set trangThai = 1 where idHocVien = ? and idMonHoc = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ps.setObject(2, idMonHoc);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<LopHocVien> getListLopHV() {
        String query = "Select idLopHocVien,idLop,idHocVien,trangThai,"
                + " ngayTao,ngaySua from LopHocVien";
        List<LopHocVien> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopHocVien lhv = new LopHocVien();
                lhv.setIdLopHV(rs.getString("idLopHocVien"));
                lhv.setIdLop(rs.getString("idLop"));
                lhv.setIdHocVien(rs.getString("idHocVien"));
                lhv.setTrangThai(rs.getInt("trangThai"));
                lhv.setNgayTao(rs.getDate("ngayTao"));
                lhv.setNgaySua(rs.getDate("ngaySua"));
                list.add(lhv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean updateSLHV(String idLop) {
        int check = 0;
        String query = "Update Lop Set slHocVien = slHocVien + 1 where id = ? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateSLHV2(String idLop) {
        int check = 0;
        String query = "Update Lop Set slHocVien = slHocVien - 1 where id = ? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public NhanVien getOneGV(String maNV) {
        NhanVien nv = new NhanVien();
        String query = "select id,ten,tenDem,ho,email,diaChi,sdt,ngaySinh,trangThai"
                + ",anh,gioiTinh,matKhau,idChucVu,ngayTao,ngaySua "
                + "from NhanVien where maNV = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
                nv.setImg(rs.getString("anh"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    public boolean phanQuyenGV(Lop l, String idGV) {
        int check = 0;
        String query = "Update Lop Set idGiangVien = ? where id = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idGV);
            ps.setObject(2, l.getId());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<NhanVien> getListGV() {
        String query = "select id,maNV,ho,ten,tendem,email,diaChi,sdt,ngaySinh,"
                + "anh,gioiTinh,trangThai,matKhau,idChucVu,ngayTao,ngaySua "
                + "from NhanVien Where idChucVu = 0";
        List<NhanVien> listGV = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
                nv.setImg(rs.getString("anh"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
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
                + "           ,[anh]\n"
                + "           ,[gioiTinh]\n"
                + "           ,[trangThai]\n"
                + "           ,[matKhau]\n"
                + "           ,[idChucVu]\n"
                + "           ,[ngayTao]\n"
                + "           ,[ngaySua])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getHo());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getTen());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(8, nv.getNgaySinh());
            ps.setObject(7, nv.getSdt());
            ps.setObject(9, nv.getImg());
            ps.setObject(10, nv.isGioiTinh());
            ps.setObject(11, nv.getTrangThai());
            ps.setObject(12, "1234");
            ps.setObject(13, 0);
            ps.setObject(14, date);
            ps.setObject(15, date);
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
                + "      ,[anh] = ?\n"
                + "      ,[gioiTinh] = ?\n"
                + " WHERE maNV = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
            ps.setObject(12, nv.getImg());
            ps.setObject(13, nv.isGioiTinh());
            ps.setObject(14, maNV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteGV(String maGV) {
        int check = 0;
        String query = "Delete NhanVien Where maNV = ? and idChucVu = 0";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maGV);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<NhanVien> getListNV() {
        String query = "select id,maNV,ho,ten,tendem,email,diaChi,sdt,ngaySinh,"
                + "anh,gioiTinh,trangThai,matKhau,idChucVu,ngayTao,ngaySua "
                + "from NhanVien";
        List<NhanVien> listNV = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
                nv.setImg(rs.getString("anh"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
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
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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

    public List<MonHoc> getAllMonHoc() {
        List<MonHoc> listMonHoc = new ArrayList<>();
        String query = "select id,idHocKy,tenMon,hocPhi,thoiLuong,trangThai,ngayTao,ngaySua from MonHoc";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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

    public HocKy getHocKyByIdLop(String idLop) {
        String query = "select hk.idHocKy,hk.hocKy,hk.moTa,hk.thoiLuong,hk.trangThai,hk.ngayTao,hk.ngaySua\n"
                + "from lop l join MonHoc mh on l.idMonHoc = mh.id join HocKy hk on mh.idHocKy = hk.idHocKy\n"
                + "where l.id = ? ";
        HocKy hk = new HocKy();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idLop);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hk.setIdHocKy(rs.getString("idHocKy"));
                hk.setHocKy(rs.getInt("hocKy"));
                hk.setMoTa(rs.getString("moTa"));
                hk.setThoiLuong(rs.getString("thoiLuong"));
                hk.setTrangThai(rs.getInt("trangThai"));
                hk.setNgayTao(rs.getDate("ngayTao"));
                hk.setNgaySua(rs.getDate("ngaySua"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hk;
    }

    public List<HocKy> getListHocKy() {
        List<HocKy> listK = new ArrayList<>();
        String query = "select idHocKy,hocKy,moTa,thoiLuong,trangThai,"
                + "ngayTao,ngaySua from HocKy";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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

    public boolean deleteMonHoc(String idMonHoc) {
        int check = 0;
        String query = "Delete From MonHoc Where id = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idMonHoc);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean addLop(Lop lop) {
        long mil = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(mil);
        int check = 0;
        String query = "INSERT INTO [dbo].[Lop]\n"
                + "           ([maLop]\n"
                + "           ,[tenLop]\n"
                + "           ,[slHocVien]\n"
                + "           ,[slToiDa]\n"
                + "           ,[idCa]\n"
                + "           ,[idMonHoc]\n"
                + "           ,[trangThai]\n"
                + "           ,[ngayTao]\n"
                + "           ,[ngaySua])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, lop.getMalop());
            ps.setObject(2, lop.getTenLop());
            ps.setObject(3, 0);
            ps.setObject(4, 40);
            ps.setObject(5, lop.getIdCa());
            ps.setObject(6, lop.getIdMonHoc());
            ps.setObject(7, 0);
            ps.setObject(8, date);
            ps.setObject(9, date);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public MonHoc getMonHoc(String id) {
        String query = "select idHocKy,tenMon,hocPhi,thoiLuong from MonHoc Where id = ?";
        MonHoc mh = new MonHoc();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mh.setId(id);
                mh.setIdHocKy(rs.getString("idHocKy"));
                mh.setTenMon(rs.getString("tenMon"));
                mh.setHocPhi(rs.getBigDecimal("hocPhi"));
                mh.setThoiLuong(rs.getInt("thoiLuong"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return mh;
    }

    public String getTenGV(String id) {
        String query = "select ho,tenDem,ten from NhanVien Where id = ?";
        String tenGV = null;
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenGV = rs.getString("ho") + " " + rs.getString("tenDem") + " " + rs.getString("ten");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tenGV;
    }

    public CaHoc getCaHoc(String id) {
        String query = "select maCa,thoiGian from CaHoc where id = ?";
        CaHoc ch = new CaHoc();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ch.setId(id);
                ch.setMaCa(rs.getString("maCa"));
                ch.setThoiGian(rs.getString("thoiGian"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return ch;
    }

    public String getIdByMaCa(String maCa) {
        String query = "select id from CaHoc where maCa = ?";
        String id = null;
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maCa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public String getIdByTenMon(String tenMon) {
        String query = "select id from MonHoc where tenMon = ?";
        String id = null;
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, tenMon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return id;
    }
}
