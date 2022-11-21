/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.NhanVien;
import service.adminService;
import repository.NhanVienAdminRepository;

/**
 *
 * @author acer
 */
public class adminServiceImpl implements adminService {

    private NhanVienAdminRepository nvrp = new NhanVienAdminRepository();

    @Override
    public boolean updatePass(String newPass, String maNV) {
        return nvrp.updatePassAdmin(newPass, maNV);
    }

    @Override
    public NhanVien getOneAdmin(String ma) {
        return nvrp.getOneAdmin(ma);
    }

    @Override
    public List<NhanVien> getListGV() {
        return nvrp.getListGV();
    }

    @Override
    public List<NhanVien> getListNV() {
        return nvrp.getListNV();
    }

    @Override
    public boolean updateGV(NhanVien nv, String maNV) {
        if (nvrp.updateGV(nv, maNV)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addGV(NhanVien nv) {
        if (nvrp.addGV(nv)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteGV(String maGV) {
        if (nvrp.deleteGV(maGV)) {
            return true;
        } else {
            return false;
        }
    }

}
