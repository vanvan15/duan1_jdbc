/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utilities.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CaHoc;
import model.HocKy;
import model.HocVien;
import model.Lop;
import model.LopHocVien;
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

    public NhanVien getOneAdmin(String maNV) {
        NhanVien nv = new NhanVien();
        String query = "select id,ten,tenDem,ho,email,diaChi,sdt,ngaySinh,trangThai"
                + ",anh,gioiTinh,matKhau,idChucVu,ngayTao,ngaySua "
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, idHV);
            ps.setObject(2, idMonHoc);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteLopHV(String idHV, String idLop) {
        int check = 0;
        String query = "Delete from LopHocVien where idHocVien = ? and idLop = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        List<HocVien> listHV = new NhanVienAdminRepository().getHocVienByIdLop("99108453-7774-46B2-AF94-0D1F9C4AA113");
        listHV.forEach(h -> System.out.printf("\n%s - %s\n", h.getIdHocVien(), h.getTen()));
    }

    public boolean updateTTLop(String idLop) {
        int check = 0;
        String query = "Update Lop Set trangThai = 1 where id = ? ";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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

    public List<HocVien> getHocVien1(String idMH) {
        String query = "select hv.id,hv.maHV,hv.ho,hv.tenDem,hv.ten,hv.email,hv.diaChi,\n"
                + "hv.sdt,hv.ngaySinh,hv.trangThai,hv.matKhau,hv.ngayTao,hv.ngaySua,hv.anh,hv.gioiTinh\n"
                + "from HocVien hv join DongHocPhi dhp on hv.id = dhp.idHocVien join MonHoc mh on\n"
                + "dhp.idMonHoc = mh.id\n"
                + "where mh.id = ? and dhp.trangThai = 1 ";
        List<HocVien> list = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<LopHocVien> getListLopHV() {
        String query = "Select idLopHocVien,idLop,idHocVien,trangThai"
                + " ngayTao,ngaySua from LopHocVien";
        List<LopHocVien> list = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
                + "anh,gioiTinh,trangThai,matKhau,idChucVu,ngayTao,ngaySua "
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

    public HocKy getHocKyByIdLop(String idLop) {
        String query = "select hk.idHocKy,hk.hocKy,hk.moTa,hk.thoiLuong,hk.trangThai,hk.ngayTao,hk.ngaySua\n"
                + "from lop l join MonHoc mh on l.idMonHoc = mh.id join HocKy hk on mh.idHocKy = hk.idHocKy\n"
                + "where l.id = ? ";
        HocKy hk = new HocKy();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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

    public boolean deleteMonHoc(String idMonHoc) {
        int check = 0;
        String query = "Delete From MonHoc Where id = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
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
