/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.CaHoc;
import model.HocKy;
import model.Lop;
import model.MonHoc;
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

    @Override
    public List<Lop> getListLop() {
        return nvrp.getListLop();
    }

    @Override
    public List<CaHoc> getListCaHoc() {
        return nvrp.getListCaHoc();
    }

    @Override
    public List<MonHoc> getListMonHoc() {
        return nvrp.getListMonHoc();
    }

    @Override
    public List<HocKy> getListHocKy() {
        return nvrp.getListHocKy();
    }

    @Override
    public List<HocKy> sortHocKy(List<HocKy> list) {
        list.sort((o1, o2) -> {
            Integer i1 = o1.getHocKy();
            Integer i2 = o2.getHocKy();
            return i1.compareTo(i2);
        });
        return list;
    }

    @Override
    public HocKy getHocKy(String id) {
        return nvrp.getHocKy(id);
    }

    @Override
    public String getIdHocKi(int hocki) {
        return nvrp.getIdHocKi(hocki);
    }

    @Override
    public boolean updateMonHoc(String id, MonHoc mh) {
        if (nvrp.updateMonHoc(id, mh)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addMonHoc(MonHoc mh) {
        if (nvrp.addMonHoc(mh)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteMonHoc(String idMonHoc) {
        if (nvrp.deleteMonHoc(idMonHoc)) {
            return true;
        } else {
            return false;
        }
    }
}
