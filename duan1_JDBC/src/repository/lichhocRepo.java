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
import utilities.DBContext;
import viewmodel.lichhocVD;

/**
 *
 * @author HánH
 */
public class lichhocRepo {

    public List<lichhocVD> getAll(String ma) {
        String query = "select LichHoc.ngayHoc,MonHoc.tenMon,lop.maLop,Lop.tenLop,CaHoc.maCa,\n"
                + "  nhanvien.ho,nhanvien.tendem,nhanvien.ten,CaHoc.thoiGian\n"
                + "  from \n"
                + "  Lop join LichHoc on Lop.id= LichHoc.idLop\n"
                + "  join MonHoc on Lop.idMonHoc = MonHoc.id\n"
                + "  join CaHoc on Lop.idCa = CaHoc.id\n"
                + "  join NhanVien on Lop.idGiangVien = NhanVien.id \n"
                + "  join LopHocVien on Lop.id = LopHocVien.idLop\n"
                + "  join HocVien on LopHocVien.idHocVien = HocVien.id\n"
                + "  where HocVien.maHV = ?\n"
                + "  group by LichHoc.ngayHoc,MonHoc.tenMon,lop.maLop,Lop.tenLop,CaHoc.maCa,\n"
                + "  nhanvien.ho,nhanvien.tendem,nhanvien.ten ,CaHoc.thoiGian\n"
                + "  order by maCa asc";
        List<lichhocVD> ListLHVD = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lichhocVD lhVD = new lichhocVD();
                lhVD.setNgayHoc(rs.getDate("ngayHoc"));
                lhVD.setTenMon(rs.getString("tenMon"));
                lhVD.setMaLop(rs.getString("maLop"));
                lhVD.setTenLop(rs.getString("tenLop"));
                lhVD.setMaCa(rs.getString("maCa"));
                lhVD.setHoGV(rs.getString("ho"));
                lhVD.setTenDemGV(rs.getString("tenDem"));
                lhVD.setTenGV(rs.getString("ten"));
                lhVD.setThoiGian(rs.getString("thoiGian"));
                ListLHVD.add(lhVD);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return ListLHVD;
    }
}
