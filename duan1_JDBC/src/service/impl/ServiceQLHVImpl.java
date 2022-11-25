/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.HocVien;
import repository.QLHocVienRepository;
import service.ServiceQLHV;

/**
 *
 * @author Tran Duc Do
 */
public class ServiceQLHVImpl implements ServiceQLHV {

    private QLHocVienRepository qlhvr = new QLHocVienRepository();

    @Override
    public List<HocVien> GetAllDaTa() {
        return qlhvr.GetAllDaTa();
    }

    @Override
    public boolean addhv(HocVien hocVien) {
        if (qlhvr.addhv(hocVien)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateHv(HocVien hocVien, String ma) {
        if (qlhvr.updateHv(hocVien, ma)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean Delete(String ma) {
        boolean Delete = qlhvr.Delete(ma);
        if (Delete) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addVi(String idHV) {
        return qlhvr.addVi(idHV);
    }

    @Override
    public HocVien getOne(String maHV) {
        return qlhvr.getOne(maHV);
    }

    @Override
    public boolean deleteKqht(String idHV) {
        return qlhvr.deleteKqht(idHV);
    }

    @Override
    public boolean deleteLopHV(String idHV) {
        return qlhvr.deleteLHV(idHV);
    }

    @Override
    public boolean deleteVi(String id) {
        return qlhvr.deleteVi(id);
    }

    @Override
    public boolean deleteDHP(String id) {
        return qlhvr.deleteDHP(id);
    }

    @Override
    public boolean deleteDKHocLai(String id) {
        return qlhvr.deleteDKHocLai(id);
    }

}
