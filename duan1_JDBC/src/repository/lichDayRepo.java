/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import utilities.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import viewmodel.LichDay;

/**
 *
 * @author HánH
 */
public class lichDayRepo {

    public List<LichDay> getAll(String ma) {
        List<LichDay> ListLD = new ArrayList<>();
        String query = "select Lop.maLop,Lop.tenLop,MonHoc.tenMon,CaHoc.maCa,CaHoc.thoiGian,LichHoc.ngayHoc \n"
                + "from Lop\n"
                + " join MonHoc on Lop.idMonHoc = MonHoc.id\n"
                + " join LichHoc on Lop.id = LichHoc.idLop\n"
                + " join CaHoc on Lop.idCa = CaHoc.id\n"
                + " join NhanVien on Lop.idGiangVien = NhanVien.id\n"
                + " join HocKy on MonHoc.idHocKy = hocKy.idHocKy\n"
                + " where NhanVien.maNv  = ?\n"
                + " group by Lop.maLop,Lop.tenLop,MonHoc.tenMon,CaHoc.maCa,CaHoc.thoiGian,LichHoc.ngayHoc\n"
                + " order by maCa asc";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichDay ld = new LichDay();
                ld.setMaLop(rs.getString("maLop"));
                ld.setTenLop(rs.getString("tenLop"));
                ld.setTenMon(rs.getString("tenMon"));
                ld.setMaCa(rs.getString("maCa"));
                ld.setThoiGian(rs.getString("thoiGian"));
                ld.setNgayHoc(rs.getDate("ngayHoc"));
                ListLD.add(ld);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return ListLD;
    }
}
