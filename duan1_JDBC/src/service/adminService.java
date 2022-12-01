/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.math.BigDecimal;
import java.util.List;
import model.CaHoc;
import model.DongHocPhi;
import model.HocKy;
import model.HocVien;
import model.LichHoc;
import model.Lop;
import model.LopHocVien;
import model.MonHoc;
import model.NhanVien;
import viewmodel.thongKeViewModel1;
import viewmodel.thongKeViewModel2;

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

    List<Lop> getListLop();

    List<CaHoc> getListCaHoc();

    List<MonHoc> getListMonHoc();

    List<HocKy> getListHocKy();

    List<HocKy> sortHocKy(List<HocKy> list);

    HocKy getHocKy(String id);

    String getIdHocKi(int hocki);

    boolean updateMonHoc(String id, MonHoc mh);

    boolean addMonHoc(MonHoc mh);

    boolean deleteMonHoc(String idMonHoc);

    boolean addLop(Lop lop);

    MonHoc getMonHoc(String id);

    CaHoc getCaHoc(String id);

    String getIdByMaCa(String maCa);

    String getIdByTenMon(String tenMon);

    String getTenGV(String id);

    NhanVien getOneGV(String maNV);

    boolean phanQuyenGV(Lop l, String idGV);

    List<HocVien> getHocVien1(String idMH);

    boolean addLopHv(LopHocVien lv);

    boolean updateSLHV(String idLop);

    boolean updateHV(String id);

    List<LopHocVien> getListLopHV();

    HocVien getHVById(String id);

    List<HocVien> getHocVienByIdLop(String idLop);

    HocKy getHocKyByIdLop(String idLop);

    boolean xoaPhanQuyen(String idLop);

    boolean updateTTLop(String idLop);

    boolean updateLop(Lop l);

    boolean deleteLop(String idLop);

    boolean deleteLopHV(String idLop);

    boolean addKqht(String idHV, String idMonHoc);

    boolean deleteKqht(String idHV, String idMonHoc);

    boolean deleteLopHV(String idHV, String idLop);

    boolean updateSLHV2(String idLop);

    boolean addVi(String idHV);

    List<LichHoc> getListLichHoc(String idLop);

    NhanVien getGVByIdLop(String idLop);

    CaHoc getCaHocByIdLop(String idLop);

    MonHoc getMonHocByIdLop(String idLop);

    boolean addLichHoc(LichHoc lh);

    boolean updateLichHoc(LichHoc lh);

    boolean checkLH(LichHoc lh);

    boolean updateTTDHP(String idHocVien, String idMH);

    List<MonHoc> listPTMonHoc(int pageIndex, int pageNumber);

    List<HocVien> listPTHocVien(int pageIndex, int pageNumber);

    List<HocVien> getAllHocVien();

    boolean addDHP(DongHocPhi dhp);

    boolean updateTTHV(String idHV);

    List<DongHocPhi> getListDHP();

    boolean updateTTDHP1(String idHV, String idMonHoc);

    boolean deleteLH(String idLH);

    MonHoc getMHByID(String id);

    List<DongHocPhi> getListPTDHP(int pageIndex, int pageNumber);

    List<MonHoc> listSearchMonHoc(String text);

    BigDecimal thongKeTongTien();

    int tkSLHV();

    List<NhanVien> listPTGV(int pageIndex, int pageNum);

    List<NhanVien> listSearchGV(String text);

    List<thongKeViewModel1> tKHPHV();
    
    List<thongKeViewModel2> tKHPMH();
}
