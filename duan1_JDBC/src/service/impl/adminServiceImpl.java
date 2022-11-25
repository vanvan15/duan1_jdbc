/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.CaHoc;
import model.HocKy;
import model.HocVien;
import model.Lop;
import model.LopHocVien;
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

    @Override
    public boolean addLop(Lop lop) {
        if (nvrp.addLop(lop)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MonHoc getMonHoc(String id) {
        return nvrp.getMonHoc(id);
    }

    @Override
    public CaHoc getCaHoc(String id) {
        return nvrp.getCaHoc(id);
    }

    @Override
    public String getIdByMaCa(String maCa) {
        return nvrp.getIdByMaCa(maCa);
    }

    @Override
    public String getIdByTenMon(String tenMon) {
        return nvrp.getIdByTenMon(tenMon);
    }

    @Override
    public String getTenGV(String id) {
        return nvrp.getTenGV(id);
    }

    @Override
    public NhanVien getOneGV(String maNV) {
        return nvrp.getOneGV(maNV);
    }

    @Override
    public boolean phanQuyenGV(Lop l, String idGV) {
        if (nvrp.phanQuyenGV(l, idGV)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<HocVien> getHocVien1(String idMH) {
        return nvrp.getHocVien1(idMH);
    }

    @Override
    public boolean addLopHv(LopHocVien lv) {
        if (nvrp.addLopHv(lv)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateSLHV(String idLop) {
        if (nvrp.updateSLHV(idLop)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateHV(String id) {
        if (nvrp.updateHV(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<LopHocVien> getListLopHV() {
        return nvrp.getListLopHV();
    }

    @Override
    public HocVien getHVById(String id) {
        return nvrp.getHVById(id);
    }

    @Override
    public List<HocVien> getHocVienByIdLop(String idLop) {
        return nvrp.getHocVienByIdLop(idLop);
    }

    @Override
    public HocKy getHocKyByIdLop(String idLop) {
        return nvrp.getHocKyByIdLop(idLop);
    }

    @Override
    public boolean xoaPhanQuyen(String idLop) {
        return nvrp.xoaPhanQuyen(idLop);
    }

    @Override
    public boolean updateTTLop(String idLop) {
        return nvrp.updateTTLop(idLop);
    }

    @Override
    public boolean updateLop(Lop l) {
        return nvrp.updateLop(l);
    }

    @Override
    public boolean deleteLop(String idLop) {
        return nvrp.deleteLop(idLop);
    }

    @Override
    public boolean deleteLopHV(String idLop) {
        return nvrp.deleteLopHV(idLop);
    }

    @Override
    public boolean addKqht(String idHV, String idMonHoc) {
        return nvrp.addKqht(idHV, idMonHoc);
    }

    @Override
    public boolean deleteKqht(String idHV, String idMonHoc) {
        return nvrp.deleteKqht(idHV, idMonHoc);
    }

    @Override
    public boolean deleteLopHV(String idHV, String idLop) {
        return nvrp.deleteLopHV(idHV, idLop);
    }

    @Override
    public boolean updateSLHV2(String idLop) {
        return nvrp.updateSLHV2(idLop);
    }

    @Override
    public boolean addVi(String idHV) {
        return nvrp.addVi(idHV);
    }
}
