/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.NhanVien;

/**
 *
 * @author acer
 */
public interface adminService {

    boolean updatePass(String newPass, String maNV);

    NhanVien getOneAdmin(String ma);

    List<NhanVien> getListGV();

    List<NhanVien> getListNV();

    boolean updateGV(NhanVien nv, String maNV);

    boolean addGV(NhanVien nv);

    boolean deleteGV(String maGV);
}