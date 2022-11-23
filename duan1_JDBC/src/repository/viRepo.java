/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Vi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.DBContext;

/**
 *
 * @author HánH
 */
public class viRepo {

    public Vi getOne(String id) {
        String query = "select*from Vi where idHocVien = ?";
        Vi v = new Vi();
        try ( Connection conn = DBContext.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                v.getIdVi();
                v.getIdHocVien();
                v.setSoDuVi(rs.getBigDecimal(3));
            }
            return v;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String getIDHocVien(String ma) {
        String id = null;
        String query = "select Id from HocVien where maHV = ?";
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

    public boolean updateV(String id, Vi v) {
        String query = "Update Vi SET soDuVi = ? where idHocVien = ?";
        int check = 0;
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, v.getSoDuVi());
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
