/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.math.BigDecimal;
import java.util.List;
import model.ChucVu;
import model.DongHocPhi;
import model.HocVien;
import model.MonHoc;
import model.NhanVien;
import repository.loginRepo;
import service.loginService;
import viewmodel.DongHoc;
import viewmodel.KetQuaHTHV;
import viewmodel.hocPhi;
import viewmodel.monHocLai;

/**
 *
 * @author Dell
 */
public class loginImpl implements loginService {

    loginRepo login = new loginRepo();

    @Override
    public String getOne(String maNV) {
        return login.getOne(maNV);
    }

    @Override
    public List<NhanVien> getALlNV() {
        return login.getALLNV();
    }

    @Override
    public List<HocVien> getALLHV() {
        return login.getALLHV();
    }

    @Override
    public String getIDNV(String maNV) {
        return login.getIDNV(maNV);
    }

    @Override
    public String getIDHV(String maHV) {
        return login.getIDHocVien(maHV);
    }

    @Override
    public boolean updatePassHV(String passNew, String maHV) {
        return login.updatePassHocVien(passNew, maHV);
    }

    @Override
    public List<KetQuaHTHV> getKQ(String maHV) {
        return login.getKQHT(maHV);
    }

    @Override
    public List<monHocLai> getHocLai(String maHV) {
        return login.getHocLai(maHV);
    }

    @Override
    public List<hocPhi> getHocPhi(String maHV) {
        return login.getALLHocPhi(maHV);
    }

    @Override
    public BigDecimal getSoDuVI(String id) {
        return login.getSoDuVi(id);
    }

    @Override
    public List<DongHoc> listDong(String id) {
        return login.listDH(id);
    }
// check thanh toan đóng học phí

    @Override
    public String thanhToan(BigDecimal tienHocPhi, String idHV, String idMonHoc) {
        boolean thanhToan = login.thanhToanHocPhi(tienHocPhi, idHV, idMonHoc);
        if (thanhToan) {
            return "Thanh toán Thành Công";
        } else {
            return "Thanh không toán Thành Công";
        }
    }
// update lại số dư ví khi đk

    @Override
    public String updateVi(BigDecimal tienHocPhi, String idHV) {
        boolean thanhToan = login.updateSoDuVi(tienHocPhi, idHV);
        if (thanhToan) {
            return "Cập Nhật Số Dư Ví Thành Công";
        } else {
            return "Cập Nhật Số Dư Ví toán Thành Công";
        }
    }
// check thanh toan đk học lại

    @Override
    public String thanhtoan1(BigDecimal tienHocPhi, String idHV, String idMonHoc) {
        boolean thanhToan1 = login.thanhToanHocPhi1(tienHocPhi, idHV, idMonHoc);
        if (thanhToan1) {
            return "Thanh toán Thành Công";
        } else {
            return "Thanh không toán Thành Công";
        }
    }
    // dong hoc phí

    @Override
    public List<DongHocPhi> listDongHP(String id) {
        return login.listDongPhi(id);
    }

    @Override
    public String updateHocVien(String id) {
        boolean update = login.updateHocVien(id);
        if (update) {
            return "update thanh cong";
        } else {
            return "update khong thanh cong";
        }
    }
    // list các môn học phân trang

    @Override
    public List<MonHoc> listMon(int row) {
        return login.listMonHoc(row);
    }
    // list các môn học 

    @Override
    public List<MonHoc> listMon1() {
        return login.listMonHoc1();
    }

    @Override
    public List<MonHoc> listSearch(String fullName) {
        return login.findByFullname(fullName);
    }
    // list lịch sử các môm học lại với tt = 2

    @Override
    public List<DongHoc> listDKHL(String id) {
        return login.listDKHL(id);
    }

    @Override
    public String naptien(String idHV, BigDecimal napTien) {
        boolean update = login.napTien(idHV, napTien);
        if (update) {
            return "Nạp tiên thành công";
        } else {
            return "Nạp không tiên thành công";

        }
    }

    @Override
    public HocVien getoneHV(String maHV) {
        return login.getOneHV(maHV);
    }

}
