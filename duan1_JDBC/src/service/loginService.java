/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.math.BigDecimal;
import java.util.List;
import model.ChucVu;
import model.DongHocPhi;
import model.HocVien;
import model.MonHoc;
import model.NhanVien;
import viewmodel.DongHoc;
import viewmodel.KetQuaHTHV;
import viewmodel.hocPhi;
import viewmodel.monHocLai;

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

    HocVien getoneHV(String maHV);

    boolean updatePassHV(String passNew, String maHV);

    List<KetQuaHTHV> getKQ(String maHV);

    List<monHocLai> getHocLai(String maHV);

    List<hocPhi> getHocPhi(String maHV);

    String thanhToan(BigDecimal tienHocPhi, String idHV, String idMonHoc);

    String updateVi(BigDecimal tienHocPhi, String idHV);

    BigDecimal getSoDuVI(String id);

    List<DongHoc> listDong(String id);

    List<DongHoc> listDKHL(String id);

    List<DongHocPhi> listDongHP(String id);

    String thanhtoan1(BigDecimal tienHocPhi, String idHV, String idMonHoc);

    String updateHocVien(String id);

    List<MonHoc> listMon(int row);

    List<MonHoc> listMon1();

    List<MonHoc> listSearch(String fullName);

    String naptien(String idHV, BigDecimal napTien);
}
