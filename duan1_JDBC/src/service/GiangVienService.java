/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.NhanVien;

/**
 *
 * @author Nguyễn Thắng
 */
public interface GiangVienService {

    List<NhanVien> getAll();

    String updateNv(String maNV, NhanVien nv);

    NhanVien getOne(String maNV);
    
    boolean updatePassGv(String passNew, String maNV);
}
