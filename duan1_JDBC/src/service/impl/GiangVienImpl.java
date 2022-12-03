/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import javax.swing.JOptionPane;
import model.NhanVien;
import repository.GiangVienRepo;
import service.GiangVienService;

/**
 *
 * @author Nguyễn Thắng
 */
public class GiangVienImpl implements GiangVienService{
    private GiangVienRepo nvrp = new GiangVienRepo();
    
    @Override
    public List<NhanVien> getAll() {
        return nvrp.getAll();
    }

    public String updateNv(String maNV, NhanVien nv) {
        boolean upNv = nvrp.updateNV(maNV, nv);
        if (upNv) {
            return "Cập nhập thành công";
        }else{
            return "Cập nhập thất bại";
        }
    }

    @Override
    public NhanVien getOne(String maNV) {
        return nvrp.getOne(maNV);
    }
    
}
