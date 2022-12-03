/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilities.DBContext;
import viewmodel.QLLopGV;

/**
 *
 * @author HánH
 */
public class qlLopRepo {

    public List<QLLopGV> getAll(String ma) {
        List<QLLopGV> ListL = new ArrayList<>();
        String query = "select mh.tenMon,l.maLop,l.slHocVien,l.slToiDa\n"
                + "from NhanVien nv join Lop l on nv.id = l.idGiangVien\n"
                + "join MonHoc mh on l.idMonHoc = mh.id\n"
                + "where nv.maNV = ?\n"
                + "group by mh.tenMon,l.maLop,l.slHocVien,l.slToiDa\n"
                + "order by l.maLop asc";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLLopGV dr = new QLLopGV();
                dr.setTenMon(rs.getString("tenMon"));
                dr.setMaLop(rs.getString("maLop"));
                dr.setSlHocVien(rs.getInt("slHocVien"));
                dr.setSlToiDa(rs.getInt("slToiDa"));
                ListL.add(dr);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return ListL;
    }

    public List<QLLopGV> getOne(String maL, String MaGV) {
        String query = "select mh.tenMon,l.maLop,l.slHocVien,l.slToiDa from NhanVien nv "
                + "join Lop l on nv.id = l.idGiangVien\n"
                + "                join MonHoc mh on l.idMonHoc = mh.id\n"
                + "                 where l.maLop like N'%" + maL + "%' and nv.maNV = ?\n"
                + "                 group by mh.tenMon,l.maLop,l.slHocVien,l.slToiDa\n"
                + "                 order by l.maLop asc";
        List<QLLopGV> list = new ArrayList<>();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, MaGV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLLopGV dr = new QLLopGV();
                dr.setTenMon(rs.getString("tenMon"));
                dr.setMaLop(rs.getString("maLop"));
                dr.setSlHocVien(rs.getInt("slHocVien"));
                dr.setSlToiDa(rs.getInt("slToiDa"));
                list.add(dr);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

}
