/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.ChucVu;
import model.HocVien;
import model.NhanVien;

/**
 *
 * @author Dell
 */
public interface loginService {

    List<NhanVien> getALlNV();

    List<HocVien> getALLHV();

    String getOne(String maNV);

    String getIDNV(String maNV);

    String getIDHV(String maHV);
}
